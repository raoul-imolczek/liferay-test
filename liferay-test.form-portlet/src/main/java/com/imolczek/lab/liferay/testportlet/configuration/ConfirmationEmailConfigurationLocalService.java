package com.imolczek.lab.liferay.testportlet.configuration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

@ExtendedObjectClassDefinition(
	    category = "Other", scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)
@Component(
		configurationPid = "com.imolczek.lab.liferay.testportlet.configuration.ConfirmationEmailConfiguration",
		service = ConfirmationEmailConfigurationLocalService.class
		)
public class ConfirmationEmailConfigurationLocalService {

	public String getFromEmail() {
		return configuration.fromEmail();
	}

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
