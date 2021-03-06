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
import com.imolczek.lab.liferay.applicantservice.model.ApplicantModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Applicant service. Represents a row in the &quot;APPLICANT_Applicant&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ApplicantModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ApplicantImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicantImpl
 * @see Applicant
 * @see ApplicantModel
 * @generated
 */
@ProviderType
public class ApplicantModelImpl extends BaseModelImpl<Applicant>
	implements ApplicantModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a applicant model instance should use the {@link Applicant} interface instead.
	 */
	public static final String TABLE_NAME = "APPLICANT_Applicant";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "applicantId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "applicantName", Types.VARCHAR },
			{ "applicantSurname", Types.VARCHAR },
			{ "applicantEmail", Types.VARCHAR },
			{ "applicantBirthDate", Types.TIMESTAMP },
			{ "applicationSubmissionDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("applicantName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantSurname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantBirthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("applicationSubmissionDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table APPLICANT_Applicant (uuid_ VARCHAR(75) null,applicantId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,applicantName VARCHAR(75) null,applicantSurname VARCHAR(75) null,applicantEmail VARCHAR(75) null,applicantBirthDate DATE null,applicationSubmissionDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table APPLICANT_Applicant";
	public static final String ORDER_BY_JPQL = " ORDER BY applicant.applicationSubmissionDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY APPLICANT_Applicant.applicationSubmissionDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.imolczek.lab.liferay.applicantservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.imolczek.lab.liferay.applicantservice.model.Applicant"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.imolczek.lab.liferay.applicantservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.imolczek.lab.liferay.applicantservice.model.Applicant"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.imolczek.lab.liferay.applicantservice.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.imolczek.lab.liferay.applicantservice.model.Applicant"),
			true);
	public static final long APPLICANTEMAIL_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long APPLICATIONSUBMISSIONDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.imolczek.lab.liferay.applicantservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.imolczek.lab.liferay.applicantservice.model.Applicant"));

	public ApplicantModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _applicantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getApplicantId() {
		return _applicantId;
	}

	@Override
	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getApplicantName() {
		if (_applicantName == null) {
			return "";
		}
		else {
			return _applicantName;
		}
	}

	@Override
	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	@Override
	public String getApplicantSurname() {
		if (_applicantSurname == null) {
			return "";
		}
		else {
			return _applicantSurname;
		}
	}

	@Override
	public void setApplicantSurname(String applicantSurname) {
		_applicantSurname = applicantSurname;
	}

	@Override
	public String getApplicantEmail() {
		if (_applicantEmail == null) {
			return "";
		}
		else {
			return _applicantEmail;
		}
	}

	@Override
	public void setApplicantEmail(String applicantEmail) {
		_columnBitmask |= APPLICANTEMAIL_COLUMN_BITMASK;

		if (_originalApplicantEmail == null) {
			_originalApplicantEmail = _applicantEmail;
		}

		_applicantEmail = applicantEmail;
	}

	public String getOriginalApplicantEmail() {
		return GetterUtil.getString(_originalApplicantEmail);
	}

	@Override
	public Date getApplicantBirthDate() {
		return _applicantBirthDate;
	}

	@Override
	public void setApplicantBirthDate(Date applicantBirthDate) {
		_applicantBirthDate = applicantBirthDate;
	}

	@Override
	public Date getApplicationSubmissionDate() {
		return _applicationSubmissionDate;
	}

	@Override
	public void setApplicationSubmissionDate(Date applicationSubmissionDate) {
		_columnBitmask = -1L;

		_applicationSubmissionDate = applicationSubmissionDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Applicant.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Applicant.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Applicant toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Applicant)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ApplicantImpl applicantImpl = new ApplicantImpl();

		applicantImpl.setUuid(getUuid());
		applicantImpl.setApplicantId(getApplicantId());
		applicantImpl.setGroupId(getGroupId());
		applicantImpl.setCompanyId(getCompanyId());
		applicantImpl.setUserId(getUserId());
		applicantImpl.setUserName(getUserName());
		applicantImpl.setCreateDate(getCreateDate());
		applicantImpl.setModifiedDate(getModifiedDate());
		applicantImpl.setApplicantName(getApplicantName());
		applicantImpl.setApplicantSurname(getApplicantSurname());
		applicantImpl.setApplicantEmail(getApplicantEmail());
		applicantImpl.setApplicantBirthDate(getApplicantBirthDate());
		applicantImpl.setApplicationSubmissionDate(getApplicationSubmissionDate());

		applicantImpl.resetOriginalValues();

		return applicantImpl;
	}

	@Override
	public int compareTo(Applicant applicant) {
		int value = 0;

		value = DateUtil.compareTo(getApplicationSubmissionDate(),
				applicant.getApplicationSubmissionDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Applicant)) {
			return false;
		}

		Applicant applicant = (Applicant)obj;

		long primaryKey = applicant.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ApplicantModelImpl applicantModelImpl = this;

		applicantModelImpl._originalUuid = applicantModelImpl._uuid;

		applicantModelImpl._originalGroupId = applicantModelImpl._groupId;

		applicantModelImpl._setOriginalGroupId = false;

		applicantModelImpl._originalCompanyId = applicantModelImpl._companyId;

		applicantModelImpl._setOriginalCompanyId = false;

		applicantModelImpl._setModifiedDate = false;

		applicantModelImpl._originalApplicantEmail = applicantModelImpl._applicantEmail;

		applicantModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Applicant> toCacheModel() {
		ApplicantCacheModel applicantCacheModel = new ApplicantCacheModel();

		applicantCacheModel.uuid = getUuid();

		String uuid = applicantCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			applicantCacheModel.uuid = null;
		}

		applicantCacheModel.applicantId = getApplicantId();

		applicantCacheModel.groupId = getGroupId();

		applicantCacheModel.companyId = getCompanyId();

		applicantCacheModel.userId = getUserId();

		applicantCacheModel.userName = getUserName();

		String userName = applicantCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			applicantCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			applicantCacheModel.createDate = createDate.getTime();
		}
		else {
			applicantCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			applicantCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			applicantCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		applicantCacheModel.applicantName = getApplicantName();

		String applicantName = applicantCacheModel.applicantName;

		if ((applicantName != null) && (applicantName.length() == 0)) {
			applicantCacheModel.applicantName = null;
		}

		applicantCacheModel.applicantSurname = getApplicantSurname();

		String applicantSurname = applicantCacheModel.applicantSurname;

		if ((applicantSurname != null) && (applicantSurname.length() == 0)) {
			applicantCacheModel.applicantSurname = null;
		}

		applicantCacheModel.applicantEmail = getApplicantEmail();

		String applicantEmail = applicantCacheModel.applicantEmail;

		if ((applicantEmail != null) && (applicantEmail.length() == 0)) {
			applicantCacheModel.applicantEmail = null;
		}

		Date applicantBirthDate = getApplicantBirthDate();

		if (applicantBirthDate != null) {
			applicantCacheModel.applicantBirthDate = applicantBirthDate.getTime();
		}
		else {
			applicantCacheModel.applicantBirthDate = Long.MIN_VALUE;
		}

		Date applicationSubmissionDate = getApplicationSubmissionDate();

		if (applicationSubmissionDate != null) {
			applicantCacheModel.applicationSubmissionDate = applicationSubmissionDate.getTime();
		}
		else {
			applicantCacheModel.applicationSubmissionDate = Long.MIN_VALUE;
		}

		return applicantCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", applicantId=");
		sb.append(getApplicantId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", applicantName=");
		sb.append(getApplicantName());
		sb.append(", applicantSurname=");
		sb.append(getApplicantSurname());
		sb.append(", applicantEmail=");
		sb.append(getApplicantEmail());
		sb.append(", applicantBirthDate=");
		sb.append(getApplicantBirthDate());
		sb.append(", applicationSubmissionDate=");
		sb.append(getApplicationSubmissionDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.imolczek.lab.liferay.applicantservice.model.Applicant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantId</column-name><column-value><![CDATA[");
		sb.append(getApplicantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantName</column-name><column-value><![CDATA[");
		sb.append(getApplicantName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantSurname</column-name><column-value><![CDATA[");
		sb.append(getApplicantSurname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantEmail</column-name><column-value><![CDATA[");
		sb.append(getApplicantEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantBirthDate</column-name><column-value><![CDATA[");
		sb.append(getApplicantBirthDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationSubmissionDate</column-name><column-value><![CDATA[");
		sb.append(getApplicationSubmissionDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Applicant.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Applicant.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _applicantId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _applicantName;
	private String _applicantSurname;
	private String _applicantEmail;
	private String _originalApplicantEmail;
	private Date _applicantBirthDate;
	private Date _applicationSubmissionDate;
	private long _columnBitmask;
	private Applicant _escapedModel;
}