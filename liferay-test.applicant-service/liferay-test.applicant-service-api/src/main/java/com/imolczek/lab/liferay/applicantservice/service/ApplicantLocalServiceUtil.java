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

package com.imolczek.lab.liferay.applicantservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Applicant. This utility wraps
 * {@link com.imolczek.lab.liferay.applicantservice.service.impl.ApplicantLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ApplicantLocalService
 * @see com.imolczek.lab.liferay.applicantservice.service.base.ApplicantLocalServiceBaseImpl
 * @see com.imolczek.lab.liferay.applicantservice.service.impl.ApplicantLocalServiceImpl
 * @generated
 */
@ProviderType
public class ApplicantLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.imolczek.lab.liferay.applicantservice.service.impl.ApplicantLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the applicant to the database. Also notifies the appropriate model listeners.
	*
	* @param applicant the applicant
	* @return the applicant that was added
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant addApplicant(
		com.imolczek.lab.liferay.applicantservice.model.Applicant applicant) {
		return getService().addApplicant(applicant);
	}

	/**
	* Creates a new applicant with the primary key. Does not add the applicant to the database.
	*
	* @param applicantId the primary key for the new applicant
	* @return the new applicant
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant createApplicant(
		long applicantId) {
		return getService().createApplicant(applicantId);
	}

	/**
	* Deletes the applicant from the database. Also notifies the appropriate model listeners.
	*
	* @param applicant the applicant
	* @return the applicant that was removed
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant deleteApplicant(
		com.imolczek.lab.liferay.applicantservice.model.Applicant applicant) {
		return getService().deleteApplicant(applicant);
	}

	/**
	* Deletes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant that was removed
	* @throws PortalException if a applicant with the primary key could not be found
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant deleteApplicant(
		long applicantId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteApplicant(applicantId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.imolczek.lab.liferay.applicantservice.model.Applicant fetchApplicant(
		long applicantId) {
		return getService().fetchApplicant(applicantId);
	}

	/**
	* Returns the applicant matching the UUID and group.
	*
	* @param uuid the applicant's UUID
	* @param groupId the primary key of the group
	* @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant fetchApplicantByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchApplicantByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the applicant with the primary key.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant
	* @throws PortalException if a applicant with the primary key could not be found
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant getApplicant(
		long applicantId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getApplicant(applicantId);
	}

	/**
	* Returns the applicant matching the UUID and group.
	*
	* @param uuid the applicant's UUID
	* @param groupId the primary key of the group
	* @return the matching applicant
	* @throws PortalException if a matching applicant could not be found
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant getApplicantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getApplicantByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the applicants.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @return the range of applicants
	*/
	public static java.util.List<com.imolczek.lab.liferay.applicantservice.model.Applicant> getApplicants(
		int start, int end) {
		return getService().getApplicants(start, end);
	}

	/**
	* Returns all the applicants matching the UUID and company.
	*
	* @param uuid the UUID of the applicants
	* @param companyId the primary key of the company
	* @return the matching applicants, or an empty list if no matches were found
	*/
	public static java.util.List<com.imolczek.lab.liferay.applicantservice.model.Applicant> getApplicantsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getApplicantsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of applicants matching the UUID and company.
	*
	* @param uuid the UUID of the applicants
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of applicants
	* @param end the upper bound of the range of applicants (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching applicants, or an empty list if no matches were found
	*/
	public static java.util.List<com.imolczek.lab.liferay.applicantservice.model.Applicant> getApplicantsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.imolczek.lab.liferay.applicantservice.model.Applicant> orderByComparator) {
		return getService()
				   .getApplicantsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of applicants.
	*
	* @return the number of applicants
	*/
	public static int getApplicantsCount() {
		return getService().getApplicantsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicant the applicant
	* @return the applicant that was updated
	*/
	public static com.imolczek.lab.liferay.applicantservice.model.Applicant updateApplicant(
		com.imolczek.lab.liferay.applicantservice.model.Applicant applicant) {
		return getService().updateApplicant(applicant);
	}

	public static ApplicantLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ApplicantLocalService, ApplicantLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ApplicantLocalService.class);
}