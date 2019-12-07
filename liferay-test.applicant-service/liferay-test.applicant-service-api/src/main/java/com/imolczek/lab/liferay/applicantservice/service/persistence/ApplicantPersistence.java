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

import com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException;
import com.imolczek.lab.liferay.applicantservice.model.Applicant;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.imolczek.lab.liferay.applicantservice.service.persistence.impl.ApplicantPersistenceImpl
 * @see ApplicantUtil
 * @generated
 */
@ProviderType
public interface ApplicantPersistence extends BasePersistence<Applicant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicantUtil} to access the applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching applicants
	*/
	public java.util.List<Applicant> findByUuid(java.lang.String uuid);

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
	public java.util.List<Applicant> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<Applicant> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

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
	public java.util.List<Applicant> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Returns the first applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

	/**
	* Returns the last applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Returns the last applicant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

	/**
	* Returns the applicants before and after the current applicant in the ordered set where uuid = &#63;.
	*
	* @param applicantId the primary key of the current applicant
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next applicant
	* @throws NoSuchApplicantException if a applicant with the primary key could not be found
	*/
	public Applicant[] findByUuid_PrevAndNext(long applicantId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Removes all the applicants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of applicants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching applicants
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the applicant where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchApplicantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchApplicantException;

	/**
	* Returns the applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the applicant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the applicant that was removed
	*/
	public Applicant removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchApplicantException;

	/**
	* Returns the number of applicants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching applicants
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching applicants
	*/
	public java.util.List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

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
	public java.util.List<Applicant> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Returns the first applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

	/**
	* Returns the last applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Returns the last applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

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
	public Applicant[] findByUuid_C_PrevAndNext(long applicantId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Removes all the applicants where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of applicants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching applicants
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the applicants where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @return the matching applicants
	*/
	public java.util.List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail);

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
	public java.util.List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail, int start, int end);

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
	public java.util.List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

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
	public java.util.List<Applicant> findByApplicantEmail(
		java.lang.String applicantEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByApplicantEmail_First(
		java.lang.String applicantEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Returns the first applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByApplicantEmail_First(
		java.lang.String applicantEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

	/**
	* Returns the last applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant
	* @throws NoSuchApplicantException if a matching applicant could not be found
	*/
	public Applicant findByApplicantEmail_Last(
		java.lang.String applicantEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Returns the last applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public Applicant fetchByApplicantEmail_Last(
		java.lang.String applicantEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

	/**
	* Returns the applicants before and after the current applicant in the ordered set where applicantEmail = &#63;.
	*
	* @param applicantId the primary key of the current applicant
	* @param applicantEmail the applicant email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next applicant
	* @throws NoSuchApplicantException if a applicant with the primary key could not be found
	*/
	public Applicant[] findByApplicantEmail_PrevAndNext(long applicantId,
		java.lang.String applicantEmail,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator)
		throws NoSuchApplicantException;

	/**
	* Removes all the applicants where applicantEmail = &#63; from the database.
	*
	* @param applicantEmail the applicant email
	*/
	public void removeByApplicantEmail(java.lang.String applicantEmail);

	/**
	* Returns the number of applicants where applicantEmail = &#63;.
	*
	* @param applicantEmail the applicant email
	* @return the number of matching applicants
	*/
	public int countByApplicantEmail(java.lang.String applicantEmail);

	/**
	* Caches the applicant in the entity cache if it is enabled.
	*
	* @param applicant the applicant
	*/
	public void cacheResult(Applicant applicant);

	/**
	* Caches the applicants in the entity cache if it is enabled.
	*
	* @param applicants the applicants
	*/
	public void cacheResult(java.util.List<Applicant> applicants);

	/**
	* Creates a new applicant with the primary key. Does not add the applicant to the database.
	*
	* @param applicantId the primary key for the new applicant
	* @return the new applicant
	*/
	public Applicant create(long applicantId);

	/**
	* Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant that was removed
	* @throws NoSuchApplicantException if a applicant with the primary key could not be found
	*/
	public Applicant remove(long applicantId) throws NoSuchApplicantException;

	public Applicant updateImpl(Applicant applicant);

	/**
	* Returns the applicant with the primary key or throws a {@link NoSuchApplicantException} if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant
	* @throws NoSuchApplicantException if a applicant with the primary key could not be found
	*/
	public Applicant findByPrimaryKey(long applicantId)
		throws NoSuchApplicantException;

	/**
	* Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
	*/
	public Applicant fetchByPrimaryKey(long applicantId);

	@Override
	public java.util.Map<java.io.Serializable, Applicant> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the applicants.
	*
	* @return the applicants
	*/
	public java.util.List<Applicant> findAll();

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
	public java.util.List<Applicant> findAll(int start, int end);

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
	public java.util.List<Applicant> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator);

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
	public java.util.List<Applicant> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Applicant> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the applicants from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of applicants.
	*
	* @return the number of applicants
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}