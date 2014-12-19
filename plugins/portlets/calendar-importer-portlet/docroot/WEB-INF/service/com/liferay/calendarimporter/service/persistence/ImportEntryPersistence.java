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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the import entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see ImportEntryPersistenceImpl
 * @see ImportEntryUtil
 * @generated
 */
public interface ImportEntryPersistence extends BasePersistence<ImportEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportEntryUtil} to access the import entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the import entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first import entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import entry
	* @throws com.liferay.calendarimporter.NoSuchImportEntryException if a matching import entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first import entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import entry, or <code>null</code> if a matching import entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last import entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import entry
	* @throws com.liferay.calendarimporter.NoSuchImportEntryException if a matching import entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last import entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import entry, or <code>null</code> if a matching import entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.calendarimporter.model.ImportEntry[] findByGroupId_PrevAndNext(
		long importEntryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the import entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of import entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the import entry in the entity cache if it is enabled.
	*
	* @param importEntry the import entry
	*/
	public void cacheResult(
		com.liferay.calendarimporter.model.ImportEntry importEntry);

	/**
	* Caches the import entries in the entity cache if it is enabled.
	*
	* @param importEntries the import entries
	*/
	public void cacheResult(
		java.util.List<com.liferay.calendarimporter.model.ImportEntry> importEntries);

	/**
	* Creates a new import entry with the primary key. Does not add the import entry to the database.
	*
	* @param importEntryId the primary key for the new import entry
	* @return the new import entry
	*/
	public com.liferay.calendarimporter.model.ImportEntry create(
		long importEntryId);

	/**
	* Removes the import entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry that was removed
	* @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry remove(
		long importEntryId)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.calendarimporter.model.ImportEntry updateImpl(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the import entry with the primary key or throws a {@link com.liferay.calendarimporter.NoSuchImportEntryException} if it could not be found.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry
	* @throws com.liferay.calendarimporter.NoSuchImportEntryException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry findByPrimaryKey(
		long importEntryId)
		throws com.liferay.calendarimporter.NoSuchImportEntryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the import entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry, or <code>null</code> if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.calendarimporter.model.ImportEntry fetchByPrimaryKey(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the import entries.
	*
	* @return the import entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the import entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of import entries.
	*
	* @return the number of import entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}