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

import com.liferay.calendarimporter.model.ImportEntry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the import entry service. This utility wraps {@link ImportEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see ImportEntryPersistence
 * @see ImportEntryPersistenceImpl
 * @generated
 */
public class ImportEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ImportEntry importEntry) {
		getPersistence().clearCache(importEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ImportEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImportEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImportEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ImportEntry update(ImportEntry importEntry)
		throws SystemException {
		return getPersistence().update(importEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ImportEntry update(ImportEntry importEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(importEntry, serviceContext);
	}

	/**
	* Returns all the import entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
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
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
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
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
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
	public static com.liferay.calendarimporter.model.ImportEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first import entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import entry, or <code>null</code> if a matching import entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
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
	public static com.liferay.calendarimporter.model.ImportEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last import entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import entry, or <code>null</code> if a matching import entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
	public static com.liferay.calendarimporter.model.ImportEntry[] findByGroupId_PrevAndNext(
		long importEntryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(importEntryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the import entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of import entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the import entry in the entity cache if it is enabled.
	*
	* @param importEntry the import entry
	*/
	public static void cacheResult(
		com.liferay.calendarimporter.model.ImportEntry importEntry) {
		getPersistence().cacheResult(importEntry);
	}

	/**
	* Caches the import entries in the entity cache if it is enabled.
	*
	* @param importEntries the import entries
	*/
	public static void cacheResult(
		java.util.List<com.liferay.calendarimporter.model.ImportEntry> importEntries) {
		getPersistence().cacheResult(importEntries);
	}

	/**
	* Creates a new import entry with the primary key. Does not add the import entry to the database.
	*
	* @param importEntryId the primary key for the new import entry
	* @return the new import entry
	*/
	public static com.liferay.calendarimporter.model.ImportEntry create(
		long importEntryId) {
		return getPersistence().create(importEntryId);
	}

	/**
	* Removes the import entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry that was removed
	* @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry remove(
		long importEntryId)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(importEntryId);
	}

	public static com.liferay.calendarimporter.model.ImportEntry updateImpl(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(importEntry);
	}

	/**
	* Returns the import entry with the primary key or throws a {@link com.liferay.calendarimporter.NoSuchImportEntryException} if it could not be found.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry
	* @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry findByPrimaryKey(
		long importEntryId)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(importEntryId);
	}

	/**
	* Returns the import entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry, or <code>null</code> if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry fetchByPrimaryKey(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(importEntryId);
	}

	/**
	* Returns all the import entries.
	*
	* @return the import entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the import entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of import entries.
	*
	* @return the number of import entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ImportEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ImportEntryPersistence)PortletBeanLocatorUtil.locate(com.liferay.calendarimporter.service.ClpSerializer.getServletContextName(),
					ImportEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ImportEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ImportEntryPersistence persistence) {
	}

	private static ImportEntryPersistence _persistence;
}