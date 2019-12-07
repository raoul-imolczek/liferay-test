/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.imolczek.lab.liferay.applicantservice.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException;
import com.imolczek.lab.liferay.applicantservice.model.Applicant;
import com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantImpl;
import com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl;
import com.imolczek.lab.liferay.applicantservice.service.persistence.ApplicantPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicantPersistence
 * @see com.imolczek.lab.liferay.applicantservice.service.persistence.ApplicantUtil
 * @generated
 */
@ProviderType
public class ApplicantPersistenceImpl extends BasePersistenceImpl<Applicant>
	implements ApplicantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicantUtil} to access the applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ApplicantModelImpl.UUID_COLUMN_BITMASK |
			ApplicantModelImpl.APPLICATIONSUBMISSIONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the applicants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching applicants
	 */
	@Override
	public List<Applicant> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of matching applicants
	 */
	@Override
	public List<Applicant> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the applicants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applicants
	 */
	@Override
	public List<Applicant> findByUuid(String uuid, int start, int end,
		OrderByComparator<Applicant> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the applicants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching applicants
	 */
	@Override
	public List<Applicant> findByUuid(String uuid, int start, int end,
		OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Applicant> list = null;

		if (retrieveFromCache) {
			list = (List<Applicant>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Applicant applicant : list) {
					if (!Objects.equals(uuid, applicant.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APPLICANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByUuid_First(String uuid,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByUuid_First(uuid, orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByUuid_First(String uuid,
		OrderByComparator<Applicant> orderByComparator) {
		List<Applicant> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByUuid_Last(String uuid,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByUuid_Last(uuid, orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByUuid_Last(String uuid,
		OrderByComparator<Applicant> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Applicant> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the applicants before and after the current applicant in the ordered set where uuid = &#63;.
	 *
	 * @param applicantId the primary key of the current applicant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next applicant
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant[] findByUuid_PrevAndNext(long applicantId, String uuid,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = findByPrimaryKey(applicantId);

		Session session = null;

		try {
			session = openSession();

			Applicant[] array = new ApplicantImpl[3];

			array[0] = getByUuid_PrevAndNext(session, applicant, uuid,
					orderByComparator, true);

			array[1] = applicant;

			array[2] = getByUuid_PrevAndNext(session, applicant, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Applicant getByUuid_PrevAndNext(Session session,
		Applicant applicant, String uuid,
		OrderByComparator<Applicant> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICANT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Applicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the applicants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Applicant applicant : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching applicants
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "applicant.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "applicant.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(applicant.uuid IS NULL OR applicant.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ApplicantModelImpl.UUID_COLUMN_BITMASK |
			ApplicantModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the applicant where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchApplicantException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByUUID_G(String uuid, long groupId)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByUUID_G(uuid, groupId);

		if (applicant == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchApplicantException(msg.toString());
		}

		return applicant;
	}

	/**
	 * Returns the applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Applicant) {
			Applicant applicant = (Applicant)result;

			if (!Objects.equals(uuid, applicant.getUuid()) ||
					(groupId != applicant.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_APPLICANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Applicant> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Applicant applicant = list.get(0);

					result = applicant;

					cacheResult(applicant);

					if ((applicant.getUuid() == null) ||
							!applicant.getUuid().equals(uuid) ||
							(applicant.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, applicant);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Applicant)result;
		}
	}

	/**
	 * Removes the applicant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the applicant that was removed
	 */
	@Override
	public Applicant removeByUUID_G(String uuid, long groupId)
		throws NoSuchApplicantException {
		Applicant applicant = findByUUID_G(uuid, groupId);

		return remove(applicant);
	}

	/**
	 * Returns the number of applicants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching applicants
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPLICANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "applicant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "applicant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(applicant.uuid IS NULL OR applicant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "applicant.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ApplicantModelImpl.UUID_COLUMN_BITMASK |
			ApplicantModelImpl.COMPANYID_COLUMN_BITMASK |
			ApplicantModelImpl.APPLICATIONSUBMISSIONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching applicants
	 */
	@Override
	public List<Applicant> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of matching applicants
	 */
	@Override
	public List<Applicant> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applicants
	 */
	@Override
	public List<Applicant> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Applicant> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching applicants
	 */
	@Override
	public List<Applicant> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Applicant> list = null;

		if (retrieveFromCache) {
			list = (List<Applicant>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Applicant applicant : list) {
					if (!Objects.equals(uuid, applicant.getUuid()) ||
							(companyId != applicant.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_APPLICANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Applicant> orderByComparator) {
		List<Applicant> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Applicant> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Applicant> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the applicants before and after the current applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param applicantId the primary key of the current applicant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next applicant
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant[] findByUuid_C_PrevAndNext(long applicantId, String uuid,
		long companyId, OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = findByPrimaryKey(applicantId);

		Session session = null;

		try {
			session = openSession();

			Applicant[] array = new ApplicantImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, applicant, uuid,
					companyId, orderByComparator, true);

			array[1] = applicant;

			array[2] = getByUuid_C_PrevAndNext(session, applicant, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Applicant getByUuid_C_PrevAndNext(Session session,
		Applicant applicant, String uuid, long companyId,
		OrderByComparator<Applicant> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_APPLICANT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Applicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the applicants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Applicant applicant : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching applicants
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPLICANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "applicant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "applicant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(applicant.uuid IS NULL OR applicant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "applicant.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTEMAIL =
		new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicantEmail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTEMAIL =
		new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicantEmail",
			new String[] { String.class.getName() },
			ApplicantModelImpl.APPLICANTEMAIL_COLUMN_BITMASK |
			ApplicantModelImpl.APPLICATIONSUBMISSIONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTEMAIL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplicantEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns all the applicants where applicantEmail = &#63;.
	 *
	 * @param applicantEmail the applicant email
	 * @return the matching applicants
	 */
	@Override
	public List<Applicant> findByApplicantEmail(String applicantEmail) {
		return findByApplicantEmail(applicantEmail, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants where applicantEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantEmail the applicant email
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of matching applicants
	 */
	@Override
	public List<Applicant> findByApplicantEmail(String applicantEmail,
		int start, int end) {
		return findByApplicantEmail(applicantEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the applicants where applicantEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantEmail the applicant email
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching applicants
	 */
	@Override
	public List<Applicant> findByApplicantEmail(String applicantEmail,
		int start, int end, OrderByComparator<Applicant> orderByComparator) {
		return findByApplicantEmail(applicantEmail, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the applicants where applicantEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantEmail the applicant email
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching applicants
	 */
	@Override
	public List<Applicant> findByApplicantEmail(String applicantEmail,
		int start, int end, OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTEMAIL;
			finderArgs = new Object[] { applicantEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTEMAIL;
			finderArgs = new Object[] {
					applicantEmail,
					
					start, end, orderByComparator
				};
		}

		List<Applicant> list = null;

		if (retrieveFromCache) {
			list = (List<Applicant>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Applicant applicant : list) {
					if (!Objects.equals(applicantEmail,
								applicant.getApplicantEmail())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APPLICANT_WHERE);

			boolean bindApplicantEmail = false;

			if (applicantEmail == null) {
				query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_1);
			}
			else if (applicantEmail.equals("")) {
				query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_3);
			}
			else {
				bindApplicantEmail = true;

				query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantEmail) {
					qPos.add(applicantEmail);
				}

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first applicant in the ordered set where applicantEmail = &#63;.
	 *
	 * @param applicantEmail the applicant email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByApplicantEmail_First(String applicantEmail,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByApplicantEmail_First(applicantEmail,
				orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantEmail=");
		msg.append(applicantEmail);

		msg.append("}");

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first applicant in the ordered set where applicantEmail = &#63;.
	 *
	 * @param applicantEmail the applicant email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByApplicantEmail_First(String applicantEmail,
		OrderByComparator<Applicant> orderByComparator) {
		List<Applicant> list = findByApplicantEmail(applicantEmail, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last applicant in the ordered set where applicantEmail = &#63;.
	 *
	 * @param applicantEmail the applicant email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant
	 * @throws NoSuchApplicantException if a matching applicant could not be found
	 */
	@Override
	public Applicant findByApplicantEmail_Last(String applicantEmail,
		OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByApplicantEmail_Last(applicantEmail,
				orderByComparator);

		if (applicant != null) {
			return applicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantEmail=");
		msg.append(applicantEmail);

		msg.append("}");

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last applicant in the ordered set where applicantEmail = &#63;.
	 *
	 * @param applicantEmail the applicant email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	 */
	@Override
	public Applicant fetchByApplicantEmail_Last(String applicantEmail,
		OrderByComparator<Applicant> orderByComparator) {
		int count = countByApplicantEmail(applicantEmail);

		if (count == 0) {
			return null;
		}

		List<Applicant> list = findByApplicantEmail(applicantEmail, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the applicants before and after the current applicant in the ordered set where applicantEmail = &#63;.
	 *
	 * @param applicantId the primary key of the current applicant
	 * @param applicantEmail the applicant email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next applicant
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant[] findByApplicantEmail_PrevAndNext(long applicantId,
		String applicantEmail, OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException {
		Applicant applicant = findByPrimaryKey(applicantId);

		Session session = null;

		try {
			session = openSession();

			Applicant[] array = new ApplicantImpl[3];

			array[0] = getByApplicantEmail_PrevAndNext(session, applicant,
					applicantEmail, orderByComparator, true);

			array[1] = applicant;

			array[2] = getByApplicantEmail_PrevAndNext(session, applicant,
					applicantEmail, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Applicant getByApplicantEmail_PrevAndNext(Session session,
		Applicant applicant, String applicantEmail,
		OrderByComparator<Applicant> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICANT_WHERE);

		boolean bindApplicantEmail = false;

		if (applicantEmail == null) {
			query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_1);
		}
		else if (applicantEmail.equals("")) {
			query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_3);
		}
		else {
			bindApplicantEmail = true;

			query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApplicantEmail) {
			qPos.add(applicantEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Applicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the applicants where applicantEmail = &#63; from the database.
	 *
	 * @param applicantEmail the applicant email
	 */
	@Override
	public void removeByApplicantEmail(String applicantEmail) {
		for (Applicant applicant : findByApplicantEmail(applicantEmail,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants where applicantEmail = &#63;.
	 *
	 * @param applicantEmail the applicant email
	 * @return the number of matching applicants
	 */
	@Override
	public int countByApplicantEmail(String applicantEmail) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTEMAIL;

		Object[] finderArgs = new Object[] { applicantEmail };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICANT_WHERE);

			boolean bindApplicantEmail = false;

			if (applicantEmail == null) {
				query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_1);
			}
			else if (applicantEmail.equals("")) {
				query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_3);
			}
			else {
				bindApplicantEmail = true;

				query.append(_FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantEmail) {
					qPos.add(applicantEmail);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_1 = "applicant.applicantEmail IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_2 = "applicant.applicantEmail = ?";
	private static final String _FINDER_COLUMN_APPLICANTEMAIL_APPLICANTEMAIL_3 = "(applicant.applicantEmail IS NULL OR applicant.applicantEmail = '')";

	public ApplicantPersistenceImpl() {
		setModelClass(Applicant.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the applicant in the entity cache if it is enabled.
	 *
	 * @param applicant the applicant
	 */
	@Override
	public void cacheResult(Applicant applicant) {
		entityCache.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantImpl.class, applicant.getPrimaryKey(), applicant);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { applicant.getUuid(), applicant.getGroupId() },
			applicant);

		applicant.resetOriginalValues();
	}

	/**
	 * Caches the applicants in the entity cache if it is enabled.
	 *
	 * @param applicants the applicants
	 */
	@Override
	public void cacheResult(List<Applicant> applicants) {
		for (Applicant applicant : applicants) {
			if (entityCache.getResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
						ApplicantImpl.class, applicant.getPrimaryKey()) == null) {
				cacheResult(applicant);
			}
			else {
				applicant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all applicants.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicantImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the applicant.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Applicant applicant) {
		entityCache.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantImpl.class, applicant.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ApplicantModelImpl)applicant, true);
	}

	@Override
	public void clearCache(List<Applicant> applicants) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Applicant applicant : applicants) {
			entityCache.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
				ApplicantImpl.class, applicant.getPrimaryKey());

			clearUniqueFindersCache((ApplicantModelImpl)applicant, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ApplicantModelImpl applicantModelImpl) {
		Object[] args = new Object[] {
				applicantModelImpl.getUuid(), applicantModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			applicantModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ApplicantModelImpl applicantModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					applicantModelImpl.getUuid(),
					applicantModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((applicantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					applicantModelImpl.getOriginalUuid(),
					applicantModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new applicant with the primary key. Does not add the applicant to the database.
	 *
	 * @param applicantId the primary key for the new applicant
	 * @return the new applicant
	 */
	@Override
	public Applicant create(long applicantId) {
		Applicant applicant = new ApplicantImpl();

		applicant.setNew(true);
		applicant.setPrimaryKey(applicantId);

		String uuid = PortalUUIDUtil.generate();

		applicant.setUuid(uuid);

		applicant.setCompanyId(companyProvider.getCompanyId());

		return applicant;
	}

	/**
	 * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant that was removed
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant remove(long applicantId) throws NoSuchApplicantException {
		return remove((Serializable)applicantId);
	}

	/**
	 * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the applicant
	 * @return the applicant that was removed
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant remove(Serializable primaryKey)
		throws NoSuchApplicantException {
		Session session = null;

		try {
			session = openSession();

			Applicant applicant = (Applicant)session.get(ApplicantImpl.class,
					primaryKey);

			if (applicant == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicant);
		}
		catch (NoSuchApplicantException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Applicant removeImpl(Applicant applicant) {
		applicant = toUnwrappedModel(applicant);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicant)) {
				applicant = (Applicant)session.get(ApplicantImpl.class,
						applicant.getPrimaryKeyObj());
			}

			if (applicant != null) {
				session.delete(applicant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicant != null) {
			clearCache(applicant);
		}

		return applicant;
	}

	@Override
	public Applicant updateImpl(Applicant applicant) {
		applicant = toUnwrappedModel(applicant);

		boolean isNew = applicant.isNew();

		ApplicantModelImpl applicantModelImpl = (ApplicantModelImpl)applicant;

		if (Validator.isNull(applicant.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			applicant.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicant.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicant.setCreateDate(now);
			}
			else {
				applicant.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!applicantModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicant.setModifiedDate(now);
			}
			else {
				applicant.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicant.isNew()) {
				session.save(applicant);

				applicant.setNew(false);
			}
			else {
				applicant = (Applicant)session.merge(applicant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ApplicantModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { applicantModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					applicantModelImpl.getUuid(),
					applicantModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { applicantModelImpl.getApplicantEmail() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTEMAIL, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTEMAIL,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((applicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicantModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { applicantModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((applicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicantModelImpl.getOriginalUuid(),
						applicantModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						applicantModelImpl.getUuid(),
						applicantModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((applicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTEMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicantModelImpl.getOriginalApplicantEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTEMAIL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTEMAIL,
					args);

				args = new Object[] { applicantModelImpl.getApplicantEmail() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTEMAIL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTEMAIL,
					args);
			}
		}

		entityCache.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
			ApplicantImpl.class, applicant.getPrimaryKey(), applicant, false);

		clearUniqueFindersCache(applicantModelImpl, false);
		cacheUniqueFindersCache(applicantModelImpl);

		applicant.resetOriginalValues();

		return applicant;
	}

	protected Applicant toUnwrappedModel(Applicant applicant) {
		if (applicant instanceof ApplicantImpl) {
			return applicant;
		}

		ApplicantImpl applicantImpl = new ApplicantImpl();

		applicantImpl.setNew(applicant.isNew());
		applicantImpl.setPrimaryKey(applicant.getPrimaryKey());

		applicantImpl.setUuid(applicant.getUuid());
		applicantImpl.setApplicantId(applicant.getApplicantId());
		applicantImpl.setGroupId(applicant.getGroupId());
		applicantImpl.setCompanyId(applicant.getCompanyId());
		applicantImpl.setUserId(applicant.getUserId());
		applicantImpl.setUserName(applicant.getUserName());
		applicantImpl.setCreateDate(applicant.getCreateDate());
		applicantImpl.setModifiedDate(applicant.getModifiedDate());
		applicantImpl.setApplicantName(applicant.getApplicantName());
		applicantImpl.setApplicantSurname(applicant.getApplicantSurname());
		applicantImpl.setApplicantEmail(applicant.getApplicantEmail());
		applicantImpl.setApplicantBirthDate(applicant.getApplicantBirthDate());
		applicantImpl.setApplicationSubmissionDate(applicant.getApplicationSubmissionDate());

		return applicantImpl;
	}

	/**
	 * Returns the applicant with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the applicant
	 * @return the applicant
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicantException {
		Applicant applicant = fetchByPrimaryKey(primaryKey);

		if (applicant == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicant;
	}

	/**
	 * Returns the applicant with the primary key or throws a {@link NoSuchApplicantException} if it could not be found.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant
	 * @throws NoSuchApplicantException if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant findByPrimaryKey(long applicantId)
		throws NoSuchApplicantException {
		return findByPrimaryKey((Serializable)applicantId);
	}

	/**
	 * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the applicant
	 * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
				ApplicantImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Applicant applicant = (Applicant)serializable;

		if (applicant == null) {
			Session session = null;

			try {
				session = openSession();

				applicant = (Applicant)session.get(ApplicantImpl.class,
						primaryKey);

				if (applicant != null) {
					cacheResult(applicant);
				}
				else {
					entityCache.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
						ApplicantImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
					ApplicantImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicant;
	}

	/**
	 * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	 */
	@Override
	public Applicant fetchByPrimaryKey(long applicantId) {
		return fetchByPrimaryKey((Serializable)applicantId);
	}

	@Override
	public Map<Serializable, Applicant> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Applicant> map = new HashMap<Serializable, Applicant>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Applicant applicant = fetchByPrimaryKey(primaryKey);

			if (applicant != null) {
				map.put(primaryKey, applicant);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
					ApplicantImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Applicant)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICANT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Applicant applicant : (List<Applicant>)q.list()) {
				map.put(applicant.getPrimaryKeyObj(), applicant);

				cacheResult(applicant);

				uncachedPrimaryKeys.remove(applicant.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
					ApplicantImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the applicants.
	 *
	 * @return the applicants
	 */
	@Override
	public List<Applicant> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of applicants
	 */
	@Override
	public List<Applicant> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of applicants
	 */
	@Override
	public List<Applicant> findAll(int start, int end,
		OrderByComparator<Applicant> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of applicants
	 */
	@Override
	public List<Applicant> findAll(int start, int end,
		OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Applicant> list = null;

		if (retrieveFromCache) {
			list = (List<Applicant>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICANT;

				if (pagination) {
					sql = sql.concat(ApplicantModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Applicant>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the applicants from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Applicant applicant : findAll()) {
			remove(applicant);
		}
	}

	/**
	 * Returns the number of applicants.
	 *
	 * @return the number of applicants
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICANT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApplicantModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the applicant persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicantImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_APPLICANT = "SELECT applicant FROM Applicant applicant";
	private static final String _SQL_SELECT_APPLICANT_WHERE_PKS_IN = "SELECT applicant FROM Applicant applicant WHERE applicantId IN (";
	private static final String _SQL_SELECT_APPLICANT_WHERE = "SELECT applicant FROM Applicant applicant WHERE ";
	private static final String _SQL_COUNT_APPLICANT = "SELECT COUNT(applicant) FROM Applicant applicant";
	private static final String _SQL_COUNT_APPLICANT_WHERE = "SELECT COUNT(applicant) FROM Applicant applicant WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Applicant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Applicant exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicantPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}