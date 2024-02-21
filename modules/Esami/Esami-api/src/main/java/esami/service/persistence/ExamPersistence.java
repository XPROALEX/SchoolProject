/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import esami.exception.NoSuchExamException;

import esami.model.Exam;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the exam service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamUtil
 * @generated
 */
@ProviderType
public interface ExamPersistence extends BasePersistence<Exam> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExamUtil} to access the exam persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the exams where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching exams
	 */
	public java.util.List<Exam> findByfindByStudent(long studentId);

	/**
	 * Returns a range of all the exams where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @return the range of matching exams
	 */
	public java.util.List<Exam> findByfindByStudent(
		long studentId, int start, int end);

	/**
	 * Returns an ordered range of all the exams where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByStudent(
		long studentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the exams where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByStudent(
		long studentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByStudent_First(
			long studentId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the first exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByStudent_First(
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the last exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByStudent_Last(
			long studentId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the last exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByStudent_Last(
		long studentId,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the exams before and after the current exam in the ordered set where studentId = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam[] findByfindByStudent_PrevAndNext(
			long examId, long studentId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Removes all the exams where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	public void removeByfindByStudent(long studentId);

	/**
	 * Returns the number of exams where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching exams
	 */
	public int countByfindByStudent(long studentId);

	/**
	 * Returns all the exams where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @return the matching exams
	 */
	public java.util.List<Exam> findByfindByTeacher(long teacherId);

	/**
	 * Returns a range of all the exams where teacherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param teacherId the teacher ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @return the range of matching exams
	 */
	public java.util.List<Exam> findByfindByTeacher(
		long teacherId, int start, int end);

	/**
	 * Returns an ordered range of all the exams where teacherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param teacherId the teacher ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByTeacher(
		long teacherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the exams where teacherId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param teacherId the teacher ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByTeacher(
		long teacherId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByTeacher_First(
			long teacherId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the first exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByTeacher_First(
		long teacherId,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the last exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByTeacher_Last(
			long teacherId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the last exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByTeacher_Last(
		long teacherId,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the exams before and after the current exam in the ordered set where teacherId = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam[] findByfindByTeacher_PrevAndNext(
			long examId, long teacherId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Removes all the exams where teacherId = &#63; from the database.
	 *
	 * @param teacherId the teacher ID
	 */
	public void removeByfindByTeacher(long teacherId);

	/**
	 * Returns the number of exams where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @return the number of matching exams
	 */
	public int countByfindByTeacher(long teacherId);

	/**
	 * Returns all the exams where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching exams
	 */
	public java.util.List<Exam> findByfindByCourse(long courseId);

	/**
	 * Returns a range of all the exams where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @return the range of matching exams
	 */
	public java.util.List<Exam> findByfindByCourse(
		long courseId, int start, int end);

	/**
	 * Returns an ordered range of all the exams where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByCourse(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the exams where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByCourse(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByCourse_First(
			long courseId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the first exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByCourse_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the last exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByCourse_Last(
			long courseId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the last exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByCourse_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the exams before and after the current exam in the ordered set where courseId = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam[] findByfindByCourse_PrevAndNext(
			long examId, long courseId,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Removes all the exams where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 */
	public void removeByfindByCourse(long courseId);

	/**
	 * Returns the number of exams where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching exams
	 */
	public int countByfindByCourse(long courseId);

	/**
	 * Returns all the exams where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @return the matching exams
	 */
	public java.util.List<Exam> findByfindByDate(Date examDate);

	/**
	 * Returns a range of all the exams where examDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param examDate the exam date
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @return the range of matching exams
	 */
	public java.util.List<Exam> findByfindByDate(
		Date examDate, int start, int end);

	/**
	 * Returns an ordered range of all the exams where examDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param examDate the exam date
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByDate(
		Date examDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the exams where examDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param examDate the exam date
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByDate(
		Date examDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByDate_First(
			Date examDate,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the first exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByDate_First(
		Date examDate,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the last exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByDate_Last(
			Date examDate,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the last exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByDate_Last(
		Date examDate,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the exams before and after the current exam in the ordered set where examDate = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam[] findByfindByDate_PrevAndNext(
			long examId, Date examDate,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Removes all the exams where examDate = &#63; from the database.
	 *
	 * @param examDate the exam date
	 */
	public void removeByfindByDate(Date examDate);

	/**
	 * Returns the number of exams where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @return the number of matching exams
	 */
	public int countByfindByDate(Date examDate);

	/**
	 * Returns all the exams where grade = &#63;.
	 *
	 * @param grade the grade
	 * @return the matching exams
	 */
	public java.util.List<Exam> findByfindByGrade(double grade);

	/**
	 * Returns a range of all the exams where grade = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param grade the grade
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @return the range of matching exams
	 */
	public java.util.List<Exam> findByfindByGrade(
		double grade, int start, int end);

	/**
	 * Returns an ordered range of all the exams where grade = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param grade the grade
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByGrade(
		double grade, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the exams where grade = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param grade the grade
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching exams
	 */
	public java.util.List<Exam> findByfindByGrade(
		double grade, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByGrade_First(
			double grade,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the first exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByGrade_First(
		double grade,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the last exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public Exam findByfindByGrade_Last(
			double grade,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Returns the last exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public Exam fetchByfindByGrade_Last(
		double grade,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns the exams before and after the current exam in the ordered set where grade = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam[] findByfindByGrade_PrevAndNext(
			long examId, double grade,
			com.liferay.portal.kernel.util.OrderByComparator<Exam>
				orderByComparator)
		throws NoSuchExamException;

	/**
	 * Removes all the exams where grade = &#63; from the database.
	 *
	 * @param grade the grade
	 */
	public void removeByfindByGrade(double grade);

	/**
	 * Returns the number of exams where grade = &#63;.
	 *
	 * @param grade the grade
	 * @return the number of matching exams
	 */
	public int countByfindByGrade(double grade);

	/**
	 * Caches the exam in the entity cache if it is enabled.
	 *
	 * @param exam the exam
	 */
	public void cacheResult(Exam exam);

	/**
	 * Caches the exams in the entity cache if it is enabled.
	 *
	 * @param exams the exams
	 */
	public void cacheResult(java.util.List<Exam> exams);

	/**
	 * Creates a new exam with the primary key. Does not add the exam to the database.
	 *
	 * @param examId the primary key for the new exam
	 * @return the new exam
	 */
	public Exam create(long examId);

	/**
	 * Removes the exam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam that was removed
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam remove(long examId) throws NoSuchExamException;

	public Exam updateImpl(Exam exam);

	/**
	 * Returns the exam with the primary key or throws a <code>NoSuchExamException</code> if it could not be found.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public Exam findByPrimaryKey(long examId) throws NoSuchExamException;

	/**
	 * Returns the exam with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam, or <code>null</code> if a exam with the primary key could not be found
	 */
	public Exam fetchByPrimaryKey(long examId);

	/**
	 * Returns all the exams.
	 *
	 * @return the exams
	 */
	public java.util.List<Exam> findAll();

	/**
	 * Returns a range of all the exams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @return the range of exams
	 */
	public java.util.List<Exam> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the exams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of exams
	 */
	public java.util.List<Exam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the exams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of exams
	 * @param end the upper bound of the range of exams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of exams
	 */
	public java.util.List<Exam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Exam>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the exams from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of exams.
	 *
	 * @return the number of exams
	 */
	public int countAll();

}