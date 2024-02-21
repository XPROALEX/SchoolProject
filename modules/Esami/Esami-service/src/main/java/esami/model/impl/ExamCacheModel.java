/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import esami.model.Exam;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Exam in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExamCacheModel implements CacheModel<Exam>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExamCacheModel)) {
			return false;
		}

		ExamCacheModel examCacheModel = (ExamCacheModel)object;

		if (examId == examCacheModel.examId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, examId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{examId=");
		sb.append(examId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", teacherId=");
		sb.append(teacherId);
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", examDate=");
		sb.append(examDate);
		sb.append(", grade=");
		sb.append(grade);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Exam toEntityModel() {
		ExamImpl examImpl = new ExamImpl();

		examImpl.setExamId(examId);
		examImpl.setGroupId(groupId);
		examImpl.setCompanyId(companyId);
		examImpl.setUserId(userId);

		if (userName == null) {
			examImpl.setUserName("");
		}
		else {
			examImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			examImpl.setCreateDate(null);
		}
		else {
			examImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			examImpl.setModifiedDate(null);
		}
		else {
			examImpl.setModifiedDate(new Date(modifiedDate));
		}

		examImpl.setStudentId(studentId);
		examImpl.setTeacherId(teacherId);
		examImpl.setCourseId(courseId);

		if (examDate == Long.MIN_VALUE) {
			examImpl.setExamDate(null);
		}
		else {
			examImpl.setExamDate(new Date(examDate));
		}

		examImpl.setGrade(grade);

		examImpl.resetOriginalValues();

		return examImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		examId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		studentId = objectInput.readLong();

		teacherId = objectInput.readLong();

		courseId = objectInput.readLong();
		examDate = objectInput.readLong();

		grade = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(examId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(studentId);

		objectOutput.writeLong(teacherId);

		objectOutput.writeLong(courseId);
		objectOutput.writeLong(examDate);

		objectOutput.writeDouble(grade);
	}

	public long examId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long studentId;
	public long teacherId;
	public long courseId;
	public long examDate;
	public double grade;

}