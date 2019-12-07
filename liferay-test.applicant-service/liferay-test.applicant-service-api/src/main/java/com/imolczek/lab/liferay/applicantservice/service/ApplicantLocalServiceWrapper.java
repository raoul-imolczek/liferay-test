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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApplicantLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApplicantLocalService
 * @generated
 */
@ProviderType
public class ApplicantLocalServiceWrapper implements ApplicantLocalService,
	ServiceWrapper<ApplicantLocalService> {
	public ApplicantLocalServiceWrapper(
		ApplicantLocalService applicantLocalService) {
		_applicantLocalService = applicantLocalService;
	}

	/**
	* Adds the applicant to the database. Also notifies the appropriate model listeners.
	*
	* @param applicant the applicant
	* @return the applicant that was added
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant addApplicant(
		com.imolczek.lab.liferay.applicantservice.model.Applicant applicant) {
		return _applicantLocalService.addApplicant(applicant);
	}

	/**
	* Creates a new applicant with the primary key. Does not add the applicant to the database.
	*
	* @param applicantId the primary key for the new applicant
	* @return the new applicant
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant createApplicant(
		long applicantId) {
		return _applicantLocalService.createApplicant(applicantId);
	}

	/**
	* Deletes the applicant from the database. Also notifies the appropriate model listeners.
	*
	* @param applicant the applicant
	* @return the applicant that was removed
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant deleteApplicant(
		com.imolczek.lab.liferay.applicantservice.model.Applicant applicant) {
		return _applicantLocalService.deleteApplicant(applicant);
	}

	/**
	* Deletes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant that was removed
	* @throws PortalException if a applicant with the primary key could not be found
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant deleteApplicant(
		long applicantId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicantLocalService.deleteApplicant(applicantId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicantLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicantLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _applicantLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _applicantLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _applicantLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _applicantLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _applicantLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant fetchApplicant(
		long applicantId) {
		return _applicantLocalService.fetchApplicant(applicantId);
	}

	/**
	* Returns the applicant matching the UUID and group.
	*
	* @param uuid the applicant's UUID
	* @param groupId the primary key of the group
	* @return the matching applicant, or <code>null</code> if a matching applicant could not be found
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant fetchApplicantByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _applicantLocalService.fetchApplicantByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _applicantLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the applicant with the primary key.
	*
	* @param applicantId the primary key of the applicant
	* @return the applicant
	* @throws PortalException if a applicant with the primary key could not be found
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant getApplicant(
		long applicantId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicantLocalService.getApplicant(applicantId);
	}

	/**
	* Returns the applicant matching the UUID and group.
	*
	* @param uuid the applicant's UUID
	* @param groupId the primary key of the group
	* @return the matching applicant
	* @throws PortalException if a matching applicant could not be found
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant getApplicantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicantLocalService.getApplicantByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.imolczek.lab.liferay.applicantservice.model.Applicant> getApplicants(
		int start, int end) {
		return _applicantLocalService.getApplicants(start, end);
	}

	/**
	* Returns all the applicants matching the UUID and company.
	*
	* @param uuid the UUID of the applicants
	* @param companyId the primary key of the company
	* @return the matching applicants, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.imolczek.lab.liferay.applicantservice.model.Applicant> getApplicantsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _applicantLocalService.getApplicantsByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.imolczek.lab.liferay.applicantservice.model.Applicant> getApplicantsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.imolczek.lab.liferay.applicantservice.model.Applicant> orderByComparator) {
		return _applicantLocalService.getApplicantsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of applicants.
	*
	* @return the number of applicants
	*/
	@Override
	public int getApplicantsCount() {
		return _applicantLocalService.getApplicantsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _applicantLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _applicantLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicantLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicantLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicant the applicant
	* @return the applicant that was updated
	*/
	@Override
	public com.imolczek.lab.liferay.applicantservice.model.Applicant updateApplicant(
		com.imolczek.lab.liferay.applicantservice.model.Applicant applicant) {
		return _applicantLocalService.updateApplicant(applicant);
	}

	@Override
	public ApplicantLocalService getWrappedService() {
		return _applicantLocalService;
	}

	@Override
	public void setWrappedService(ApplicantLocalService applicantLocalService) {
		_applicantLocalService = applicantLocalService;
	}

	private ApplicantLocalService _applicantLocalService;
}