package com.imolczek.lab.liferay.testportlet.portlet.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.applicantservice.model.Applicant;
import com.imolczek.lab.liferay.applicantservice.service.ApplicantLocalService;
import com.imolczek.lab.liferay.testportlet.configuration.exceptions.ConfirmationEmailConfigurationException;
import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.imolczek.lab.liferay.testportlet.email.ConfirmationEmailLocalService;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

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

		// Get the applicant's information from the form POST and validate the data
		// Any of those methods may raise an exception
		String applicantName = getApplicantName(actionRequest);
		String applicantSurname = getApplicantSurname(actionRequest);
		String applicantEmail = getApplicantEmail(actionRequest);
		Date applicantBirthDate = getApplicantBirthDate(actionRequest);
		
		// Compute today's date
		Date applicationSubmissionDate = Calendar.getInstance().getTime();;
				
		// Check the captcha and raise an exception on failure
		checkCaptcha(actionRequest);

		// Assume the captcha is valid (hiding a message on the JSP)
		actionRequest.setAttribute(TestFormPortletKeys.CAPTCHA_INVALID, false);

		// Persist the applicant's information as a new record
		persistApplicant(applicantName, applicantSurname, applicantEmail, applicantBirthDate, applicationSubmissionDate);
		
		// Send a confirmation email
		// If this operation fails, no alert feedback to the users but WARN in the logs
		sendConfirmationEmail(applicantName, applicantSurname, applicantEmail);
		
		// Set email as an attribute to dispplay on the confirmation JSP
		actionRequest.setAttribute(TestFormPortletKeys.APPLICANT_EMAIL, applicantEmail);
		actionResponse.getRenderParameters().setValue("jspPage", "/confirmation.jsp");
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
	 * Get the email address from the action request
	 * @param actionRequest
	 * @return the email address
	 * @throws PortletException
	 */
	private String getApplicantEmail(ActionRequest actionRequest) throws PortletException {
		String applicantEmail = ParamUtil.get(actionRequest, "email", "");
		
		// Check if the applicant email is not empty
		if("".equals(applicantEmail)) {
			LOG.info("The user submitted an empty email");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Empty applicant email");			
			
		// Check if the email address is valid
		} else if (!Validator.isEmailAddress(applicantEmail)){
			LOG.info("The submitted email is invalid");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Invalid email");			
		}
		
		return applicantEmail;
	}

	/**
	 * Get the applicant's surname from the action request
	 * @param actionRequest
	 * @return
	 * @throws PortletException
	 */
	private String getApplicantSurname(ActionRequest actionRequest) throws PortletException {
		String applicantSurname = ParamUtil.get(actionRequest, "surname", "");
		
		// Check if the applicant's surname is empty
		if("".equals(applicantSurname)) {
			LOG.info("The user submitted an empty surname");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Empty applicant surname");			
		}		
		
		return applicantSurname;
	}

	/**
	 * Get the applicant's name from the action request
	 * @param actionRequest
	 * @return
	 * @throws PortletException
	 */
	private String getApplicantName(ActionRequest actionRequest) throws PortletException {
		String applicantName = ParamUtil.get(actionRequest, "name", "");
		
		// Check if the applicant's name is empty
		if("".equals(applicantName)) {
			LOG.info("The user submitted an empty name");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Empty applicant name");			
		}		
		
		return applicantName;
	}

	/**
	 * Get the applicant's birth date from the action request
	 * @param actionRequest
	 * @return
	 * @throws ParseException
	 * @throws PortletException
	 */
	private Date getApplicantBirthDate(ActionRequest actionRequest) throws ParseException, PortletException {
		
		String applicantBirthDateString = ParamUtil.get(actionRequest, "birthdate", "");

		// This is the expected format of the birth date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date applicantBirthDate;
		
		// Try to parse the birth date
		try {
			applicantBirthDate = format.parse(applicantBirthDateString);
		} catch (ParseException pe) {
			LOG.info("The user submitted an invalid birth date");
			SessionErrors.add(actionRequest, ParseException.class.getName());
			throw pe;
		}
				
		return applicantBirthDate;
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
	
	@Reference
	private ApplicantLocalService applicantLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ConfirmationEmailLocalService confirmationEmailLocalService;
}
