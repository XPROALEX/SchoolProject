/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;FOO_Exam&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Exam
 * @generated
 */
public class ExamTable extends BaseTable<ExamTable> {

	public static final ExamTable INSTANCE = new ExamTable();

	public final Column<ExamTable, Long> examId = createColumn(
		"examId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ExamTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExamTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Long> studentId = createColumn(
		"studentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Long> teacherId = createColumn(
		"teacherId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Long> courseId = createColumn(
		"courseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Date> examDate = createColumn(
		"examDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExamTable, Double> grade = createColumn(
		"grade", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private ExamTable() {
		super("FOO_Exam", ExamTable::new);
	}

}