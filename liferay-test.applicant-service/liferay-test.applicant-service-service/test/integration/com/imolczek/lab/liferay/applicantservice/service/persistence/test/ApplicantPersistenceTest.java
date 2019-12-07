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

package com.imolczek.lab.liferay.applicantservice.service.persistence.test;

import com.imolczek.lab.liferay.applicantservice.exception.NoSuchApplicantException;
import com.imolczek.lab.liferay.applicantservice.model.Applicant;
import com.imolczek.lab.liferay.applicantservice.service.ApplicantLocalServiceUtil;
import com.imolczek.lab.liferay.applicantservice.service.persistence.ApplicantPersistence;
import com.imolczek.lab.liferay.applicantservice.service.persistence.ApplicantUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ApplicantPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.imolczek.lab.liferay.applicantservice.service"));

	@Before
	public void setUp() {
		_persistence = ApplicantUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Applicant> iterator = _applicants.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Applicant applicant = _persistence.create(pk);

		Assert.assertNotNull(applicant);

		Assert.assertEquals(applicant.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Applicant newApplicant = addApplicant();

		_persistence.remove(newApplicant);

		Applicant existingApplicant = _persistence.fetchByPrimaryKey(newApplicant.getPrimaryKey());

		Assert.assertNull(existingApplicant);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addApplicant();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Applicant newApplicant = _persistence.create(pk);

		newApplicant.setUuid(RandomTestUtil.randomString());

		newApplicant.setGroupId(RandomTestUtil.nextLong());

		newApplicant.setCompanyId(RandomTestUtil.nextLong());

		newApplicant.setUserId(RandomTestUtil.nextLong());

		newApplicant.setUserName(RandomTestUtil.randomString());

		newApplicant.setCreateDate(RandomTestUtil.nextDate());

		newApplicant.setModifiedDate(RandomTestUtil.nextDate());

		newApplicant.setApplicantName(RandomTestUtil.randomString());

		newApplicant.setApplicantSurname(RandomTestUtil.randomString());

		newApplicant.setApplicantEmail(RandomTestUtil.randomString());

		newApplicant.setApplicantBirthDate(RandomTestUtil.nextDate());

		newApplicant.setApplicationSubmissionDate(RandomTestUtil.nextDate());

		_applicants.add(_persistence.update(newApplicant));

		Applicant existingApplicant = _persistence.findByPrimaryKey(newApplicant.getPrimaryKey());

		Assert.assertEquals(existingApplicant.getUuid(), newApplicant.getUuid());
		Assert.assertEquals(existingApplicant.getApplicantId(),
			newApplicant.getApplicantId());
		Assert.assertEquals(existingApplicant.getGroupId(),
			newApplicant.getGroupId());
		Assert.assertEquals(existingApplicant.getCompanyId(),
			newApplicant.getCompanyId());
		Assert.assertEquals(existingApplicant.getUserId(),
			newApplicant.getUserId());
		Assert.assertEquals(existingApplicant.getUserName(),
			newApplicant.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingApplicant.getCreateDate()),
			Time.getShortTimestamp(newApplicant.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingApplicant.getModifiedDate()),
			Time.getShortTimestamp(newApplicant.getModifiedDate()));
		Assert.assertEquals(existingApplicant.getApplicantName(),
			newApplicant.getApplicantName());
		Assert.assertEquals(existingApplicant.getApplicantSurname(),
			newApplicant.getApplicantSurname());
		Assert.assertEquals(existingApplicant.getApplicantEmail(),
			newApplicant.getApplicantEmail());
		Assert.assertEquals(Time.getShortTimestamp(
				existingApplicant.getApplicantBirthDate()),
			Time.getShortTimestamp(newApplicant.getApplicantBirthDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingApplicant.getApplicationSubmissionDate()),
			Time.getShortTimestamp(newApplicant.getApplicationSubmissionDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByApplicantEmail() throws Exception {
		_persistence.countByApplicantEmail("");

		_persistence.countByApplicantEmail("null");

		_persistence.countByApplicantEmail((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Applicant newApplicant = addApplicant();

		Applicant existingApplicant = _persistence.findByPrimaryKey(newApplicant.getPrimaryKey());

		Assert.assertEquals(existingApplicant, newApplicant);
	}

	@Test(expected = NoSuchApplicantException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Applicant> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("APPLICANT_Applicant",
			"uuid", true, "applicantId", true, "groupId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "applicantName", true, "applicantSurname",
			true, "applicantEmail", true, "applicantBirthDate", true,
			"applicationSubmissionDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Applicant newApplicant = addApplicant();

		Applicant existingApplicant = _persistence.fetchByPrimaryKey(newApplicant.getPrimaryKey());

		Assert.assertEquals(existingApplicant, newApplicant);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Applicant missingApplicant = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingApplicant);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Applicant newApplicant1 = addApplicant();
		Applicant newApplicant2 = addApplicant();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newApplicant1.getPrimaryKey());
		primaryKeys.add(newApplicant2.getPrimaryKey());

		Map<Serializable, Applicant> applicants = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, applicants.size());
		Assert.assertEquals(newApplicant1,
			applicants.get(newApplicant1.getPrimaryKey()));
		Assert.assertEquals(newApplicant2,
			applicants.get(newApplicant2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Applicant> applicants = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(applicants.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Applicant newApplicant = addApplicant();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newApplicant.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Applicant> applicants = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, applicants.size());
		Assert.assertEquals(newApplicant,
			applicants.get(newApplicant.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Applicant> applicants = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(applicants.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Applicant newApplicant = addApplicant();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newApplicant.getPrimaryKey());

		Map<Serializable, Applicant> applicants = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, applicants.size());
		Assert.assertEquals(newApplicant,
			applicants.get(newApplicant.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = ApplicantLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Applicant>() {
				@Override
				public void performAction(Applicant applicant) {
					Assert.assertNotNull(applicant);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Applicant newApplicant = addApplicant();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Applicant.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("applicantId",
				newApplicant.getApplicantId()));

		List<Applicant> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Applicant existingApplicant = result.get(0);

		Assert.assertEquals(existingApplicant, newApplicant);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Applicant.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("applicantId",
				RandomTestUtil.nextLong()));

		List<Applicant> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Applicant newApplicant = addApplicant();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Applicant.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("applicantId"));

		Object newApplicantId = newApplicant.getApplicantId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("applicantId",
				new Object[] { newApplicantId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingApplicantId = result.get(0);

		Assert.assertEquals(existingApplicantId, newApplicantId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Applicant.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("applicantId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("applicantId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Applicant newApplicant = addApplicant();

		_persistence.clearCache();

		Applicant existingApplicant = _persistence.findByPrimaryKey(newApplicant.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingApplicant.getUuid(),
				ReflectionTestUtil.invoke(existingApplicant, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingApplicant.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingApplicant,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Applicant addApplicant() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Applicant applicant = _persistence.create(pk);

		applicant.setUuid(RandomTestUtil.randomString());

		applicant.setGroupId(RandomTestUtil.nextLong());

		applicant.setCompanyId(RandomTestUtil.nextLong());

		applicant.setUserId(RandomTestUtil.nextLong());

		applicant.setUserName(RandomTestUtil.randomString());

		applicant.setCreateDate(RandomTestUtil.nextDate());

		applicant.setModifiedDate(RandomTestUtil.nextDate());

		applicant.setApplicantName(RandomTestUtil.randomString());

		applicant.setApplicantSurname(RandomTestUtil.randomString());

		applicant.setApplicantEmail(RandomTestUtil.randomString());

		applicant.setApplicantBirthDate(RandomTestUtil.nextDate());

		applicant.setApplicationSubmissionDate(RandomTestUtil.nextDate());

		_applicants.add(_persistence.update(applicant));

		return applicant;
	}

	private List<Applicant> _applicants = new ArrayList<Applicant>();
	private ApplicantPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}