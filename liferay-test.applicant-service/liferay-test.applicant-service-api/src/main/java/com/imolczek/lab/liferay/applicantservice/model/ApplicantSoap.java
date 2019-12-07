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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ApplicantSoap implements Serializable {
	public static ApplicantSoap toSoapModel(Applicant model) {
		ApplicantSoap soapModel = new ApplicantSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setApplicantId(model.getApplicantId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApplicantName(model.getApplicantName());
		soapModel.setApplicantSurname(model.getApplicantSurname());
		soapModel.setApplicantEmail(model.getApplicantEmail());
		soapModel.setApplicantBirthDate(model.getApplicantBirthDate());
		soapModel.setApplicationSubmissionDate(model.getApplicationSubmissionDate());

		return soapModel;
	}

	public static ApplicantSoap[] toSoapModels(Applicant[] models) {
		ApplicantSoap[] soapModels = new ApplicantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicantSoap[][] toSoapModels(Applicant[][] models) {
		ApplicantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicantSoap[] toSoapModels(List<Applicant> models) {
		List<ApplicantSoap> soapModels = new ArrayList<ApplicantSoap>(models.size());

		for (Applicant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicantSoap[soapModels.size()]);
	}

	public ApplicantSoap() {
	}

	public long getPrimaryKey() {
		return _applicantId;
	}

	public void setPrimaryKey(long pk) {
		setApplicantId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getApplicantId() {
		return _applicantId;
	}

	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getApplicantName() {
		return _applicantName;
	}

	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	public String getApplicantSurname() {
		return _applicantSurname;
	}

	public void setApplicantSurname(String applicantSurname) {
		_applicantSurname = applicantSurname;
	}

	public String getApplicantEmail() {
		return _applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		_applicantEmail = applicantEmail;
	}

	public Date getApplicantBirthDate() {
		return _applicantBirthDate;
	}

	public void setApplicantBirthDate(Date applicantBirthDate) {
		_applicantBirthDate = applicantBirthDate;
	}

	public Date getApplicationSubmissionDate() {
		return _applicationSubmissionDate;
	}

	public void setApplicationSubmissionDate(Date applicationSubmissionDate) {
		_applicationSubmissionDate = applicationSubmissionDate;
	}

	private String _uuid;
	private long _applicantId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicantName;
	private String _applicantSurname;
	private String _applicantEmail;
	private Date _applicantBirthDate;
	private Date _applicationSubmissionDate;
}