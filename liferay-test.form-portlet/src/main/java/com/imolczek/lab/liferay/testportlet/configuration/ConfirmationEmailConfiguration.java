package com.imolczek.lab.liferay.testportlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

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
