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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Applicant service. Represents a row in the &quot;APPLICANT_Applicant&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Applicant
 * @see com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantImpl
 * @see com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl
 * @generated
 */
@ProviderType
public interface ApplicantModel extends BaseModel<Applicant>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a applicant model instance should use the {@link Applicant} interface instead.
	 */

	/**
	 * Returns the primary key of this applicant.
	 *
	 * @return the primary key of this applicant
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this applicant.
	 *
	 * @param primaryKey the primary key of this applicant
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this applicant.
	 *
	 * @return the uuid of this applicant
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this applicant.
	 *
	 * @param uuid the uuid of this applicant
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the applicant ID of this applicant.
	 *
	 * @return the applicant ID of this applicant
	 */
	public long getApplicantId();

	/**
	 * Sets the applicant ID of this applicant.
	 *
	 * @param applicantId the applicant ID of this applicant
	 */
	public void setApplicantId(long applicantId);

	/**
	 * Returns the group ID of this applicant.
	 *
	 * @return the group ID of this applicant
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this applicant.
	 *
	 * @param groupId the group ID of this applicant
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this applicant.
	 *
	 * @return the company ID of this applicant
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this applicant.
	 *
	 * @param companyId the company ID of this applicant
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this applicant.
	 *
	 * @return the user ID of this applicant
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this applicant.
	 *
	 * @param userId the user ID of this applicant
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this applicant.
	 *
	 * @return the user uuid of this applicant
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this applicant.
	 *
	 * @param userUuid the user uuid of this applicant
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this applicant.
	 *
	 * @return the user name of this applicant
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this applicant.
	 *
	 * @param userName the user name of this applicant
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this applicant.
	 *
	 * @return the create date of this applicant
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this applicant.
	 *
	 * @param createDate the create date of this applicant
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this applicant.
	 *
	 * @return the modified date of this applicant
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this applicant.
	 *
	 * @param modifiedDate the modified date of this applicant
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the applicant name of this applicant.
	 *
	 * @return the applicant name of this applicant
	 */
	@AutoEscape
	public String getApplicantName();

	/**
	 * Sets the applicant name of this applicant.
	 *
	 * @param applicantName the applicant name of this applicant
	 */
	public void setApplicantName(String applicantName);

	/**
	 * Returns the applicant surname of this applicant.
	 *
	 * @return the applicant surname of this applicant
	 */
	@AutoEscape
	public String getApplicantSurname();

	/**
	 * Sets the applicant surname of this applicant.
	 *
	 * @param applicantSurname the applicant surname of this applicant
	 */
	public void setApplicantSurname(String applicantSurname);

	/**
	 * Returns the applicant email of this applicant.
	 *
	 * @return the applicant email of this applicant
	 */
	@AutoEscape
	public String getApplicantEmail();

	/**
	 * Sets the applicant email of this applicant.
	 *
	 * @param applicantEmail the applicant email of this applicant
	 */
	public void setApplicantEmail(String applicantEmail);

	/**
	 * Returns the applicant birth date of this applicant.
	 *
	 * @return the applicant birth date of this applicant
	 */
	public Date getApplicantBirthDate();

	/**
	 * Sets the applicant birth date of this applicant.
	 *
	 * @param applicantBirthDate the applicant birth date of this applicant
	 */
	public void setApplicantBirthDate(Date applicantBirthDate);

	/**
	 * Returns the application submission date of this applicant.
	 *
	 * @return the application submission date of this applicant
	 */
	public Date getApplicationSubmissionDate();

	/**
	 * Sets the application submission date of this applicant.
	 *
	 * @param applicationSubmissionDate the application submission date of this applicant
	 */
	public void setApplicationSubmissionDate(Date applicationSubmissionDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Applicant applicant);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Applicant> toCacheModel();

	@Override
	public Applicant toEscapedModel();

	@Override
	public Applicant toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}