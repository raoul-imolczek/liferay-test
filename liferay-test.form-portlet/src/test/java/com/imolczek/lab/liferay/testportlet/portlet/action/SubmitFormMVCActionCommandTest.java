package com.imolczek.lab.liferay.testportlet.portlet.action;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.imolczek.lab.liferay.applicantservice.model.Applicant;
import com.imolczek.lab.liferay.applicantservice.service.ApplicantLocalService;
import com.imolczek.lab.liferay.testportlet.configuration.exceptions.ApplicationFormDataValidationException;
import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.imolczek.lab.liferay.testportlet.email.ConfirmationEmailLocalService;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ParamUtil.class, PropsUtil.class, CaptchaUtil.class, SessionErrors.class})
public class SubmitFormMVCActionCommandTest {

	private SubmitFormMVCActionCommand command;
	private ActionRequest actionRequest;
	private ActionResponse actionResponse;
	private ApplicantLocalService applicantLocalService;
	private CounterLocalService counterLocalService;
	private ConfirmationEmailLocalService confirmationEmailLocalService;
	private long applicantId;
	private Applicant applicant;
	
    /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
		this.command = new SubmitFormMVCActionCommand();
		// Using Mockito to mock an actionRequest
		this.actionRequest = mock(ActionRequest.class);

		// Using Mockito to mock an actionResponse
		this.actionResponse = mock(ActionResponse.class);
		when(actionResponse.getRenderParameters()).thenReturn(mock(MutableRenderParameters.class));
		
		// Using Powermock to mock PropsUtil
		PowerMockito.mockStatic(PropsUtil.class);
		when(PropsUtil.get(PropsKeys.UNICODE_TEXT_NORMALIZER_FORM)).thenReturn("NFC");

		// Using Powermock to mock ParamUtil
		PowerMockito.mockStatic(ParamUtil.class);

		// Using Powermock to mock CaptchaUtil
		PowerMockito.mockStatic(CaptchaUtil.class);

		// Using Powermock to mock SessionErrors
		PowerMockito.mockStatic(SessionErrors.class);

		// Mocking osgi components
		this.applicantLocalService = mock(ApplicantLocalService.class);
		this.command.setApplicantLocalService(this.applicantLocalService);
		this.counterLocalService = mock(CounterLocalService.class);
		this.command.setCounterLocalService(this.counterLocalService);
		this.confirmationEmailLocalService = mock(ConfirmationEmailLocalService.class);
		this.command.setConfirmationEmailLocalService(this.confirmationEmailLocalService);

		this.applicantId = 1234;
		when(counterLocalService.increment()).thenReturn(applicantId);

		this.applicant = mock(Applicant.class);

		when(applicantLocalService.createApplicant(this.applicantId)).thenReturn(this.applicant);
		when(applicantLocalService.addApplicant(this.applicant)).thenReturn(this.applicant);
    }
    
	@Test
	public void testCorrectInputData() {

		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_NAME, "")).thenReturn("John");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_SURNAME, "")).thenReturn("Doe");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_BIRTHDATE, "")).thenReturn("1980-01-01");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_EMAIL, "")).thenReturn("john.doe@liferay.com");
		
		try {
			command.doProcessAction(actionRequest, actionResponse);
		} catch (Exception e) {
			e.printStackTrace();
			fail("This test case is not supposed to raise an exception");
		}
	}

	@Test
	public void testApplicationFormDataValidationException() {

		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_NAME, "")).thenReturn("John");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_SURNAME, "")).thenReturn("Doe");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_BIRTHDATE, "")).thenReturn("1980-01-01");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_EMAIL, "")).thenReturn("");

		try {
			command.doProcessAction(actionRequest, actionResponse);
		} catch (ApplicationFormDataValidationException e) {
			// This is correct
			return;
		} catch (Exception e) {
			e.printStackTrace();
			fail("This test case is not supposed to raise another exception than ApplicationFormDataValidationException");
		}

		fail("This test case was supposed to raise a ApplicationFormDataValidationException");

	}

	@Test
	public void testIncorrectCaptcha() {

		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_NAME, "")).thenReturn("John");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_SURNAME, "")).thenReturn("Doe");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_BIRTHDATE, "")).thenReturn("1980-01-01");
		when(ParamUtil.get(actionRequest, TestFormPortletKeys.APPLICANT_EMAIL, "")).thenReturn("john.doe@liferay.com");

		try {
			PowerMockito.doThrow(new CaptchaTextException()).when(CaptchaUtil.class, "check", actionRequest);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to mock CaptchaUtil");
		}
		
		try {
			command.doProcessAction(actionRequest, actionResponse);
		} catch (CaptchaTextException e) {
			// This is correct
			return;
		} catch (Exception e) {
			e.printStackTrace();
			fail("This test case is not supposed to raise another exception than CaptchaTextException");
		}

		fail("This test case was supposed to raise a ApplicationFormDataValidationException");

	}	
}
