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
 * Provides a wrapper for {@link ImportEntryService}.
 *
 * @author Andrea Di Giorgi
 * @see ImportEntryService
 * @generated
 */
public class ImportEntryServiceWrapper implements ImportEntryService,
	ServiceWrapper<ImportEntryService> {
	public ImportEntryServiceWrapper(ImportEntryService importEntryService) {
		_importEntryService = importEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _importEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_importEntryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _importEntryService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.calendarimporter.model.ImportEntry addImportEntry(
		java.lang.String name, java.lang.String description,
		java.lang.String type,
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _importEntryService.addImportEntry(name, description, type,
			typeSettingsProperties, serviceContext);
	}

	@Override
	public void deleteImportEntry(long importEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_importEntryService.deleteImportEntry(importEntryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ImportEntryService getWrappedImportEntryService() {
		return _importEntryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedImportEntryService(
		ImportEntryService importEntryService) {
		_importEntryService = importEntryService;
	}

	@Override
	public ImportEntryService getWrappedService() {
		return _importEntryService;
	}

	@Override
	public void setWrappedService(ImportEntryService importEntryService) {
		_importEntryService = importEntryService;
	}

	private ImportEntryService _importEntryService;
}