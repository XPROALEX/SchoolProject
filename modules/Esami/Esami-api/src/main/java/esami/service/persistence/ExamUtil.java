/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import esami.model.Exam;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the exam service. This utility wraps <code>esami.service.persistence.impl.ExamPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamPersistence
 * @generated
 */
public class ExamUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Exam exam) {
		getPersistence().clearCache(exam);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Exam> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Exam> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Exam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Exam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Exam update(Exam exam) {
		return getPersistence().update(exam);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Exam update(Exam exam, ServiceContext serviceContext) {
		return getPersistence().update(exam, serviceContext);
	}

	/**
	 * Returns all the exams where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching exams
	 */
	public static List<Exam> findByfindByStudent(long studentId) {
		return getPersistence().findByfindByStudent(studentId);
	}

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
	public static List<Exam> findByfindByStudent(
		long studentId, int start, int end) {

		return getPersistence().findByfindByStudent(studentId, start, end);
	}

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
	public static List<Exam> findByfindByStudent(
		long studentId, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findByfindByStudent(
			studentId, start, end, orderByComparator);
	}

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
	public static List<Exam> findByfindByStudent(
		long studentId, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfindByStudent(
			studentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByStudent_First(
			long studentId, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByStudent_First(
			studentId, orderByComparator);
	}

	/**
	 * Returns the first exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByStudent_First(
		long studentId, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByStudent_First(
			studentId, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByStudent_Last(
			long studentId, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByStudent_Last(
			studentId, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByStudent_Last(
		long studentId, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByStudent_Last(
			studentId, orderByComparator);
	}

	/**
	 * Returns the exams before and after the current exam in the ordered set where studentId = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam[] findByfindByStudent_PrevAndNext(
			long examId, long studentId,
			OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByStudent_PrevAndNext(
			examId, studentId, orderByComparator);
	}

	/**
	 * Removes all the exams where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	public static void removeByfindByStudent(long studentId) {
		getPersistence().removeByfindByStudent(studentId);
	}

	/**
	 * Returns the number of exams where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching exams
	 */
	public static int countByfindByStudent(long studentId) {
		return getPersistence().countByfindByStudent(studentId);
	}

	/**
	 * Returns all the exams where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @return the matching exams
	 */
	public static List<Exam> findByfindByTeacher(long teacherId) {
		return getPersistence().findByfindByTeacher(teacherId);
	}

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
	public static List<Exam> findByfindByTeacher(
		long teacherId, int start, int end) {

		return getPersistence().findByfindByTeacher(teacherId, start, end);
	}

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
	public static List<Exam> findByfindByTeacher(
		long teacherId, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findByfindByTeacher(
			teacherId, start, end, orderByComparator);
	}

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
	public static List<Exam> findByfindByTeacher(
		long teacherId, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfindByTeacher(
			teacherId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByTeacher_First(
			long teacherId, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByTeacher_First(
			teacherId, orderByComparator);
	}

	/**
	 * Returns the first exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByTeacher_First(
		long teacherId, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByTeacher_First(
			teacherId, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByTeacher_Last(
			long teacherId, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByTeacher_Last(
			teacherId, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByTeacher_Last(
		long teacherId, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByTeacher_Last(
			teacherId, orderByComparator);
	}

	/**
	 * Returns the exams before and after the current exam in the ordered set where teacherId = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam[] findByfindByTeacher_PrevAndNext(
			long examId, long teacherId,
			OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByTeacher_PrevAndNext(
			examId, teacherId, orderByComparator);
	}

	/**
	 * Removes all the exams where teacherId = &#63; from the database.
	 *
	 * @param teacherId the teacher ID
	 */
	public static void removeByfindByTeacher(long teacherId) {
		getPersistence().removeByfindByTeacher(teacherId);
	}

	/**
	 * Returns the number of exams where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @return the number of matching exams
	 */
	public static int countByfindByTeacher(long teacherId) {
		return getPersistence().countByfindByTeacher(teacherId);
	}

	/**
	 * Returns all the exams where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching exams
	 */
	public static List<Exam> findByfindByCourse(long courseId) {
		return getPersistence().findByfindByCourse(courseId);
	}

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
	public static List<Exam> findByfindByCourse(
		long courseId, int start, int end) {

		return getPersistence().findByfindByCourse(courseId, start, end);
	}

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
	public static List<Exam> findByfindByCourse(
		long courseId, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findByfindByCourse(
			courseId, start, end, orderByComparator);
	}

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
	public static List<Exam> findByfindByCourse(
		long courseId, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfindByCourse(
			courseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByCourse_First(
			long courseId, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByCourse_First(
			courseId, orderByComparator);
	}

	/**
	 * Returns the first exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByCourse_First(
		long courseId, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByCourse_First(
			courseId, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByCourse_Last(
			long courseId, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByCourse_Last(
			courseId, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByCourse_Last(
		long courseId, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByCourse_Last(
			courseId, orderByComparator);
	}

	/**
	 * Returns the exams before and after the current exam in the ordered set where courseId = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam[] findByfindByCourse_PrevAndNext(
			long examId, long courseId,
			OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByCourse_PrevAndNext(
			examId, courseId, orderByComparator);
	}

	/**
	 * Removes all the exams where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 */
	public static void removeByfindByCourse(long courseId) {
		getPersistence().removeByfindByCourse(courseId);
	}

	/**
	 * Returns the number of exams where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching exams
	 */
	public static int countByfindByCourse(long courseId) {
		return getPersistence().countByfindByCourse(courseId);
	}

	/**
	 * Returns all the exams where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @return the matching exams
	 */
	public static List<Exam> findByfindByDate(Date examDate) {
		return getPersistence().findByfindByDate(examDate);
	}

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
	public static List<Exam> findByfindByDate(
		Date examDate, int start, int end) {

		return getPersistence().findByfindByDate(examDate, start, end);
	}

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
	public static List<Exam> findByfindByDate(
		Date examDate, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findByfindByDate(
			examDate, start, end, orderByComparator);
	}

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
	public static List<Exam> findByfindByDate(
		Date examDate, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfindByDate(
			examDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByDate_First(
			Date examDate, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByDate_First(
			examDate, orderByComparator);
	}

	/**
	 * Returns the first exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByDate_First(
		Date examDate, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByDate_First(
			examDate, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByDate_Last(
			Date examDate, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByDate_Last(
			examDate, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByDate_Last(
		Date examDate, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByDate_Last(
			examDate, orderByComparator);
	}

	/**
	 * Returns the exams before and after the current exam in the ordered set where examDate = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam[] findByfindByDate_PrevAndNext(
			long examId, Date examDate,
			OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByDate_PrevAndNext(
			examId, examDate, orderByComparator);
	}

	/**
	 * Removes all the exams where examDate = &#63; from the database.
	 *
	 * @param examDate the exam date
	 */
	public static void removeByfindByDate(Date examDate) {
		getPersistence().removeByfindByDate(examDate);
	}

	/**
	 * Returns the number of exams where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @return the number of matching exams
	 */
	public static int countByfindByDate(Date examDate) {
		return getPersistence().countByfindByDate(examDate);
	}

	/**
	 * Returns all the exams where grade = &#63;.
	 *
	 * @param grade the grade
	 * @return the matching exams
	 */
	public static List<Exam> findByfindByGrade(double grade) {
		return getPersistence().findByfindByGrade(grade);
	}

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
	public static List<Exam> findByfindByGrade(
		double grade, int start, int end) {

		return getPersistence().findByfindByGrade(grade, start, end);
	}

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
	public static List<Exam> findByfindByGrade(
		double grade, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findByfindByGrade(
			grade, start, end, orderByComparator);
	}

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
	public static List<Exam> findByfindByGrade(
		double grade, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfindByGrade(
			grade, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByGrade_First(
			double grade, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByGrade_First(
			grade, orderByComparator);
	}

	/**
	 * Returns the first exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByGrade_First(
		double grade, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByGrade_First(
			grade, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	public static Exam findByfindByGrade_Last(
			double grade, OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByGrade_Last(
			grade, orderByComparator);
	}

	/**
	 * Returns the last exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	public static Exam fetchByfindByGrade_Last(
		double grade, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().fetchByfindByGrade_Last(
			grade, orderByComparator);
	}

	/**
	 * Returns the exams before and after the current exam in the ordered set where grade = &#63;.
	 *
	 * @param examId the primary key of the current exam
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam[] findByfindByGrade_PrevAndNext(
			long examId, double grade,
			OrderByComparator<Exam> orderByComparator)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByfindByGrade_PrevAndNext(
			examId, grade, orderByComparator);
	}

	/**
	 * Removes all the exams where grade = &#63; from the database.
	 *
	 * @param grade the grade
	 */
	public static void removeByfindByGrade(double grade) {
		getPersistence().removeByfindByGrade(grade);
	}

	/**
	 * Returns the number of exams where grade = &#63;.
	 *
	 * @param grade the grade
	 * @return the number of matching exams
	 */
	public static int countByfindByGrade(double grade) {
		return getPersistence().countByfindByGrade(grade);
	}

	/**
	 * Caches the exam in the entity cache if it is enabled.
	 *
	 * @param exam the exam
	 */
	public static void cacheResult(Exam exam) {
		getPersistence().cacheResult(exam);
	}

	/**
	 * Caches the exams in the entity cache if it is enabled.
	 *
	 * @param exams the exams
	 */
	public static void cacheResult(List<Exam> exams) {
		getPersistence().cacheResult(exams);
	}

	/**
	 * Creates a new exam with the primary key. Does not add the exam to the database.
	 *
	 * @param examId the primary key for the new exam
	 * @return the new exam
	 */
	public static Exam create(long examId) {
		return getPersistence().create(examId);
	}

	/**
	 * Removes the exam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam that was removed
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam remove(long examId)
		throws esami.exception.NoSuchExamException {

		return getPersistence().remove(examId);
	}

	public static Exam updateImpl(Exam exam) {
		return getPersistence().updateImpl(exam);
	}

	/**
	 * Returns the exam with the primary key or throws a <code>NoSuchExamException</code> if it could not be found.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	public static Exam findByPrimaryKey(long examId)
		throws esami.exception.NoSuchExamException {

		return getPersistence().findByPrimaryKey(examId);
	}

	/**
	 * Returns the exam with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam, or <code>null</code> if a exam with the primary key could not be found
	 */
	public static Exam fetchByPrimaryKey(long examId) {
		return getPersistence().fetchByPrimaryKey(examId);
	}

	/**
	 * Returns all the exams.
	 *
	 * @return the exams
	 */
	public static List<Exam> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Exam> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Exam> findAll(
		int start, int end, OrderByComparator<Exam> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Exam> findAll(
		int start, int end, OrderByComparator<Exam> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the exams from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of exams.
	 *
	 * @return the number of exams
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExamPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ExamPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ExamPersistence _persistence;

}