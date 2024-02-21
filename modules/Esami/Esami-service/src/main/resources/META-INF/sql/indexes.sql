create index IX_1D20A3F4 on FOO_Course (courseName[$COLUMN_LENGTH:75$]);

create index IX_42435888 on FOO_Exam (courseId);
create index IX_EACEE49F on FOO_Exam (examDate);
create index IX_5D6A0109 on FOO_Exam (grade);
create index IX_98A88E28 on FOO_Exam (studentId);
create index IX_6F40AC4F on FOO_Exam (teacherId);