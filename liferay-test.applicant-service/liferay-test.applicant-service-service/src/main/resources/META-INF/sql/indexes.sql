create index IX_80E56EF9 on APPLICANT_Applicant (applicantEmail[$COLUMN_LENGTH:75$]);
create index IX_D99817F on APPLICANT_Applicant (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CE425BC1 on APPLICANT_Applicant (uuid_[$COLUMN_LENGTH:75$], groupId);