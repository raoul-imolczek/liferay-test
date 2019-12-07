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

package com.imolczek.lab.liferay.applicantservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.imolczek.lab.liferay.applicantservice.model.Applicant;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Applicant in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Applicant
 * @generated
 */
@ProviderType
public class ApplicantCacheModel implements CacheModel<Applicant>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicantCacheModel)) {
			return false;
		}

		ApplicantCacheModel applicantCacheModel = (ApplicantCacheModel)obj;

		if (applicantId == applicantCacheModel.applicantId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicantId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", applicantId=");
		sb.append(applicantId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", applicantSurname=");
		sb.append(applicantSurname);
		sb.append(", applicantEmail=");
		sb.append(applicantEmail);
		sb.append(", applicantBirthDate=");
		sb.append(applicantBirthDate);
		sb.append(", applicationSubmissionDate=");
		sb.append(applicationSubmissionDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Applicant toEntityModel() {
		ApplicantImpl applicantImpl = new ApplicantImpl();

		if (uuid == null) {
			applicantImpl.setUuid("");
		}
		else {
			applicantImpl.setUuid(uuid);
		}

		applicantImpl.setApplicantId(applicantId);
		applicantImpl.setGroupId(groupId);
		applicantImpl.setCompanyId(companyId);
		applicantImpl.setUserId(userId);

		if (userName == null) {
			applicantImpl.setUserName("");
		}
		else {
			applicantImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicantImpl.setCreateDate(null);
		}
		else {
			applicantImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicantImpl.setModifiedDate(null);
		}
		else {
			applicantImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (applicantName == null) {
			applicantImpl.setApplicantName("");
		}
		else {
			applicantImpl.setApplicantName(applicantName);
		}

		if (applicantSurname == null) {
			applicantImpl.setApplicantSurname("");
		}
		else {
			applicantImpl.setApplicantSurname(applicantSurname);
		}

		if (applicantEmail == null) {
			applicantImpl.setApplicantEmail("");
		}
		else {
			applicantImpl.setApplicantEmail(applicantEmail);
		}

		if (applicantBirthDate == Long.MIN_VALUE) {
			applicantImpl.setApplicantBirthDate(null);
		}
		else {
			applicantImpl.setApplicantBirthDate(new Date(applicantBirthDate));
		}

		if (applicationSubmissionDate == Long.MIN_VALUE) {
			applicantImpl.setApplicationSubmissionDate(null);
		}
		else {
			applicantImpl.setApplicationSubmissionDate(new Date(
					applicationSubmissionDate));
		}

		applicantImpl.resetOriginalValues();

		return applicantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		applicantId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		applicantName = objectInput.readUTF();
		applicantSurname = objectInput.readUTF();
		applicantEmail = objectInput.readUTF();
		applicantBirthDate = objectInput.readLong();
		applicationSubmissionDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(applicantId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (applicantSurname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantSurname);
		}

		if (applicantEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantEmail);
		}

		objectOutput.writeLong(applicantBirthDate);
		objectOutput.writeLong(applicationSubmissionDate);
	}

	public String uuid;
	public long applicantId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String applicantName;
	public String applicantSurname;
	public String applicantEmail;
	public long applicantBirthDate;
	public long applicationSubmissionDate;
}