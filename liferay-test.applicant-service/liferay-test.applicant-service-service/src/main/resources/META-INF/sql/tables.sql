create table APPLICANT_Applicant (
	uuid_ VARCHAR(75) null,
	applicantId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	applicantName VARCHAR(75) null,
	applicantSurname VARCHAR(75) null,
	applicantEmail VARCHAR(75) null,
	applicantBirthDate DATE null,
	applicationSubmissionDate DATE null
);