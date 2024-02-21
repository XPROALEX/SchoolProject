/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Exam service. Represents a row in the &quot;FOO_Exam&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>esami.model.impl.ExamModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>esami.model.impl.ExamImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Exam
 * @generated
 */
@ProviderType
public interface ExamModel extends BaseModel<Exam>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a exam model instance should use the {@link Exam} interface instead.
	 */

	/**
	 * Returns the primary key of this exam.
	 *
	 * @return the primary key of this exam
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this exam.
	 *
	 * @param primaryKey the primary key of this exam
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the exam ID of this exam.
	 *
	 * @return the exam ID of this exam
	 */
	public long getExamId();

	/**
	 * Sets the exam ID of this exam.
	 *
	 * @param examId the exam ID of this exam
	 */
	public void setExamId(long examId);

	/**
	 * Returns the group ID of this exam.
	 *
	 * @return the group ID of this exam
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this exam.
	 *
	 * @param groupId the group ID of this exam
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this exam.
	 *
	 * @return the company ID of this exam
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this exam.
	 *
	 * @param companyId the company ID of this exam
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this exam.
	 *
	 * @return the user ID of this exam
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this exam.
	 *
	 * @param userId the user ID of this exam
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this exam.
	 *
	 * @return the user uuid of this exam
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this exam.
	 *
	 * @param userUuid the user uuid of this exam
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this exam.
	 *
	 * @return the user name of this exam
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this exam.
	 *
	 * @param userName the user name of this exam
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this exam.
	 *
	 * @return the create date of this exam
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this exam.
	 *
	 * @param createDate the create date of this exam
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this exam.
	 *
	 * @return the modified date of this exam
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this exam.
	 *
	 * @param modifiedDate the modified date of this exam
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the student ID of this exam.
	 *
	 * @return the student ID of this exam
	 */
	public long getStudentId();

	/**
	 * Sets the student ID of this exam.
	 *
	 * @param studentId the student ID of this exam
	 */
	public void setStudentId(long studentId);

	/**
	 * Returns the teacher ID of this exam.
	 *
	 * @return the teacher ID of this exam
	 */
	public long getTeacherId();

	/**
	 * Sets the teacher ID of this exam.
	 *
	 * @param teacherId the teacher ID of this exam
	 */
	public void setTeacherId(long teacherId);

	/**
	 * Returns the course ID of this exam.
	 *
	 * @return the course ID of this exam
	 */
	public long getCourseId();

	/**
	 * Sets the course ID of this exam.
	 *
	 * @param courseId the course ID of this exam
	 */
	public void setCourseId(long courseId);

	/**
	 * Returns the exam date of this exam.
	 *
	 * @return the exam date of this exam
	 */
	public Date getExamDate();

	/**
	 * Sets the exam date of this exam.
	 *
	 * @param examDate the exam date of this exam
	 */
	public void setExamDate(Date examDate);

	/**
	 * Returns the grade of this exam.
	 *
	 * @return the grade of this exam
	 */
	public double getGrade();

	/**
	 * Sets the grade of this exam.
	 *
	 * @param grade the grade of this exam
	 */
	public void setGrade(double grade);

	@Override
	public Exam cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}