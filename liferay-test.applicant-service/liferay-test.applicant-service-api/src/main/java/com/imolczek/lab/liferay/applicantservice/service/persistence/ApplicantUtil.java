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

package com.imolczek.lab.liferay.applicantservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.imolczek.lab.liferay.applicantservice.model.Applicant;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the applicant service. This utility wraps {@link com.imolczek.lab.liferay.applicantservice.service.persistence.impl.ApplicantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicantPersistence
 * @see com.imolczek.lab.liferay.applicantservice.service.persistence.impl.ApplicantPersistenceImpl
 * @generated
 */
@ProviderType
public class ApplicantUtil {
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
	public static void clearCache(Applicant applicant) {
		getPersistence().clearCache(applicant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Applicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Applicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Applicant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Applicant update(Applicant applicant) {
		return getPersistence().update(applicant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Applicant update(Applicant applicant,
		ServiceContext serviceContext) {
		return getPersistence().update(applicant, serviceContext);
	}

	/**
	* Returns all the applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching applicants
	*/
	public static List<Applicant> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Applicant> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Applicant> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Applicant> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Applicant> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public static Applicant findByUuid_First(java.lang.String uuid,
		OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public static Applicant findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Applicant[] findByUuid_PrevAndNext(long applicantId,
		java.lang.String uuid, OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_PrevAndNext(applicantId, uuid, orderByComparator);
	}

	/**
	* Removes all the applicants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching applicants
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the applicant where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchApplicantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public static Applicant findByUUID_G(java.lang.String uuid, long groupId)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the applicant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the applicant that was removed
	*/
	public static Applicant removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of applicants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching applicants
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching applicants
	*/
	public static List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static Applicant findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static Applicant findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static Applicant[] findByUuid_C_PrevAndNext(long applicantId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(applicantId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the applicants where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching applicants
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the applicants where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @return the matching applicants
	*/
	public static List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail) {
		return getPersistence().findByApplicantEmail(applicantEmail);
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
	public static List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail, int start, int end) {
		return getPersistence().findByApplicantEmail(applicantEmail, start, end);
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
	public static List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail, int start, int end,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .findByApplicantEmail(applicantEmail, start, end,
			orderByComparator);
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
	public static List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail, int start, int end,
		OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicantEmail(applicantEmail, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public static Applicant findByApplicantEmail_First(
		java.lang.String applicantEmail,
		OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByApplicantEmail_First(applicantEmail, orderByComparator);
	}

	/**
	* Returns the first applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByApplicantEmail_First(
		java.lang.String applicantEmail,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .fetchByApplicantEmail_First(applicantEmail,
			orderByComparator);
	}

	/**
	* Returns the last applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public static Applicant findByApplicantEmail_Last(
		java.lang.String applicantEmail,
		OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByApplicantEmail_Last(applicantEmail, orderByComparator);
	}

	/**
	* Returns the last applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static Applicant fetchByApplicantEmail_Last(
		java.lang.String applicantEmail,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence()
				   .fetchByApplicantEmail_Last(applicantEmail, orderByComparator);
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
	public static Applicant[] findByApplicantEmail_PrevAndNext(
		long applicantId, java.lang.String applicantEmail,
		OrderByComparator<Applicant> orderByComparator)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence()
				   .findByApplicantEmail_PrevAndNext(applicantId,
			applicantEmail, orderByComparator);
	}

	/**
	* Removes all the applicants where applicantEmail = &#63; from the database.
	*
	* @param applicantEmail the applicant email
	*/
	public static void removeByApplicantEmail(java.lang.String applicantEmail) {
		getPersistence().removeByApplicantEmail(applicantEmail);
	}

	/**
	* Returns the number of applicants where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @return the number of matching applicants
	*/
	public static int countByApplicantEmail(java.lang.String applicantEmail) {
		return getPersistence().countByApplicantEmail(applicantEmail);
	}

	/**
	* Caches the applicant in the entity cache if it is enabled.
	*
	* @param applicant the applicant
	*/
	public static void cacheResult(Applicant applicant) {
		getPersistence().cacheResult(applicant);
	}

	/**
	* Caches the applicants in the entity cache if it is enabled.
	*
	* @param applicants the applicants
	*/
	public static void cacheResult(List<Applicant> applicants) {
		getPersistence().cacheResult(applicants);
	}

	/**
	* Creates a new applicant with the primary key. Does not add the applicant to the database.
	*
	* @param applicantId the primary key for the new applicant
	* @return the new applicant
	*/
	public static Applicant create(long applicantId) {
		return getPersistence().create(applicantId);
	}

	/**
	* Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant that was removed
	* @throws NoSuchApplicantException if a applicant with the primary key could not be found
	*/
	public static Applicant remove(long applicantId)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence().remove(applicantId);
	}

	public static Applicant updateImpl(Applicant applicant) {
		return getPersistence().updateImpl(applicant);
	}

	/**
	* Returns the applicant with the primary key or throws a {@link NoSuchApplicantException} if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant
	* @throws NoSuchApplicantException if a applicant with the primary key could not be found
	*/
	public static Applicant findByPrimaryKey(long applicantId)
		throws com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException {
		return getPersistence().findByPrimaryKey(applicantId);
	}

	/**
	* Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	*/
	public static Applicant fetchByPrimaryKey(long applicantId) {
		return getPersistence().fetchByPrimaryKey(applicantId);
	}

	public static java.util.Map<java.io.Serializable, Applicant> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the applicants.
	*
	* @return the applicants
	*/
	public static List<Applicant> findAll() {
		return getPersistence().findAll();
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
	public static List<Applicant> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Applicant> findAll(int start, int end,
		OrderByComparator<Applicant> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Applicant> findAll(int start, int end,
		OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the applicants from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of applicants.
	*
	* @return the number of applicants
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ApplicantPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ApplicantPersistence, ApplicantPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ApplicantPersistence.class);
}