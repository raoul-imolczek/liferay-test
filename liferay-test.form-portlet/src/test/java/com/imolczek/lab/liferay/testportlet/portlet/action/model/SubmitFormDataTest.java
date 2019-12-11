package com.imolczek.lab.liferay.testportlet.portlet.action.model;

import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Test;

import com.imolczek.lab.liferay.testportlet.exceptions.ApplicationFormDataValidationException;
import com.imolczek.lab.liferay.testportlet.exceptions.BirthDateFutureException;

public class SubmitFormDataTest {

	@Test
	public void testValidData() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("John", "Doe", "1984-12-01", "john.doe@liferay.com");
		} catch (ParseException e) {
			e.printStackTrace();
			fail("This input data is correct and should not raise a ParseException");
		}
		
	}

	@Test
	public void testMissingName() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("", "Doe", "1984-12-01", "john.doe@liferay.com");
			submitFormData.validate();
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The birth date is correct and should not raise a ParseException");
		} catch (ApplicationFormDataValidationException e) {
			// This is correct behaviour
			return;
		}
		
		fail("An ApplicationFormDataValidationException should have been thrown");
		
	}

	@Test
	public void testMissingSurname() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("John", "", "1984-12-01", "john.doe@liferay.com");
			submitFormData.validate();
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The birth date is correct and should not raise a ParseException");
		} catch (ApplicationFormDataValidationException e) {
			// This is correct behaviour
			return;
		}
		
		fail("An ApplicationFormDataValidationException should have been thrown");
		
	}

	@Test
	public void testMissingEmail() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("John", "Doe", "1984-12-01", "");
			submitFormData.validate();
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The birth date is correct and should not raise a ParseException");
		} catch (ApplicationFormDataValidationException e) {
			// This is correct behaviour
			return;
		}
		
		fail("An ApplicationFormDataValidationException should have been thrown");
		
	}

	@Test
	public void testMissingBirthDate() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("John", "Doe", "", "john.doe@liferay.com");
			submitFormData.validate();
		} catch (ParseException e) {
			// This is correct behaviour
			return;
		}
		
		fail("A ParseException should have been thrown");
		
	}

	@Test
	public void testUnparseableBirthDate() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("John", "Doe", "12345", "john.doe@liferay.com");
			submitFormData.validate();
		} catch (ParseException e) {
			// This is correct behaviour
			return;
		}
		
		fail("A ParseException should have been thrown");
		
	}

	@Test
	public void testBirthDateInTheFuture() {
		
		try {
			SubmitFormData submitFormData = new SubmitFormData("John", "Doe", "2100-01-01", "john.doe@liferay.com");
			submitFormData.validate();
		} catch (ParseException e) {
			e.printStackTrace();
			fail("The birth date is parseable and should not raise a ParseException");
		} catch (BirthDateFutureException e) {
			// This is correct behaviour
			return;
		}
		
		fail("A BirthDateFutureException should have been thrown");
		
	}

}
