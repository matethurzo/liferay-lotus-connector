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

package com.liferay.calendarimporter.service.impl;

import com.liferay.calendarimporter.model.ImportEntry;
import com.liferay.calendarimporter.service.base.ImportEntryServiceBaseImpl;
import com.liferay.calendarimporter.service.permission.CalendarImporterPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;

/**
 * @author Andrea Di Giorgi
 */
public class ImportEntryServiceImpl extends ImportEntryServiceBaseImpl {

	@Override
	public ImportEntry addImportEntry(
			String name, String description, String type,
			UnicodeProperties typeSettingsProperties,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		CalendarImporterPermission.check(
			getPermissionChecker(), groupId, ActionKeys.MANAGE);

		return importEntryLocalService.addImportEntry(
			getUserId(), name, description, type, typeSettingsProperties,
			serviceContext);
	}

	@Override
	public void deleteImportEntry(long importEntryId)
		throws PortalException, SystemException {

		ImportEntry importEntry = importEntryPersistence.findByPrimaryKey(
			importEntryId);

		CalendarImporterPermission.check(
			getPermissionChecker(), importEntry.getGroupId(),
			ActionKeys.MANAGE);

		importEntryLocalService.deleteImportEntry(importEntry);
	}

}