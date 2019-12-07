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

package com.imolczek.lab.liferay.applicantservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Applicant}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Applicant
 * @generated
 */
@ProviderType
public class ApplicantWrapper implements Applicant, ModelWrapper<Applicant> {
	public ApplicantWrapper(Applicant applicant) {
		_applicant = applicant;
	}

	@Override
	public Class<?> getModelClass() {
		return Applicant.class;
	}

	@Override
	public String getModelClassName() {
		return Applicant.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("applicantId", getApplicantId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicantName", getApplicantName());
		attributes.put("applicantSurname", getApplicantSurname());
		attributes.put("applicantEmail", getApplicantEmail());
		attributes.put("applicantBirthDate", getApplicantBirthDate());
		attributes.put("applicationSubmissionDate",
			getApplicationSubmissionDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long applicantId = (Long)attributes.get("applicantId");

		if (applicantId != null) {
			setApplicantId(applicantId);
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

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String applicantSurname = (String)attributes.get("applicantSurname");

		if (applicantSurname != null) {
			setApplicantSurname(applicantSurname);
		}

		String applicantEmail = (String)attributes.get("applicantEmail");

		if (applicantEmail != null) {
			setApplicantEmail(applicantEmail);
		}

		Date applicantBirthDate = (Date)attributes.get("applicantBirthDate");

		if (applicantBirthDate != null) {
			setApplicantBirthDate(applicantBirthDate);
		}

		Date applicationSubmissionDate = (Date)attributes.get(
				"applicationSubmissionDate");

		if (applicationSubmissionDate != null) {
			setApplicationSubmissionDate(applicationSubmissionDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicantWrapper((Applicant)_applicant.clone());
	}

	@Override
	public int compareTo(Applicant applicant) {
		return _applicant.compareTo(applicant);
	}

	/**
	* Returns the applicant birth date of this applicant.
	*
	* @return the applicant birth date of this applicant
	*/
	@Override
	public Date getApplicantBirthDate() {
		return _applicant.getApplicantBirthDate();
	}

	/**
	* Returns the applicant email of this applicant.
	*
	* @return the applicant email of this applicant
	*/
	@Override
	public java.lang.String getApplicantEmail() {
		return _applicant.getApplicantEmail();
	}

	/**
	* Returns the applicant ID of this applicant.
	*
	* @return the applicant ID of this applicant
	*/
	@Override
	public long getApplicantId() {
		return _applicant.getApplicantId();
	}

	/**
	* Returns the applicant name of this applicant.
	*
	* @return the applicant name of this applicant
	*/
	@Override
	public java.lang.String getApplicantName() {
		return _applicant.getApplicantName();
	}

	/**
	* Returns the applicant surname of this applicant.
	*
	* @return the applicant surname of this applicant
	*/
	@Override
	public java.lang.String getApplicantSurname() {
		return _applicant.getApplicantSurname();
	}

	/**
	* Returns the application submission date of this applicant.
	*
	* @return the application submission date of this applicant
	*/
	@Override
	public Date getApplicationSubmissionDate() {
		return _applicant.getApplicationSubmissionDate();
	}

	/**
	* Returns the company ID of this applicant.
	*
	* @return the company ID of this applicant
	*/
	@Override
	public long getCompanyId() {
		return _applicant.getCompanyId();
	}

	/**
	* Returns the create date of this applicant.
	*
	* @return the create date of this applicant
	*/
	@Override
	public Date getCreateDate() {
		return _applicant.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicant.getExpandoBridge();
	}

	/**
	* Returns the group ID of this applicant.
	*
	* @return the group ID of this applicant
	*/
	@Override
	public long getGroupId() {
		return _applicant.getGroupId();
	}

	/**
	* Returns the modified date of this applicant.
	*
	* @return the modified date of this applicant
	*/
	@Override
	public Date getModifiedDate() {
		return _applicant.getModifiedDate();
	}

	/**
	* Returns the primary key of this applicant.
	*
	* @return the primary key of this applicant
	*/
	@Override
	public long getPrimaryKey() {
		return _applicant.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicant.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this applicant.
	*
	* @return the user ID of this applicant
	*/
	@Override
	public long getUserId() {
		return _applicant.getUserId();
	}

	/**
	* Returns the user name of this applicant.
	*
	* @return the user name of this applicant
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicant.getUserName();
	}

	/**
	* Returns the user uuid of this applicant.
	*
	* @return the user uuid of this applicant
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicant.getUserUuid();
	}

	/**
	* Returns the uuid of this applicant.
	*
	* @return the uuid of this applicant
	*/
	@Override
	public java.lang.String getUuid() {
		return _applicant.getUuid();
	}

	@Override
	public int hashCode() {
		return _applicant.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _applicant.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicant.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _applicant.isNew();
	}

	@Override
	public void persist() {
		_applicant.persist();
	}

	/**
	* Sets the applicant birth date of this applicant.
	*
	* @param applicantBirthDate the applicant birth date of this applicant
	*/
	@Override
	public void setApplicantBirthDate(Date applicantBirthDate) {
		_applicant.setApplicantBirthDate(applicantBirthDate);
	}

	/**
	* Sets the applicant email of this applicant.
	*
	* @param applicantEmail the applicant email of this applicant
	*/
	@Override
	public void setApplicantEmail(java.lang.String applicantEmail) {
		_applicant.setApplicantEmail(applicantEmail);
	}

	/**
	* Sets the applicant ID of this applicant.
	*
	* @param applicantId the applicant ID of this applicant
	*/
	@Override
	public void setApplicantId(long applicantId) {
		_applicant.setApplicantId(applicantId);
	}

	/**
	* Sets the applicant name of this applicant.
	*
	* @param applicantName the applicant name of this applicant
	*/
	@Override
	public void setApplicantName(java.lang.String applicantName) {
		_applicant.setApplicantName(applicantName);
	}

	/**
	* Sets the applicant surname of this applicant.
	*
	* @param applicantSurname the applicant surname of this applicant
	*/
	@Override
	public void setApplicantSurname(java.lang.String applicantSurname) {
		_applicant.setApplicantSurname(applicantSurname);
	}

	/**
	* Sets the application submission date of this applicant.
	*
	* @param applicationSubmissionDate the application submission date of this applicant
	*/
	@Override
	public void setApplicationSubmissionDate(Date applicationSubmissionDate) {
		_applicant.setApplicationSubmissionDate(applicationSubmissionDate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicant.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this applicant.
	*
	* @param companyId the company ID of this applicant
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicant.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this applicant.
	*
	* @param createDate the create date of this applicant
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicant.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicant.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this applicant.
	*
	* @param groupId the group ID of this applicant
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicant.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this applicant.
	*
	* @param modifiedDate the modified date of this applicant
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicant.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_applicant.setNew(n);
	}

	/**
	* Sets the primary key of this applicant.
	*
	* @param primaryKey the primary key of this applicant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicant.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicant.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this applicant.
	*
	* @param userId the user ID of this applicant
	*/
	@Override
	public void setUserId(long userId) {
		_applicant.setUserId(userId);
	}

	/**
	* Sets the user name of this applicant.
	*
	* @param userName the user name of this applicant
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicant.setUserName(userName);
	}

	/**
	* Sets the user uuid of this applicant.
	*
	* @param userUuid the user uuid of this applicant
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicant.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this applicant.
	*
	* @param uuid the uuid of this applicant
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_applicant.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Applicant> toCacheModel() {
		return _applicant.toCacheModel();
	}

	@Override
	public Applicant toEscapedModel() {
		return new ApplicantWrapper(_applicant.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _applicant.toString();
	}

	@Override
	public Applicant toUnescapedModel() {
		return new ApplicantWrapper(_applicant.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicant.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicantWrapper)) {
			return false;
		}

		ApplicantWrapper applicantWrapper = (ApplicantWrapper)obj;

		if (Objects.equals(_applicant, applicantWrapper._applicant)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _applicant.getStagedModelType();
	}

	@Override
	public Applicant getWrappedModel() {
		return _applicant;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicant.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicant.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicant.resetOriginalValues();
	}

	private final Applicant _applicant;
}