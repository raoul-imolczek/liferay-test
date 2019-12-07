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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Applicant service. Represents a row in the &quot;APPLICANT_Applicant&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ApplicantModel
 * @see com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantImpl
 * @see com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantModelImpl
 * @generated
 */
@ImplementationClassName("com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantImpl")
@ProviderType
public interface Applicant extends ApplicantModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.imolczek.lab.liferay.applicantservice.model.impl.ApplicantImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Applicant, Long> APPLICANT_ID_ACCESSOR = new Accessor<Applicant, Long>() {
			@Override
			public Long get(Applicant applicant) {
				return applicant.getApplicantId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Applicant> getTypeClass() {
				return Applicant.class;
			}
		};
}