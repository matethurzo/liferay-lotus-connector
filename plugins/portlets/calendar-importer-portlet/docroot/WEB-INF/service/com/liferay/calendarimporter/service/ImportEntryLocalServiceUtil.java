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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ImportEntry. This utility wraps
 * {@link com.liferay.calendarimporter.service.impl.ImportEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Andrea Di Giorgi
 * @see ImportEntryLocalService
 * @see com.liferay.calendarimporter.service.base.ImportEntryLocalServiceBaseImpl
 * @see com.liferay.calendarimporter.service.impl.ImportEntryLocalServiceImpl
 * @generated
 */
public class ImportEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.calendarimporter.service.impl.ImportEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the import entry to the database. Also notifies the appropriate model listeners.
	*
	* @param importEntry the import entry
	* @return the import entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry addImportEntry(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addImportEntry(importEntry);
	}

	/**
	* Creates a new import entry with the primary key. Does not add the import entry to the database.
	*
	* @param importEntryId the primary key for the new import entry
	* @return the new import entry
	*/
	public static com.liferay.calendarimporter.model.ImportEntry createImportEntry(
		long importEntryId) {
		return getService().createImportEntry(importEntryId);
	}

	/**
	* Deletes the import entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry that was removed
	* @throws PortalException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry deleteImportEntry(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteImportEntry(importEntryId);
	}

	/**
	* Deletes the import entry from the database. Also notifies the appropriate model listeners.
	*
	* @param importEntry the import entry
	* @return the import entry that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry deleteImportEntry(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteImportEntry(importEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.calendarimporter.model.ImportEntry fetchImportEntry(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchImportEntry(importEntryId);
	}

	/**
	* Returns the import entry with the primary key.
	*
	* @param importEntryId the primary key of the import entry
	* @return the import entry
	* @throws PortalException if a import entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry getImportEntry(
		long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getImportEntry(importEntryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> getImportEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImportEntries(start, end);
	}

	/**
	* Returns the number of import entries.
	*
	* @return the number of import entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getImportEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImportEntriesCount();
	}

	/**
	* Updates the import entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importEntry the import entry
	* @return the import entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.calendarimporter.model.ImportEntry updateImportEntry(
		com.liferay.calendarimporter.model.ImportEntry importEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateImportEntry(importEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.calendarimporter.model.ImportEntry addImportEntry(
		long userId, java.lang.String name, java.lang.String description,
		java.lang.String type,
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addImportEntry(userId, name, description, type,
			typeSettingsProperties, serviceContext);
	}

	public static void deleteImportEntries(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteImportEntries(groupId);
	}

	public static java.util.List<com.liferay.calendarimporter.model.ImportEntry> getImportEntries(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImportEntries(groupId, start, end);
	}

	public static int getImportEntriesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getImportEntriesCount(groupId);
	}

	public static void executeImport(long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().executeImport(importEntryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ImportEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ImportEntryLocalService.class.getName());

			if (invokableLocalService instanceof ImportEntryLocalService) {
				_service = (ImportEntryLocalService)invokableLocalService;
			}
			else {
				_service = new ImportEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ImportEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ImportEntryLocalService service) {
	}

	private static ImportEntryLocalService _service;
}