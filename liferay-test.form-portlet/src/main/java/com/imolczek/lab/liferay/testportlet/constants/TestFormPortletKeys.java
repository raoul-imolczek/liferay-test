package com.imolczek.lab.liferay.testportlet.constants;

/**
 * @author Fabian Bouché
 */
public class TestFormPortletKeys {

	/**
	 * Test Form Portlet name
	 */
	public static final String TESTFORM = "com_imolczek_lab_liferay_testportlet_TestFormPortlet";
	
	// Portlet Actions
	
	/**
	 * Submit Action
	 */
	public static final String SUBMIT_FORM_ACTION = "/form/submitFormAction";
	
	// Portlet Resources
	
	/**
	 * Captcha Resource ID
	 */
	public static final String CAPTCHA_RESOURCE_ID = "/form/captcha";
	
	// Configuration
	
	public static final String CONFIRMATION_EMAIL_CONFIGURATION_PID = "com.imolczek.lab.liferay.testportlet.configuration.ConfirmationEmailConfiguration";
	
	// Attributes
	
	/**
	 * Submit Action URL
	 */
	public static final String SUBMIT_FORM_ACTION_URL = "submitFormActionURL";
	
	/**
	 * Captcha Resource URL
	 */
	public static final String CAPTCHA_RESOURCE_URL = "captchaResourceURL";
	
	/**
	 * Boolean indicating that captcha is invalid
	 */
	public static final String CAPTCHA_INVALID = "captchaInvalid";
	
	/**
	 * The applicant's email
	 */
	public static final String APPLICANT_EMAIL = "applicantEmail";
	
}