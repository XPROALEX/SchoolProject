create table FOO_Course (
	courseId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	courseName VARCHAR(75) null
);

create table FOO_Exam (
	examId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	studentId LONG,
	teacherId LONG,
	courseId LONG,
	examDate DATE null,
	grade DOUBLE
);