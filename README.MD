Travis: [![Build Status](https://travis-ci.org/raoul-imolczek/liferay-test.svg?branch=master)](https://travis-ci.org/raoul-imolczek/liferay-test)

Sonar: [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=raoul-imolczek_liferay-test&metric=alert_status)](https://sonarcloud.io/dashboard?id=raoul-imolczek_liferay-test)

[![Comments (%)](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=comment_lines_density)](https://sonarcloud.io/component_measures?id=your.project.key&metric=comment_lines_density)
[![Open issues](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=open_issues)](https://sonarcloud.io/component_measures?id=your.project.key&metric=open_issues)
[![Code smells](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=code_smells)](https://sonarcloud.io/component_measures?id=your.project.key&metric=code_smells)
[![Technical debt](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=sqale_index)](https://sonarcloud.io/component_measures?id=your.project.key&metric=sqale_index)
[![Bugs](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=bugs)](https://sonarcloud.io/component_measures?id=your.project.key&metric=bugs)
[![Reliability remediation effort](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=reliability_remediation_effort)](https://sonarcloud.io/component_measures?id=your.project.key&metric=reliability_remediation_effort)
[![Coverage](https://sonarcloud.io/api/badges/measure?key=your.project.key&metric=coverage)](https://sonarcloud.io/component_measures?id=your.project.key&metric=coverage)
# Liferay application form sample

This project is built for Liferay Portal 7.2

This sample projects consists of two modules:
 - **liferay-test.applicant-service**: A service builder component to persist application requests
 - **liferay-test.form-portlet**: An application form portlet
 
 ## liferay-test.applicant-service
 
 This persistence service makes records of application requests.
 For each record, the following information is stored:
  - **applicantName**: The applicant's name
  - **applicantSurname**: The applicant's surname
  - **applicantEmail**: The applicant's email
  - **applicantBirthDate**: The applicant's birth date
  - **applicationSubmissionDate**: The day the application has been submitted

## liferay-test.form-portlet

This module is an application form

## Configuration and deployment

### Build with maven

Run the following command to build the project

```
mvn clean install
```

### Deployment of modules

Deploy the following jar files into the `LIFERAY_HOME/deploy` directory:
 - `liferay-test.applicant-service-api-1.0.0.jar`
 - `liferay-test.applicant-service-service-1.0.0.jar` 
 - `liferay-test.form-portlet-1.0.0.jar` 

### portal-ext.properties

The portlet needs to be able to send emails.

Add the following properties to the `portal-ext.properties` file:

```
mail.session.mail.transport.protocol=smtp
mail.session.mail.smtp.host=[smtp host of your provider]
mail.session.mail.smtp.user=[user name]
mail.session.mail.smtp.password=[password]
mail.session.mail.smtp.port=[smtp port]
mail.session.mail.smtp.auth=true
mail.session.mail.smtp.starttls.enable=false
```

Properties may differ from one provider to another (SSL could be activated for example).

### Module configuration file

Some parameters must be set for the portlet to be able to send emails.

Create a file named `com.imolczek.lab.liferay.testportlet.configuration.ConfirmationEmailConfiguration.config` and deploy it to the `LIFERAY_HOME/osgi/configs` directory.

The file should contain the following properties:

```
fromEmail=[the sender's email address]
senderName=[the sender's name to be included in the email's signature]
```

## Tests

Some form data validation tests are implemented.
There are some interesting tests relying on Mockito and Powermock!

## Binaries

Builds are performed by travis on commits to the master branch.
The binaries are available at Cloudsmith :
https://cloudsmith.io/~liferay-fabian/packages/
