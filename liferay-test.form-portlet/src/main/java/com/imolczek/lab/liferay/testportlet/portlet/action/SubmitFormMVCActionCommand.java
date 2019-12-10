package com.imolczek.lab.liferay.testportlet.portlet.action;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.applicantservice.model.Applicant;
import com.imolczek.lab.liferay.applicantservice.service.ApplicantLocalService;
import com.imolczek.lab.liferay.testportlet.configuration.exceptions.ApplicationFormDataValidationException;
import com.imolczek.lab.liferay.testportlet.configuration.exceptions.ConfirmationEmailConfigurationException;
import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.imolczek.lab.liferay.testportlet.email.ConfirmationEmailLocalService;
import com.imolczek.lab.liferay.testportlet.portlet.action.model.SubmitFormData;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + TestFormPortletKeys.TESTFORM,
	        "mvc.command.name=" + TestFormPortletKeys.SUBMIT_FORM_ACTION
	    },
	    service = MVCActionCommand.class
	)
public class SubmitFormMVCActionCommand extends BaseMVCActionCommand {

	private static final Logger LOG = LoggerFactory.getLogger(SubmitFormMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		// Fetch form data from action request (may raise a ParseException on the birth date)
		SubmitFormData submitFormData = getSubmitFormData(actionRequest);
		
		// And validate the data (may raise an ApplicationFormDataValidationException)
		validateFormData(actionRequest, submitFormData);
		
		// Setting variables for validated form data
		String applicantName = submitFormData.getName();
		String applicantSurname = submitFormData.getSurname();
		String applicantEmail = submitFormData.getEmail();
		Date applicantBirthDate = submitFormData.getBirthdate();
		
		// Compute today's date
		Date applicationSubmissionDate = Calendar.getInstance().getTime();
				
		// Check the captcha and raise an exception on failure
		checkCaptcha(actionRequest);

		// Assume the captcha is valid (hiding a message on the JSP)
		actionRequest.setAttribute(TestFormPortletKeys.CAPTCHA_INVALID, false);

		// Persist the applicant's information as a new record
		persistApplicant(applicantName, applicantSurname, applicantEmail, applicantBirthDate, applicationSubmissionDate);
		
		// Send a confirmation email
		// If this operation fails, no alert feedback to the users but WARN in the logs
		sendConfirmationEmail(applicantName, applicantSurname, applicantEmail);
		
		// Set email as an attribute to display on the confirmation JSP
		actionRequest.setAttribute(TestFormPortletKeys.APPLICANT_EMAIL, applicantEmail);
		actionResponse.getRenderParameters().setValue("jspPage", "/confirmation.jsp");
	}

	/**
	 * Validate form data (apply rules)
	 * @param actionRequest to add Session Errors to be displayed
	 * @param submitFormData the form data to validate
	 */
	private void validateFormData(ActionRequest actionRequest, SubmitFormData submitFormData) {
		try {
			submitFormData.validate();
		} catch (ApplicationFormDataValidationException afdve) {
			SessionErrors.add(actionRequest, ParseException.class.getName());
			LOG.info("The user submitted invalid data");
			throw afdve;
		}
	}

	/**
	 * Get form data from action request input
	 * @param actionRequest the action request bearing the form input data
	 * @return A SubmitFormData object
	 * @throws ParseException If the birth date is not parseable
	 */
	private SubmitFormData getSubmitFormData(ActionRequest actionRequest) throws ParseException {
		
		// Use ParamUtil to fetch form data from action request and fill missing input fields with ""
		String formDataName = ParamUtil.get(actionRequest, "name", "");
		String formDataSurname = ParamUtil.get(actionRequest, "surname", "");
		String formDataBirthDate = ParamUtil.get(actionRequest, "birthdate", "");
		String formDataEmail = ParamUtil.get(actionRequest, "email", "");
		
		SubmitFormData submitFormData;
		
		// Get the applicant's information from the form POST 
		try {
			submitFormData = new SubmitFormData(formDataName, formDataSurname, formDataBirthDate, formDataEmail);
		} catch (ParseException pe) {
			SessionErrors.add(actionRequest, ParseException.class.getName());
			LOG.info("The user submitted an invalid date");
			throw pe;
		}
		return submitFormData;
	}

	/**
	 * Send a confirmation email
	 * @param applicantName The applicant's name
	 * @param applicantSurname The applicant's surname
	 * @param applicantEmail The applicant's email
	 */
	private void sendConfirmationEmail(String applicantName, String applicantSurname, String applicantEmail) {
		try {
			// Calling the confirmation email service
			confirmationEmailLocalService.sendConfirmationEmail(applicantEmail, applicantName, applicantSurname);
		} catch (AddressException ae) {
			LOG.warn("Address exception while sending confirmation email");
		} catch (ConfirmationEmailConfigurationException cece) {
			LOG.warn("Configuration exception while sending confirmation email");
		}
	}
	
	/**
	 * Check if the captcha is valid
	 * @param actionRequest
	 * @throws CaptchaException
	 * @throws CaptchaTextException
	 */
	private void checkCaptcha(ActionRequest actionRequest) throws CaptchaException, CaptchaTextException {
		try {
			CaptchaUtil.check(actionRequest);
		}
		catch (CaptchaTextException cte) {
			LOG.info("The user submitted an invalid captcha");
			actionRequest.setAttribute(TestFormPortletKeys.CAPTCHA_INVALID, true);
			SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
			throw cte;
		}
	}

	/**
	 * Persist the applicant's registration
	 * @param applicantName
	 * @param applicantSurname
	 * @param applicantEmail
	 * @param applicantBirthDate
	 * @param applicationSubmissionDate
	 */
	private void persistApplicant(String applicantName, String applicantSurname, String applicantEmail, Date applicantBirthDate, Date applicationSubmissionDate) {
		Applicant applicant = applicantLocalService.createApplicant(counterLocalService.increment());
		applicant.setApplicantName(applicantName);
		applicant.setApplicantSurname(applicantSurname);
		applicant.setApplicantEmail(applicantEmail);
		applicant.setApplicantBirthDate(applicantBirthDate);
		applicant.setApplicationSubmissionDate(applicationSubmissionDate);
		applicantLocalService.addApplicant(applicant);
	}
	
	private ApplicantLocalService applicantLocalService;

	@Reference
	public void setApplicantLocalService(ApplicantLocalService applicantLocalService) {
		this.applicantLocalService = applicantLocalService;
	}
	
	private CounterLocalService counterLocalService;
	
	@Reference
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	private ConfirmationEmailLocalService confirmationEmailLocalService;
	
	@Reference
	public void setConfirmationEmailLocalService(ConfirmationEmailLocalService confirmationEmailLocalService) {
		this.confirmationEmailLocalService = confirmationEmailLocalService;
	}

}
