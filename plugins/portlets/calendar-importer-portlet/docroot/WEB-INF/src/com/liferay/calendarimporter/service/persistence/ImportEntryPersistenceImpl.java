/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.calendarimporter.service.persistence;

import com.liferay.calendarimporter.NoSuchImportEntryException;
import com.liferay.calendarimporter.model.ImportEntry;
import com.liferay.calendarimporter.model.impl.ImportEntryImpl;
import com.liferay.calendarimporter.model.impl.ImportEntryModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the import entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see ImportEntryPersistence
 * @see ImportEntryUtil
 * @generated
 */
public class ImportEntryPersistenceImpl extends BasePersistenceImpl<ImportEntry>
	implements ImportEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImportEntryUtil} to access the import entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImportEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryModelImpl.FINDER_CACHE_ENABLED, ImportEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryModelImpl.FINDER_CACHE_ENABLED, ImportEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryModelImpl.FINDER_CACHE_ENABLED, ImportEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryModelImpl.FINDER_CACHE_ENABLED, ImportEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ImportEntryModelImpl.GROUPID_COLUMN_BITMASK |
			ImportEntryModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the import entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImportEntry> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import entries
	 * @param end the upper bound of the range of import entries (not inclusive)
	 * @return the range of matching import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImportEntry> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import entries
	 * @param end the upper bound of the range of import entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImportEntry> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ImportEntry> list = (List<ImportEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ImportEntry importEntry : list) {
				if ((groupId != importEntry.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_IMPORTENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImportEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ImportEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImportEntry>(list);
				}
				else {
					list = (List<ImportEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first import entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import entry
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a matching import entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchImportEntryException, SystemException {
		ImportEntry importEntry = fetchByGroupId_First(groupId,
				orderByComparator);

		if (importEntry != null) {
			return importEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportEntryException(msg.toString());
	}

	/**
	 * Returns the first import entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import entry, or <code>null</code> if a matching import entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ImportEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import entry
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a matching import entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchImportEntryException, SystemException {
		ImportEntry importEntry = fetchByGroupId_Last(groupId, orderByComparator);

		if (importEntry != null) {
			return importEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportEntryException(msg.toString());
	}

	/**
	 * Returns the last import entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import entry, or <code>null</code> if a matching import entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ImportEntry> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import entries before and after the current import entry in the ordered set where groupId = &#63;.
	 *
	 * @param importEntryId the primary key of the current import entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import entry
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry[] findByGroupId_PrevAndNext(long importEntryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchImportEntryException, SystemException {
		ImportEntry importEntry = findByPrimaryKey(importEntryId);

		Session session = null;

		try {
			session = openSession();

			ImportEntry[] array = new ImportEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, importEntry, groupId,
					orderByComparator, true);

			array[1] = importEntry;

			array[2] = getByGroupId_PrevAndNext(session, importEntry, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportEntry getByGroupId_PrevAndNext(Session session,
		ImportEntry importEntry, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMPORTENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImportEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ImportEntry importEntry : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importEntry);
		}
	}

	/**
	 * Returns the number of import entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "importEntry.groupId = ?";

	public ImportEntryPersistenceImpl() {
		setModelClass(ImportEntry.class);
	}

	/**
	 * Caches the import entry in the entity cache if it is enabled.
	 *
	 * @param importEntry the import entry
	 */
	@Override
	public void cacheResult(ImportEntry importEntry) {
		EntityCacheUtil.putResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryImpl.class, importEntry.getPrimaryKey(), importEntry);

		importEntry.resetOriginalValues();
	}

	/**
	 * Caches the import entries in the entity cache if it is enabled.
	 *
	 * @param importEntries the import entries
	 */
	@Override
	public void cacheResult(List<ImportEntry> importEntries) {
		for (ImportEntry importEntry : importEntries) {
			if (EntityCacheUtil.getResult(
						ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
						ImportEntryImpl.class, importEntry.getPrimaryKey()) == null) {
				cacheResult(importEntry);
			}
			else {
				importEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all import entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImportEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImportEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the import entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImportEntry importEntry) {
		EntityCacheUtil.removeResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryImpl.class, importEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ImportEntry> importEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImportEntry importEntry : importEntries) {
			EntityCacheUtil.removeResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
				ImportEntryImpl.class, importEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new import entry with the primary key. Does not add the import entry to the database.
	 *
	 * @param importEntryId the primary key for the new import entry
	 * @return the new import entry
	 */
	@Override
	public ImportEntry create(long importEntryId) {
		ImportEntry importEntry = new ImportEntryImpl();

		importEntry.setNew(true);
		importEntry.setPrimaryKey(importEntryId);

		return importEntry;
	}

	/**
	 * Removes the import entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importEntryId the primary key of the import entry
	 * @return the import entry that was removed
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry remove(long importEntryId)
		throws NoSuchImportEntryException, SystemException {
		return remove((Serializable)importEntryId);
	}

	/**
	 * Removes the import entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import entry
	 * @return the import entry that was removed
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry remove(Serializable primaryKey)
		throws NoSuchImportEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ImportEntry importEntry = (ImportEntry)session.get(ImportEntryImpl.class,
					primaryKey);

			if (importEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(importEntry);
		}
		catch (NoSuchImportEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ImportEntry removeImpl(ImportEntry importEntry)
		throws SystemException {
		importEntry = toUnwrappedModel(importEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importEntry)) {
				importEntry = (ImportEntry)session.get(ImportEntryImpl.class,
						importEntry.getPrimaryKeyObj());
			}

			if (importEntry != null) {
				session.delete(importEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (importEntry != null) {
			clearCache(importEntry);
		}

		return importEntry;
	}

	@Override
	public ImportEntry updateImpl(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws SystemException {
		importEntry = toUnwrappedModel(importEntry);

		boolean isNew = importEntry.isNew();

		ImportEntryModelImpl importEntryModelImpl = (ImportEntryModelImpl)importEntry;

		Session session = null;

		try {
			session = openSession();

			if (importEntry.isNew()) {
				session.save(importEntry);

				importEntry.setNew(false);
			}
			else {
				session.merge(importEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ImportEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((importEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importEntryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { importEntryModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
			ImportEntryImpl.class, importEntry.getPrimaryKey(), importEntry);

		return importEntry;
	}

	protected ImportEntry toUnwrappedModel(ImportEntry importEntry) {
		if (importEntry instanceof ImportEntryImpl) {
			return importEntry;
		}

		ImportEntryImpl importEntryImpl = new ImportEntryImpl();

		importEntryImpl.setNew(importEntry.isNew());
		importEntryImpl.setPrimaryKey(importEntry.getPrimaryKey());

		importEntryImpl.setImportEntryId(importEntry.getImportEntryId());
		importEntryImpl.setGroupId(importEntry.getGroupId());
		importEntryImpl.setCompanyId(importEntry.getCompanyId());
		importEntryImpl.setUserId(importEntry.getUserId());
		importEntryImpl.setUserName(importEntry.getUserName());
		importEntryImpl.setCreateDate(importEntry.getCreateDate());
		importEntryImpl.setModifiedDate(importEntry.getModifiedDate());
		importEntryImpl.setName(importEntry.getName());
		importEntryImpl.setDescription(importEntry.getDescription());
		importEntryImpl.setCalendarId(importEntry.getCalendarId());
		importEntryImpl.setType(importEntry.getType());
		importEntryImpl.setTypeSettings(importEntry.getTypeSettings());
		importEntryImpl.setImportDate(importEntry.getImportDate());

		return importEntryImpl;
	}

	/**
	 * Returns the import entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the import entry
	 * @return the import entry
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImportEntryException, SystemException {
		ImportEntry importEntry = fetchByPrimaryKey(primaryKey);

		if (importEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return importEntry;
	}

	/**
	 * Returns the import entry with the primary key or throws a {@link com.liferay.calendarimporter.NoSuchImportEntryException} if it could not be found.
	 *
	 * @param importEntryId the primary key of the import entry
	 * @return the import entry
	 * @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry findByPrimaryKey(long importEntryId)
		throws NoSuchImportEntryException, SystemException {
		return findByPrimaryKey((Serializable)importEntryId);
	}

	/**
	 * Returns the import entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import entry
	 * @return the import entry, or <code>null</code> if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ImportEntry importEntry = (ImportEntry)EntityCacheUtil.getResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
				ImportEntryImpl.class, primaryKey);

		if (importEntry == _nullImportEntry) {
			return null;
		}

		if (importEntry == null) {
			Session session = null;

			try {
				session = openSession();

				importEntry = (ImportEntry)session.get(ImportEntryImpl.class,
						primaryKey);

				if (importEntry != null) {
					cacheResult(importEntry);
				}
				else {
					EntityCacheUtil.putResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
						ImportEntryImpl.class, primaryKey, _nullImportEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImportEntryModelImpl.ENTITY_CACHE_ENABLED,
					ImportEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return importEntry;
	}

	/**
	 * Returns the import entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importEntryId the primary key of the import entry
	 * @return the import entry, or <code>null</code> if a import entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImportEntry fetchByPrimaryKey(long importEntryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)importEntryId);
	}

	/**
	 * Returns all the import entries.
	 *
	 * @return the import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImportEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import entries
	 * @param end the upper bound of the range of import entries (not inclusive)
	 * @return the range of import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImportEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import entries
	 * @param end the upper bound of the range of import entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImportEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ImportEntry> list = (List<ImportEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMPORTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTENTRY;

				if (pagination) {
					sql = sql.concat(ImportEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImportEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImportEntry>(list);
				}
				else {
					list = (List<ImportEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the import entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ImportEntry importEntry : findAll()) {
			remove(importEntry);
		}
	}

	/**
	 * Returns the number of import entries.
	 *
	 * @return the number of import entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMPORTENTRY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the import entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.calendarimporter.model.ImportEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ImportEntry>> listenersList = new ArrayList<ModelListener<ImportEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ImportEntry>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ImportEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMPORTENTRY = "SELECT importEntry FROM ImportEntry importEntry";
	private static final String _SQL_SELECT_IMPORTENTRY_WHERE = "SELECT importEntry FROM ImportEntry importEntry WHERE ";
	private static final String _SQL_COUNT_IMPORTENTRY = "SELECT COUNT(importEntry) FROM ImportEntry importEntry";
	private static final String _SQL_COUNT_IMPORTENTRY_WHERE = "SELECT COUNT(importEntry) FROM ImportEntry importEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "importEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImportEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImportEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImportEntryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static ImportEntry _nullImportEntry = new ImportEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ImportEntry> toCacheModel() {
				return _nullImportEntryCacheModel;
			}
		};

	private static CacheModel<ImportEntry> _nullImportEntryCacheModel = new CacheModel<ImportEntry>() {
			@Override
			public ImportEntry toEntityModel() {
				return _nullImportEntry;
			}
		};
}