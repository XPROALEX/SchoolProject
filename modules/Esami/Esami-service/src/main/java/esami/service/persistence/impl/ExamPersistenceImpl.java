/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package esami.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import esami.exception.NoSuchExamException;

import esami.model.Exam;
import esami.model.ExamTable;
import esami.model.impl.ExamImpl;
import esami.model.impl.ExamModelImpl;

import esami.service.persistence.ExamPersistence;
import esami.service.persistence.ExamUtil;
import esami.service.persistence.impl.constants.FOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the exam service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ExamPersistence.class)
public class ExamPersistenceImpl
	extends BasePersistenceImpl<Exam> implements ExamPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExamUtil</code> to access the exam persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExamImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByfindByStudent;
	private FinderPath _finderPathWithoutPaginationFindByfindByStudent;
	private FinderPath _finderPathCountByfindByStudent;

	/**
	 * Returns all the exams where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching exams
	 */
	@Override
	public List<Exam> findByfindByStudent(long studentId) {
		return findByfindByStudent(
			studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Exam> findByfindByStudent(long studentId, int start, int end) {
		return findByfindByStudent(studentId, start, end, null);
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
	@Override
	public List<Exam> findByfindByStudent(
		long studentId, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return findByfindByStudent(
			studentId, start, end, orderByComparator, true);
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
	@Override
	public List<Exam> findByfindByStudent(
		long studentId, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByStudent;
				finderArgs = new Object[] {studentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByStudent;
			finderArgs = new Object[] {
				studentId, start, end, orderByComparator
			};
		}

		List<Exam> list = null;

		if (useFinderCache) {
			list = (List<Exam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Exam exam : list) {
					if (studentId != exam.getStudentId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYSTUDENT_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExamModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(studentId);

				list = (List<Exam>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByStudent_First(
			long studentId, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByStudent_First(studentId, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("studentId=");
		sb.append(studentId);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the first exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByStudent_First(
		long studentId, OrderByComparator<Exam> orderByComparator) {

		List<Exam> list = findByfindByStudent(
			studentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByStudent_Last(
			long studentId, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByStudent_Last(studentId, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("studentId=");
		sb.append(studentId);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the last exam in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByStudent_Last(
		long studentId, OrderByComparator<Exam> orderByComparator) {

		int count = countByfindByStudent(studentId);

		if (count == 0) {
			return null;
		}

		List<Exam> list = findByfindByStudent(
			studentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Exam[] findByfindByStudent_PrevAndNext(
			long examId, long studentId,
			OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = findByPrimaryKey(examId);

		Session session = null;

		try {
			session = openSession();

			Exam[] array = new ExamImpl[3];

			array[0] = getByfindByStudent_PrevAndNext(
				session, exam, studentId, orderByComparator, true);

			array[1] = exam;

			array[2] = getByfindByStudent_PrevAndNext(
				session, exam, studentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Exam getByfindByStudent_PrevAndNext(
		Session session, Exam exam, long studentId,
		OrderByComparator<Exam> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXAM_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYSTUDENT_STUDENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ExamModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(studentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(exam)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Exam> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the exams where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeByfindByStudent(long studentId) {
		for (Exam exam :
				findByfindByStudent(
					studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(exam);
		}
	}

	/**
	 * Returns the number of exams where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching exams
	 */
	@Override
	public int countByfindByStudent(long studentId) {
		FinderPath finderPath = _finderPathCountByfindByStudent;

		Object[] finderArgs = new Object[] {studentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYSTUDENT_STUDENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(studentId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYSTUDENT_STUDENTID_2 =
		"exam.studentId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByTeacher;
	private FinderPath _finderPathWithoutPaginationFindByfindByTeacher;
	private FinderPath _finderPathCountByfindByTeacher;

	/**
	 * Returns all the exams where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @return the matching exams
	 */
	@Override
	public List<Exam> findByfindByTeacher(long teacherId) {
		return findByfindByTeacher(
			teacherId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Exam> findByfindByTeacher(long teacherId, int start, int end) {
		return findByfindByTeacher(teacherId, start, end, null);
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
	@Override
	public List<Exam> findByfindByTeacher(
		long teacherId, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return findByfindByTeacher(
			teacherId, start, end, orderByComparator, true);
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
	@Override
	public List<Exam> findByfindByTeacher(
		long teacherId, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByTeacher;
				finderArgs = new Object[] {teacherId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByTeacher;
			finderArgs = new Object[] {
				teacherId, start, end, orderByComparator
			};
		}

		List<Exam> list = null;

		if (useFinderCache) {
			list = (List<Exam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Exam exam : list) {
					if (teacherId != exam.getTeacherId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYTEACHER_TEACHERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExamModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(teacherId);

				list = (List<Exam>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByTeacher_First(
			long teacherId, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByTeacher_First(teacherId, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("teacherId=");
		sb.append(teacherId);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the first exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByTeacher_First(
		long teacherId, OrderByComparator<Exam> orderByComparator) {

		List<Exam> list = findByfindByTeacher(
			teacherId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByTeacher_Last(
			long teacherId, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByTeacher_Last(teacherId, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("teacherId=");
		sb.append(teacherId);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the last exam in the ordered set where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByTeacher_Last(
		long teacherId, OrderByComparator<Exam> orderByComparator) {

		int count = countByfindByTeacher(teacherId);

		if (count == 0) {
			return null;
		}

		List<Exam> list = findByfindByTeacher(
			teacherId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Exam[] findByfindByTeacher_PrevAndNext(
			long examId, long teacherId,
			OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = findByPrimaryKey(examId);

		Session session = null;

		try {
			session = openSession();

			Exam[] array = new ExamImpl[3];

			array[0] = getByfindByTeacher_PrevAndNext(
				session, exam, teacherId, orderByComparator, true);

			array[1] = exam;

			array[2] = getByfindByTeacher_PrevAndNext(
				session, exam, teacherId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Exam getByfindByTeacher_PrevAndNext(
		Session session, Exam exam, long teacherId,
		OrderByComparator<Exam> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXAM_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYTEACHER_TEACHERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ExamModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(teacherId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(exam)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Exam> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the exams where teacherId = &#63; from the database.
	 *
	 * @param teacherId the teacher ID
	 */
	@Override
	public void removeByfindByTeacher(long teacherId) {
		for (Exam exam :
				findByfindByTeacher(
					teacherId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(exam);
		}
	}

	/**
	 * Returns the number of exams where teacherId = &#63;.
	 *
	 * @param teacherId the teacher ID
	 * @return the number of matching exams
	 */
	@Override
	public int countByfindByTeacher(long teacherId) {
		FinderPath finderPath = _finderPathCountByfindByTeacher;

		Object[] finderArgs = new Object[] {teacherId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYTEACHER_TEACHERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(teacherId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYTEACHER_TEACHERID_2 =
		"exam.teacherId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByCourse;
	private FinderPath _finderPathWithoutPaginationFindByfindByCourse;
	private FinderPath _finderPathCountByfindByCourse;

	/**
	 * Returns all the exams where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching exams
	 */
	@Override
	public List<Exam> findByfindByCourse(long courseId) {
		return findByfindByCourse(
			courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Exam> findByfindByCourse(long courseId, int start, int end) {
		return findByfindByCourse(courseId, start, end, null);
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
	@Override
	public List<Exam> findByfindByCourse(
		long courseId, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return findByfindByCourse(
			courseId, start, end, orderByComparator, true);
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
	@Override
	public List<Exam> findByfindByCourse(
		long courseId, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByCourse;
				finderArgs = new Object[] {courseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByCourse;
			finderArgs = new Object[] {courseId, start, end, orderByComparator};
		}

		List<Exam> list = null;

		if (useFinderCache) {
			list = (List<Exam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Exam exam : list) {
					if (courseId != exam.getCourseId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYCOURSE_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExamModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(courseId);

				list = (List<Exam>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByCourse_First(
			long courseId, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByCourse_First(courseId, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseId=");
		sb.append(courseId);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the first exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByCourse_First(
		long courseId, OrderByComparator<Exam> orderByComparator) {

		List<Exam> list = findByfindByCourse(courseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByCourse_Last(
			long courseId, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByCourse_Last(courseId, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseId=");
		sb.append(courseId);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the last exam in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByCourse_Last(
		long courseId, OrderByComparator<Exam> orderByComparator) {

		int count = countByfindByCourse(courseId);

		if (count == 0) {
			return null;
		}

		List<Exam> list = findByfindByCourse(
			courseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Exam[] findByfindByCourse_PrevAndNext(
			long examId, long courseId,
			OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = findByPrimaryKey(examId);

		Session session = null;

		try {
			session = openSession();

			Exam[] array = new ExamImpl[3];

			array[0] = getByfindByCourse_PrevAndNext(
				session, exam, courseId, orderByComparator, true);

			array[1] = exam;

			array[2] = getByfindByCourse_PrevAndNext(
				session, exam, courseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Exam getByfindByCourse_PrevAndNext(
		Session session, Exam exam, long courseId,
		OrderByComparator<Exam> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXAM_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYCOURSE_COURSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ExamModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(courseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(exam)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Exam> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the exams where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 */
	@Override
	public void removeByfindByCourse(long courseId) {
		for (Exam exam :
				findByfindByCourse(
					courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(exam);
		}
	}

	/**
	 * Returns the number of exams where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching exams
	 */
	@Override
	public int countByfindByCourse(long courseId) {
		FinderPath finderPath = _finderPathCountByfindByCourse;

		Object[] finderArgs = new Object[] {courseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYCOURSE_COURSEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(courseId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYCOURSE_COURSEID_2 =
		"exam.courseId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByDate;
	private FinderPath _finderPathWithoutPaginationFindByfindByDate;
	private FinderPath _finderPathCountByfindByDate;

	/**
	 * Returns all the exams where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @return the matching exams
	 */
	@Override
	public List<Exam> findByfindByDate(Date examDate) {
		return findByfindByDate(
			examDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Exam> findByfindByDate(Date examDate, int start, int end) {
		return findByfindByDate(examDate, start, end, null);
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
	@Override
	public List<Exam> findByfindByDate(
		Date examDate, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return findByfindByDate(examDate, start, end, orderByComparator, true);
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
	@Override
	public List<Exam> findByfindByDate(
		Date examDate, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByDate;
				finderArgs = new Object[] {_getTime(examDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByDate;
			finderArgs = new Object[] {
				_getTime(examDate), start, end, orderByComparator
			};
		}

		List<Exam> list = null;

		if (useFinderCache) {
			list = (List<Exam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Exam exam : list) {
					if (!Objects.equals(examDate, exam.getExamDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EXAM_WHERE);

			boolean bindExamDate = false;

			if (examDate == null) {
				sb.append(_FINDER_COLUMN_FINDBYDATE_EXAMDATE_1);
			}
			else {
				bindExamDate = true;

				sb.append(_FINDER_COLUMN_FINDBYDATE_EXAMDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExamModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExamDate) {
					queryPos.add(new Timestamp(examDate.getTime()));
				}

				list = (List<Exam>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByDate_First(
			Date examDate, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByDate_First(examDate, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("examDate=");
		sb.append(examDate);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the first exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByDate_First(
		Date examDate, OrderByComparator<Exam> orderByComparator) {

		List<Exam> list = findByfindByDate(examDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByDate_Last(
			Date examDate, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByDate_Last(examDate, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("examDate=");
		sb.append(examDate);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the last exam in the ordered set where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByDate_Last(
		Date examDate, OrderByComparator<Exam> orderByComparator) {

		int count = countByfindByDate(examDate);

		if (count == 0) {
			return null;
		}

		List<Exam> list = findByfindByDate(
			examDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Exam[] findByfindByDate_PrevAndNext(
			long examId, Date examDate,
			OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = findByPrimaryKey(examId);

		Session session = null;

		try {
			session = openSession();

			Exam[] array = new ExamImpl[3];

			array[0] = getByfindByDate_PrevAndNext(
				session, exam, examDate, orderByComparator, true);

			array[1] = exam;

			array[2] = getByfindByDate_PrevAndNext(
				session, exam, examDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Exam getByfindByDate_PrevAndNext(
		Session session, Exam exam, Date examDate,
		OrderByComparator<Exam> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXAM_WHERE);

		boolean bindExamDate = false;

		if (examDate == null) {
			sb.append(_FINDER_COLUMN_FINDBYDATE_EXAMDATE_1);
		}
		else {
			bindExamDate = true;

			sb.append(_FINDER_COLUMN_FINDBYDATE_EXAMDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ExamModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindExamDate) {
			queryPos.add(new Timestamp(examDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(exam)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Exam> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the exams where examDate = &#63; from the database.
	 *
	 * @param examDate the exam date
	 */
	@Override
	public void removeByfindByDate(Date examDate) {
		for (Exam exam :
				findByfindByDate(
					examDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(exam);
		}
	}

	/**
	 * Returns the number of exams where examDate = &#63;.
	 *
	 * @param examDate the exam date
	 * @return the number of matching exams
	 */
	@Override
	public int countByfindByDate(Date examDate) {
		FinderPath finderPath = _finderPathCountByfindByDate;

		Object[] finderArgs = new Object[] {_getTime(examDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXAM_WHERE);

			boolean bindExamDate = false;

			if (examDate == null) {
				sb.append(_FINDER_COLUMN_FINDBYDATE_EXAMDATE_1);
			}
			else {
				bindExamDate = true;

				sb.append(_FINDER_COLUMN_FINDBYDATE_EXAMDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExamDate) {
					queryPos.add(new Timestamp(examDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYDATE_EXAMDATE_1 =
		"exam.examDate IS NULL";

	private static final String _FINDER_COLUMN_FINDBYDATE_EXAMDATE_2 =
		"exam.examDate = ?";

	private FinderPath _finderPathWithPaginationFindByfindByGrade;
	private FinderPath _finderPathWithoutPaginationFindByfindByGrade;
	private FinderPath _finderPathCountByfindByGrade;

	/**
	 * Returns all the exams where grade = &#63;.
	 *
	 * @param grade the grade
	 * @return the matching exams
	 */
	@Override
	public List<Exam> findByfindByGrade(double grade) {
		return findByfindByGrade(
			grade, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Exam> findByfindByGrade(double grade, int start, int end) {
		return findByfindByGrade(grade, start, end, null);
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
	@Override
	public List<Exam> findByfindByGrade(
		double grade, int start, int end,
		OrderByComparator<Exam> orderByComparator) {

		return findByfindByGrade(grade, start, end, orderByComparator, true);
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
	@Override
	public List<Exam> findByfindByGrade(
		double grade, int start, int end,
		OrderByComparator<Exam> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByGrade;
				finderArgs = new Object[] {grade};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByGrade;
			finderArgs = new Object[] {grade, start, end, orderByComparator};
		}

		List<Exam> list = null;

		if (useFinderCache) {
			list = (List<Exam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Exam exam : list) {
					if (grade != exam.getGrade()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYGRADE_GRADE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExamModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(grade);

				list = (List<Exam>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByGrade_First(
			double grade, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByGrade_First(grade, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("grade=");
		sb.append(grade);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the first exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByGrade_First(
		double grade, OrderByComparator<Exam> orderByComparator) {

		List<Exam> list = findByfindByGrade(grade, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam
	 * @throws NoSuchExamException if a matching exam could not be found
	 */
	@Override
	public Exam findByfindByGrade_Last(
			double grade, OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = fetchByfindByGrade_Last(grade, orderByComparator);

		if (exam != null) {
			return exam;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("grade=");
		sb.append(grade);

		sb.append("}");

		throw new NoSuchExamException(sb.toString());
	}

	/**
	 * Returns the last exam in the ordered set where grade = &#63;.
	 *
	 * @param grade the grade
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching exam, or <code>null</code> if a matching exam could not be found
	 */
	@Override
	public Exam fetchByfindByGrade_Last(
		double grade, OrderByComparator<Exam> orderByComparator) {

		int count = countByfindByGrade(grade);

		if (count == 0) {
			return null;
		}

		List<Exam> list = findByfindByGrade(
			grade, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Exam[] findByfindByGrade_PrevAndNext(
			long examId, double grade,
			OrderByComparator<Exam> orderByComparator)
		throws NoSuchExamException {

		Exam exam = findByPrimaryKey(examId);

		Session session = null;

		try {
			session = openSession();

			Exam[] array = new ExamImpl[3];

			array[0] = getByfindByGrade_PrevAndNext(
				session, exam, grade, orderByComparator, true);

			array[1] = exam;

			array[2] = getByfindByGrade_PrevAndNext(
				session, exam, grade, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Exam getByfindByGrade_PrevAndNext(
		Session session, Exam exam, double grade,
		OrderByComparator<Exam> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXAM_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYGRADE_GRADE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ExamModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(grade);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(exam)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Exam> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the exams where grade = &#63; from the database.
	 *
	 * @param grade the grade
	 */
	@Override
	public void removeByfindByGrade(double grade) {
		for (Exam exam :
				findByfindByGrade(
					grade, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(exam);
		}
	}

	/**
	 * Returns the number of exams where grade = &#63;.
	 *
	 * @param grade the grade
	 * @return the number of matching exams
	 */
	@Override
	public int countByfindByGrade(double grade) {
		FinderPath finderPath = _finderPathCountByfindByGrade;

		Object[] finderArgs = new Object[] {grade};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXAM_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYGRADE_GRADE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(grade);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYGRADE_GRADE_2 =
		"exam.grade = ?";

	public ExamPersistenceImpl() {
		setModelClass(Exam.class);

		setModelImplClass(ExamImpl.class);
		setModelPKClass(long.class);

		setTable(ExamTable.INSTANCE);
	}

	/**
	 * Caches the exam in the entity cache if it is enabled.
	 *
	 * @param exam the exam
	 */
	@Override
	public void cacheResult(Exam exam) {
		entityCache.putResult(ExamImpl.class, exam.getPrimaryKey(), exam);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the exams in the entity cache if it is enabled.
	 *
	 * @param exams the exams
	 */
	@Override
	public void cacheResult(List<Exam> exams) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (exams.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Exam exam : exams) {
			if (entityCache.getResult(ExamImpl.class, exam.getPrimaryKey()) ==
					null) {

				cacheResult(exam);
			}
		}
	}

	/**
	 * Clears the cache for all exams.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExamImpl.class);

		finderCache.clearCache(ExamImpl.class);
	}

	/**
	 * Clears the cache for the exam.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Exam exam) {
		entityCache.removeResult(ExamImpl.class, exam);
	}

	@Override
	public void clearCache(List<Exam> exams) {
		for (Exam exam : exams) {
			entityCache.removeResult(ExamImpl.class, exam);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ExamImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExamImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new exam with the primary key. Does not add the exam to the database.
	 *
	 * @param examId the primary key for the new exam
	 * @return the new exam
	 */
	@Override
	public Exam create(long examId) {
		Exam exam = new ExamImpl();

		exam.setNew(true);
		exam.setPrimaryKey(examId);

		exam.setCompanyId(CompanyThreadLocal.getCompanyId());

		return exam;
	}

	/**
	 * Removes the exam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam that was removed
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	@Override
	public Exam remove(long examId) throws NoSuchExamException {
		return remove((Serializable)examId);
	}

	/**
	 * Removes the exam with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the exam
	 * @return the exam that was removed
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	@Override
	public Exam remove(Serializable primaryKey) throws NoSuchExamException {
		Session session = null;

		try {
			session = openSession();

			Exam exam = (Exam)session.get(ExamImpl.class, primaryKey);

			if (exam == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExamException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(exam);
		}
		catch (NoSuchExamException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Exam removeImpl(Exam exam) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(exam)) {
				exam = (Exam)session.get(
					ExamImpl.class, exam.getPrimaryKeyObj());
			}

			if (exam != null) {
				session.delete(exam);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (exam != null) {
			clearCache(exam);
		}

		return exam;
	}

	@Override
	public Exam updateImpl(Exam exam) {
		boolean isNew = exam.isNew();

		if (!(exam instanceof ExamModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(exam.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(exam);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in exam proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Exam implementation " +
					exam.getClass());
		}

		ExamModelImpl examModelImpl = (ExamModelImpl)exam;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (exam.getCreateDate() == null)) {
			if (serviceContext == null) {
				exam.setCreateDate(date);
			}
			else {
				exam.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!examModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				exam.setModifiedDate(date);
			}
			else {
				exam.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(exam);
			}
			else {
				exam = (Exam)session.merge(exam);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ExamImpl.class, examModelImpl, false, true);

		if (isNew) {
			exam.setNew(false);
		}

		exam.resetOriginalValues();

		return exam;
	}

	/**
	 * Returns the exam with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the exam
	 * @return the exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	@Override
	public Exam findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExamException {

		Exam exam = fetchByPrimaryKey(primaryKey);

		if (exam == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExamException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return exam;
	}

	/**
	 * Returns the exam with the primary key or throws a <code>NoSuchExamException</code> if it could not be found.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam
	 * @throws NoSuchExamException if a exam with the primary key could not be found
	 */
	@Override
	public Exam findByPrimaryKey(long examId) throws NoSuchExamException {
		return findByPrimaryKey((Serializable)examId);
	}

	/**
	 * Returns the exam with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param examId the primary key of the exam
	 * @return the exam, or <code>null</code> if a exam with the primary key could not be found
	 */
	@Override
	public Exam fetchByPrimaryKey(long examId) {
		return fetchByPrimaryKey((Serializable)examId);
	}

	/**
	 * Returns all the exams.
	 *
	 * @return the exams
	 */
	@Override
	public List<Exam> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Exam> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Exam> findAll(
		int start, int end, OrderByComparator<Exam> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Exam> findAll(
		int start, int end, OrderByComparator<Exam> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Exam> list = null;

		if (useFinderCache) {
			list = (List<Exam>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXAM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXAM;

				sql = sql.concat(ExamModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Exam>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the exams from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Exam exam : findAll()) {
			remove(exam);
		}
	}

	/**
	 * Returns the number of exams.
	 *
	 * @return the number of exams
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXAM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "examId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXAM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExamModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the exam persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByfindByStudent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByStudent",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"studentId"}, true);

		_finderPathWithoutPaginationFindByfindByStudent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByStudent",
			new String[] {Long.class.getName()}, new String[] {"studentId"},
			true);

		_finderPathCountByfindByStudent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByStudent",
			new String[] {Long.class.getName()}, new String[] {"studentId"},
			false);

		_finderPathWithPaginationFindByfindByTeacher = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByTeacher",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"teacherId"}, true);

		_finderPathWithoutPaginationFindByfindByTeacher = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByTeacher",
			new String[] {Long.class.getName()}, new String[] {"teacherId"},
			true);

		_finderPathCountByfindByTeacher = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByTeacher",
			new String[] {Long.class.getName()}, new String[] {"teacherId"},
			false);

		_finderPathWithPaginationFindByfindByCourse = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByCourse",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"courseId"}, true);

		_finderPathWithoutPaginationFindByfindByCourse = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByCourse",
			new String[] {Long.class.getName()}, new String[] {"courseId"},
			true);

		_finderPathCountByfindByCourse = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByCourse",
			new String[] {Long.class.getName()}, new String[] {"courseId"},
			false);

		_finderPathWithPaginationFindByfindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"examDate"}, true);

		_finderPathWithoutPaginationFindByfindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByDate",
			new String[] {Date.class.getName()}, new String[] {"examDate"},
			true);

		_finderPathCountByfindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByDate",
			new String[] {Date.class.getName()}, new String[] {"examDate"},
			false);

		_finderPathWithPaginationFindByfindByGrade = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByGrade",
			new String[] {
				Double.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"grade"}, true);

		_finderPathWithoutPaginationFindByfindByGrade = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByGrade",
			new String[] {Double.class.getName()}, new String[] {"grade"},
			true);

		_finderPathCountByfindByGrade = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByGrade",
			new String[] {Double.class.getName()}, new String[] {"grade"},
			false);

		ExamUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ExamUtil.setPersistence(null);

		entityCache.removeCache(ExamImpl.class.getName());
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_EXAM = "SELECT exam FROM Exam exam";

	private static final String _SQL_SELECT_EXAM_WHERE =
		"SELECT exam FROM Exam exam WHERE ";

	private static final String _SQL_COUNT_EXAM =
		"SELECT COUNT(exam) FROM Exam exam";

	private static final String _SQL_COUNT_EXAM_WHERE =
		"SELECT COUNT(exam) FROM Exam exam WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "exam.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Exam exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Exam exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExamPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}