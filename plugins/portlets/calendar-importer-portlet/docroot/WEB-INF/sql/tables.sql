create table CI_ImportEntry (
	importEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description STRING null,
	calendarId LONG,
	type_ VARCHAR(75) null,
	typeSettings TEXT null,
	importDate DATE null
);