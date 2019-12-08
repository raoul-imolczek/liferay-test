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

		String applicantName = getApplicantName(actionRequest);
		String applicantSurname = getApplicantSurname(actionRequest);
		String applicantEmail = getApplicantEmail(actionRequest);
		Date applicantBirthDate = getApplicantBirthDate(actionRequest);
		Date applicationSubmissionDate = Calendar.getInstance().getTime();;
				
		checkCaptcha(actionRequest);

		actionRequest.setAttribute(TestFormPortletKeys.CAPTCHA_INVALID, false);

		persistApplicant(applicantName, applicantSurname, applicantEmail, applicantBirthDate, applicationSubmissionDate);
		
		sendConfirmationEmail(actionRequest, applicantName, applicantSurname, applicantEmail);
		
	}

	private void sendConfirmationEmail(ActionRequest actionRequest, String applicantName, String applicantSurname, String applicantEmail) {
		try {
			confirmationEmailLocalService.sendConfirmationEmail(applicantEmail, applicantName, applicantSurname);
		} catch (AddressException ae) {
			LOG.warn("Address exception while sending confirmation email");
		} catch (ConfirmationEmailConfigurationException cece) {
			LOG.warn("Configuration exception while sending confirmation email");
		}
	}
	
	private String getApplicantEmail(ActionRequest actionRequest) throws PortletException {
		String applicantEmail = ParamUtil.get(actionRequest, "email", "");
		if("".equals(applicantEmail)) {
			LOG.info("The user submitted an empty email");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Empty applicant email");			
		} else if (!Validator.isEmailAddress(applicantEmail)){
			LOG.info("The submitted email is invalid");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Invalid email");			
		}
		return applicantEmail;
	}

	private String getApplicantSurname(ActionRequest actionRequest) throws PortletException {
		String applicantSurname = ParamUtil.get(actionRequest, "surname", "");
		if("".equals(applicantSurname)) {
			LOG.info("The user submitted an empty surname");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Empty applicant surname");			
		}		
		return applicantSurname;
	}

	private String getApplicantName(ActionRequest actionRequest) throws PortletException {
		String applicantName = ParamUtil.get(actionRequest, "name", "");
		if("".equals(applicantName)) {
			LOG.info("The user submitted an empty name");
			SessionErrors.add(actionRequest, PortletException.class.getName());
			throw new PortletException("Empty applicant name");			
		}		
		return applicantName;
	}

	private Date getApplicantBirthDate(ActionRequest actionRequest) throws ParseException, PortletException {
		
		String applicantBirthDateString = ParamUtil.get(actionRequest, "birthdate", "");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date applicantBirthDate;
		
		try {
			applicantBirthDate = format.parse(applicantBirthDateString);
		} catch (ParseException pe) {
			LOG.info("The user submitted an invalid birth date");
			SessionErrors.add(actionRequest, ParseException.class.getName());
			throw pe;
		}
				
		return applicantBirthDate;
	}

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
