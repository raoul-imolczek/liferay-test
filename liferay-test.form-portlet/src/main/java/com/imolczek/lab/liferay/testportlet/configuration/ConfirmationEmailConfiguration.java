package com.imolczek.lab.liferay.testportlet.configuration;

import com.imolczek.lab.liferay.testportlet.constants.TestFormPortletKeys;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "Other", scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)
@Meta.OCD(id = TestFormPortletKeys.CONFIRMATION_EMAIL_CONFIGURATION_PID)
public interface ConfirmationEmailConfiguration {

    @Meta.AD(
            deflt = "",
            required = false
    )
    public String fromEmail();

    @Meta.AD(
            deflt = "",
            required = false
    )
    public String senderName();

}
