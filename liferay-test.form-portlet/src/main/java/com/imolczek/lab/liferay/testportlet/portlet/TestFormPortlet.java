package com.imolczek.lab.liferay.testportlet.portlet;

import java.io.IOException;

import javax.portlet.ActionURL;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author Fabian Bouché
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TestForm",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TestFormPortletKeys.TESTFORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class TestFormPortlet extends MVCPortlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestFormPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// Generate an action URL to submit the form
		// See SubmitFormMVCActionCommand.java
		ActionURL submitFormActionURL = renderResponse.createActionURL();
		submitFormActionURL.getActionParameters().setValue("javax.portlet.action", TestFormPortletKeys.SUBMIT_FORM_ACTION);
		renderRequest.setAttribute(TestFormPortletKeys.SUBMIT_FORM_ACTION_URL, submitFormActionURL);

		// Generate a resource URL to deliver the captcha image
		// See CaptchaMVCResourceCommand.java
		ResourceURL captchaURL = renderResponse.createResourceURL();
		captchaURL.setResourceID(TestFormPortletKeys.CAPTCHA_RESOURCE_ID);
		renderRequest.setAttribute(TestFormPortletKeys.CAPTCHA_RESOURCE_URL, captchaURL);
		
		// To be called last
		super.doView(renderRequest, renderResponse);
	}
	
}