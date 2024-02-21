/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Exam}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Exam
 * @generated
 */
public class ExamWrapper
	extends BaseModelWrapper<Exam> implements Exam, ModelWrapper<Exam> {

	public ExamWrapper(Exam exam) {
		super(exam);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("examId", getExamId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("studentId", getStudentId());
		attributes.put("teacherId", getTeacherId());
		attributes.put("courseId", getCourseId());
		attributes.put("examDate", getExamDate());
		attributes.put("grade", getGrade());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long examId = (Long)attributes.get("examId");

		if (examId != null) {
			setExamId(examId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long teacherId = (Long)attributes.get("teacherId");

		if (teacherId != null) {
			setTeacherId(teacherId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Date examDate = (Date)attributes.get("examDate");

		if (examDate != null) {
			setExamDate(examDate);
		}

		Double grade = (Double)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}
	}

	@Override
	public Exam cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this exam.
	 *
	 * @return the company ID of this exam
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the course ID of this exam.
	 *
	 * @return the course ID of this exam
	 */
	@Override
	public long getCourseId() {
		return model.getCourseId();
	}

	/**
	 * Returns the create date of this exam.
	 *
	 * @return the create date of this exam
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the exam date of this exam.
	 *
	 * @return the exam date of this exam
	 */
	@Override
	public Date getExamDate() {
		return model.getExamDate();
	}

	/**
	 * Returns the exam ID of this exam.
	 *
	 * @return the exam ID of this exam
	 */
	@Override
	public long getExamId() {
		return model.getExamId();
	}

	/**
	 * Returns the grade of this exam.
	 *
	 * @return the grade of this exam
	 */
	@Override
	public double getGrade() {
		return model.getGrade();
	}

	/**
	 * Returns the group ID of this exam.
	 *
	 * @return the group ID of this exam
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this exam.
	 *
	 * @return the modified date of this exam
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this exam.
	 *
	 * @return the primary key of this exam
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the student ID of this exam.
	 *
	 * @return the student ID of this exam
	 */
	@Override
	public long getStudentId() {
		return model.getStudentId();
	}

	/**
	 * Returns the teacher ID of this exam.
	 *
	 * @return the teacher ID of this exam
	 */
	@Override
	public long getTeacherId() {
		return model.getTeacherId();
	}

	/**
	 * Returns the user ID of this exam.
	 *
	 * @return the user ID of this exam
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this exam.
	 *
	 * @return the user name of this exam
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this exam.
	 *
	 * @return the user uuid of this exam
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this exam.
	 *
	 * @param companyId the company ID of this exam
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the course ID of this exam.
	 *
	 * @param courseId the course ID of this exam
	 */
	@Override
	public void setCourseId(long courseId) {
		model.setCourseId(courseId);
	}

	/**
	 * Sets the create date of this exam.
	 *
	 * @param createDate the create date of this exam
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the exam date of this exam.
	 *
	 * @param examDate the exam date of this exam
	 */
	@Override
	public void setExamDate(Date examDate) {
		model.setExamDate(examDate);
	}

	/**
	 * Sets the exam ID of this exam.
	 *
	 * @param examId the exam ID of this exam
	 */
	@Override
	public void setExamId(long examId) {
		model.setExamId(examId);
	}

	/**
	 * Sets the grade of this exam.
	 *
	 * @param grade the grade of this exam
	 */
	@Override
	public void setGrade(double grade) {
		model.setGrade(grade);
	}

	/**
	 * Sets the group ID of this exam.
	 *
	 * @param groupId the group ID of this exam
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this exam.
	 *
	 * @param modifiedDate the modified date of this exam
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this exam.
	 *
	 * @param primaryKey the primary key of this exam
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the student ID of this exam.
	 *
	 * @param studentId the student ID of this exam
	 */
	@Override
	public void setStudentId(long studentId) {
		model.setStudentId(studentId);
	}

	/**
	 * Sets the teacher ID of this exam.
	 *
	 * @param teacherId the teacher ID of this exam
	 */
	@Override
	public void setTeacherId(long teacherId) {
		model.setTeacherId(teacherId);
	}

	/**
	 * Sets the user ID of this exam.
	 *
	 * @param userId the user ID of this exam
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this exam.
	 *
	 * @param userName the user name of this exam
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this exam.
	 *
	 * @param userUuid the user uuid of this exam
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ExamWrapper wrap(Exam exam) {
		return new ExamWrapper(exam);
	}

}