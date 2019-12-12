package com.imolczek.lab.liferay.testportlet.portlet.action.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imolczek.lab.liferay.testportlet.exceptions.ApplicationFormDataValidationException;
import com.imolczek.lab.liferay.testportlet.exceptions.BirthDateFutureException;
import com.liferay.portal.kernel.util.Validator;

public class SubmitFormData {

	private static final Logger LOG = LoggerFactory.getLogger(SubmitFormData.class);

	private String name;
	private String surname;
	private Date birthdate;
	private String email;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public SubmitFormData(String name, String surname, String birthdate, String email) throws ParseException {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = parseDate(birthdate);
		this.email = email;
	}

	private Date parseDate(String dateString) throws ParseException {

		// This is the expected format of the date string
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date;
		
		// Try to parse the date
		try {
			date = format.parse(dateString);
		} catch (ParseException pe) {
			LOG.info("Date string parser exception");
			throw pe;
		}
		
		return date;
	}
	
	public void validate() {
		validateName();
		validateSurname();
		validateBirthDate();
		validateEmail();
	}

	private void validateEmail() {

		// Check if the applicant email is not empty
		if("".equals(this.email)) {
			LOG.info("The user submitted an empty email");
			throw new ApplicationFormDataValidationException("Empty applicant email");			
			
		// Check if the email address is valid
		} else if (!Validator.isEmailAddress(this.email)){
			LOG.info("The submitted email is invalid");
			throw new ApplicationFormDataValidationException("Invalid email");			
		}

	}

	private void validateSurname() {

		// Check if the applicant's surname is empty
		if("".equals(this.surname)) {
			LOG.info("The user submitted an empty surname");
			throw new ApplicationFormDataValidationException("Empty applicant surname");			
		}		

	}

	private void validateName() {
		
		// Check if the applicant's name is empty
		if("".equals(this.name)) {
			LOG.info("The user submitted an empty name");
			throw new ApplicationFormDataValidationException("Empty applicant name");			
		}		
		
	}

	private void validateBirthDate() {
		
		Calendar calendar = Calendar.getInstance();
		
		// Check if the applicant's birth date is in the past
		if (this.birthdate.after(calendar.getTime())) {
			LOG.info("The user submitted a birth date in the future");
			throw new BirthDateFutureException("The birth date is in the future");			
		}
		
	}

		
}
