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
 * The table class for the &quot;FOO_Course&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @generated
 */
public class CourseTable extends BaseTable<CourseTable> {

	public static final CourseTable INSTANCE = new CourseTable();

	public final Column<CourseTable, Long> courseId = createColumn(
		"courseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CourseTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CourseTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CourseTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CourseTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CourseTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CourseTable, String> courseName = createColumn(
		"courseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CourseTable() {
		super("FOO_Course", CourseTable::new);
	}

}