package com.imolczek.lab.liferay.testportlet.portlet.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

@Component(
	    property = {
	        "javax.portlet.name=" + TestFormPortletKeys.TESTFORM,
	        "mvc.command.name=" + TestFormPortletKeys.CAPTCHA_RESOURCE_ID
	    },
	    service = MVCResourceCommand.class
	)
public class CaptchaMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Logger LOG = LoggerFactory.getLogger(CaptchaMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		}
		catch (IOException ioe) {
			throw new PortletException(ioe);
		}
		
	}


}
