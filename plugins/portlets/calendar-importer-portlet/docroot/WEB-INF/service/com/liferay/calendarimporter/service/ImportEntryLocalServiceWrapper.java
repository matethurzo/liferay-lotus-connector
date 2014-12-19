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

package com.liferay.calendarimporter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImportEntryLocalService}.
 *
 * @author Andrea Di Giorgi
 * @see ImportEntryLocalService
 * @generated
 */
public class ImportEntryLocalServiceWrapper implements ImportEntryLocalService,
	ServiceWrapper<ImportEntryLocalService> {
	public ImportEntryLocalServiceWrapper(
		ImportEntryLocalService importEntryLocalService) {
		_importEntryLocalService = importEntryLocalService;
	}

	/**
	* Adds the import entry to the database. Also notifies the appropriate model listeners.
	*
	* @param importEntry the import entry
	* @return the import entry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.calendarimporter.model.ImportEntry addImportEntry(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.addImportEntry(importEntry);
	}

	/**
	* Creates a new import entry with the primary key. Does not add the import entry to the database.
	*
	* @param importEntryId the primary key for the new import entry
	* @return the new import entry
	*/
	@Override
	public com.liferay.calendarimporter.model.ImportEntry createImportEntry(
		long importEntryId) {
		return _importEntryLocalService.createImportEntry(importEntryId);
	}

	/**
	* Deletes the import entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry that was removed
	* @throws PortalException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.calendarimporter.model.ImportEntry deleteImportEntry(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.deleteImportEntry(importEntryId);
	}

	/**
	* Deletes the import entry from the database. Also notifies the appropriate model listeners.
	*
	* @param importEntry the import entry
	* @return the import entry that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.calendarimporter.model.ImportEntry deleteImportEntry(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.deleteImportEntry(importEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importEntryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.calendarimporter.model.ImportEntry fetchImportEntry(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.fetchImportEntry(importEntryId);
	}

	/**
	* Returns the import entry with the primary key.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry
	* @throws PortalException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.calendarimporter.model.ImportEntry getImportEntry(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.getImportEntry(importEntryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> getImportEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.getImportEntries(start, end);
	}

	/**
	* Returns the number of import entries.
	*
	* @return the number of import entries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getImportEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.getImportEntriesCount();
	}

	/**
	* Updates the import entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importEntry the import entry
	* @return the import entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.calendarimporter.model.ImportEntry updateImportEntry(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.updateImportEntry(importEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _importEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_importEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _importEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.calendarimporter.model.ImportEntry addImportEntry(
		long userId, java.lang.String name, java.lang.String description,
		java.lang.String type,
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.addImportEntry(userId, name,
			description, type, typeSettingsProperties, serviceContext);
	}

	@Override
	public void deleteImportEntries(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_importEntryLocalService.deleteImportEntries(groupId);
	}

	@Override
	public java.util.List<com.liferay.calendarimporter.model.ImportEntry> getImportEntries(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.getImportEntries(groupId, start, end);
	}

	@Override
	public int getImportEntriesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntryLocalService.getImportEntriesCount(groupId);
	}

	@Override
	public void executeImport(long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_importEntryLocalService.executeImport(importEntryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ImportEntryLocalService getWrappedImportEntryLocalService() {
		return _importEntryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedImportEntryLocalService(
		ImportEntryLocalService importEntryLocalService) {
		_importEntryLocalService = importEntryLocalService;
	}

	@Override
	public ImportEntryLocalService getWrappedService() {
		return _importEntryLocalService;
	}

	@Override
	public void setWrappedService(
		ImportEntryLocalService importEntryLocalService) {
		_importEntryLocalService = importEntryLocalService;
	}

	private ImportEntryLocalService _importEntryLocalService;
}