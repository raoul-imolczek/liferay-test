[![Build Status](https://travis-ci.org/raoul-imolczek/liferay-test.svg?branch=master)](https://travis-ci.org/raoul-imolczek/liferay-test)

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

Form Portlet: [![Latest Version @ Cloudsmith](https://api-prd.cloudsmith.io/badges/version/liferay-fabian/liferay/maven/liferay-test.form-portlet/latest/xg=com.imolczek.lab.liferay/?render=true&badge_token=gAAAAABd8Xt_ESxHU7mrToHKFHN-lWQBbOnhqj4Cto2irc5kH1gKy_KQjAjFMU3kxy2QWLQuHxi66Zkn4KpUToNpMMnRjIIx6FpnYKCAzcpR-N2FfhaTJY4%3D)](https://cloudsmith.io/~liferay-fabian/repos/liferay/packages/detail/maven/liferay-test.form-portlet/latest/xg=com.imolczek.lab.liferay/)

Persistence service: [![Latest Version @ Cloudsmith](https://api-prd.cloudsmith.io/badges/version/liferay-fabian/liferay/maven/liferay-test.applicant-service-service/latest/xg=com.imolczek.lab.liferay/?render=true&badge_token=gAAAAABd8XtffdG1cio5oIgXfqMKxRTBrJjelvZGG8YUOMmH39wM3tnsVTPI61sM0xCfoEZQgGMbIitVNOZkqzfEpDiptyDcH8hbraWppBeS7vVjO6vmiQU%3D)](https://cloudsmith.io/~liferay-fabian/repos/liferay/packages/detail/maven/liferay-test.applicant-service-service/latest/xg=com.imolczek.lab.liferay/)

Persistence service API: [![Latest Version @ Cloudsmith](https://api-prd.cloudsmith.io/badges/version/liferay-fabian/liferay/maven/liferay-test.applicant-service-api/latest/xg=com.imolczek.lab.liferay/?render=true&badge_token=gAAAAABd8XuQS40S-urTDG6yxEcOg92MAKtI2x8G0axnFZRQmKbDdHQXXeLNBDffyN2eS_UH8Ze4yPgNHfCtJ-LYC8hcHSwI5abv3m-NDfkOrBG1O-zHoQE%3D)](https://cloudsmith.io/~liferay-fabian/repos/liferay/packages/detail/maven/liferay-test.applicant-service-api/latest/xg=com.imolczek.lab.liferay/)

