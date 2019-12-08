package com.imolczek.lab.liferay.testportlet.configuration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

/**
 * The configuration service for the Confirmation email properties
 * @author Fabian
 *
 */
@Component(
		configurationPid = TestFormPortletKeys.CONFIRMATION_EMAIL_CONFIGURATION_PID,
		service = ConfirmationEmailConfigurationLocalService.class
		)
public class ConfirmationEmailConfigurationLocalService {

	/**
	 * Get the email address of the sender
	 * @return
	 */
	public String getFromEmail() {
		return configuration.fromEmail();
	}

	/**
	 * Get the name of the sender to be displayed in the signature
	 * @return
	 */
	public String getSenderName() {
		return configuration.senderName();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		this.configuration = ConfigurableUtil.createConfigurable(ConfirmationEmailConfiguration.class, properties);
	}

	private volatile ConfirmationEmailConfiguration configuration;
     
}
