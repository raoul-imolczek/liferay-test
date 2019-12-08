package com.imolczek.lab.liferay.testportlet.email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.testportlet.configuration.ConfirmationEmailConfigurationLocalService;
import com.imolczek.lab.liferay.testportlet.configuration.exceptions.ConfirmationEmailConfigurationException;
import com.imolczek.lab.liferay.testportlet.portlet.action.SubmitFormMVCActionCommand;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
		immediate = true,
		service = ConfirmationEmailLocalService.class)
public class ConfirmationEmailLocalService {

	private static final Logger LOG = LoggerFactory.getLogger(ConfirmationEmailLocalService.class);

	public void sendConfirmationEmail(String applicantEmail, String applicantName, String applicantSurname) throws AddressException {
		MailMessage mailMessage = new MailMessage();
		
		String senderName = confirmationEmailConfigurationLocalService.getSenderName();
		String fromEmail = confirmationEmailConfigurationLocalService.getFromEmail();

		if("".equals(senderName)) {
			LOG.warn("Failed to send confirmation email: sender name is not configured");
			throw new ConfirmationEmailConfigurationException("Empty sender name!");
		}
		if("".equals(fromEmail)) {
			LOG.warn("Failed to send confirmation email: sender email is not configured");
			throw new ConfirmationEmailConfigurationException("Empty sender email address!");
		}
		if(!Validator.isEmailAddress(fromEmail)) {
			LOG.warn("Failed to send confirmation email: sender name is invalid");
			throw new ConfirmationEmailConfigurationException("Invalid sender email address!");
		}
		
		InternetAddress from = new InternetAddress(fromEmail);
		mailMessage.setFrom(from);
		
		InternetAddress to = new InternetAddress(applicantEmail);
		mailMessage.setTo(to);
		
		mailMessage.setSubject("Application confirmation");
		
		mailMessage.setBody(
				"Dear " + applicantName + " " + applicantSurname + ",\n" +
				"\n" +
				"Your application request has been properly registered.\n" +
				"\n" +
				"Yours sincerely,\n" +
				senderName
				);
		
		MailServiceUtil.sendEmail(mailMessage );		
	}
	
	@Reference
	private ConfirmationEmailConfigurationLocalService confirmationEmailConfigurationLocalService;
}
