package com.imolczek.lab.liferay.testportlet.exceptions;

/**
 * Exception to be raised if the configuration for the sending of confirmation emails is incorrect
 * @author Fabian
 *
 */
public class ConfirmationEmailConfigurationException extends RuntimeException {

	public ConfirmationEmailConfigurationException(String message) {
		super(message);
	}
	
}
