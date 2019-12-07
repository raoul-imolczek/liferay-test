package com.imolczek.lab.liferay.testportlet.portlet.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.applicantservice.model.Applicant;
import com.imolczek.lab.liferay.applicantservice.service.ApplicantLocalService;
import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
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

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String applicantName = ParamUtil.get(actionRequest, "name", "");
		String applicantSurname = ParamUtil.get(actionRequest, "name", "");
		String applicantEmail = ParamUtil.get(actionRequest, "email", "");
		String applicantBirthDateString = ParamUtil.get(actionRequest, "birthdate", "");
		Date applicantBirthDate = format.parse(applicantBirthDateString);
		Date applicationSubmissionDate = Calendar.getInstance().getTime();;
				
		try {
			CaptchaUtil.check(actionRequest);
		}
		catch (CaptchaTextException cte) {
			LOG.info("The user submitted an invalid captcha");
			actionRequest.setAttribute(TestFormPortletKeys.CAPTCHA_INVALID, true);
			SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
			throw cte;
		}

		actionRequest.setAttribute(TestFormPortletKeys.CAPTCHA_INVALID, false);

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
}
