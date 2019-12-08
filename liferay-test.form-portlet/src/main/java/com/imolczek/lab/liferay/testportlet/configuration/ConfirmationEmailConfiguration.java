package com.imolczek.lab.liferay.testportlet.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "Other", scope = ExtendedObjectClassDefinition.Scope.SYSTEM
	)
@Meta.OCD(id = "com.imolczek.lab.liferay.testportlet.configuration.ConfirmationEmailConfiguration")
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
