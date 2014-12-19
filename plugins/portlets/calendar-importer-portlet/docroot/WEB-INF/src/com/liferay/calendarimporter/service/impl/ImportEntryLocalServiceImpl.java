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

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.calendarimporter.ImportEntryNameException;
import com.liferay.calendarimporter.model.ImportEntry;
import com.liferay.calendarimporter.service.base.ImportEntryLocalServiceBaseImpl;
import com.liferay.calendarimporter.source.ImportSource;
import com.liferay.calendarimporter.source.ImportSourceFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Andrea Di Giorgi
 */
public class ImportEntryLocalServiceImpl
	extends ImportEntryLocalServiceBaseImpl {

	@Override
	public ImportEntry addImportEntry(
			long userId, String name, String description, String type,
			UnicodeProperties typeSettingsProperties,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();

		validate(name);

		Date now = new Date();

		long importEntryId = counterLocalService.increment();

		ImportEntry importEntry = importEntryPersistence.create(importEntryId);

		importEntry.setGroupId(groupId);
		importEntry.setCompanyId(user.getCompanyId());
		importEntry.setUserId(userId);
		importEntry.setCreateDate(serviceContext.getCreateDate(now));
		importEntry.setModifiedDate(serviceContext.getModifiedDate(now));
		importEntry.setName(name);
		importEntry.setDescription(description);
		importEntry.setType(type);
		importEntry.setTypeSettingsProperties(typeSettingsProperties);

		importEntryPersistence.update(importEntry);

		return importEntry;
	}

	@Override
	public void deleteImportEntries(long groupId)
		throws PortalException, SystemException {

		List<ImportEntry> importEntries = importEntryPersistence.findByGroupId(
			groupId);

		for (ImportEntry importEntry : importEntries) {
			importEntryLocalService.deleteImportEntry(importEntry);
		}
	}

	@Override
	public ImportEntry deleteImportEntry(ImportEntry importEntry)
		throws PortalException, SystemException {

		// Import entry

		importEntryPersistence.remove(importEntry);

		// Calendar

		if (importEntry.getCalendarId() > 0) {
			Calendar calendar = CalendarLocalServiceUtil.fetchCalendar(
				importEntry.getCalendarId());

			if (calendar != null) {
				CalendarLocalServiceUtil.deleteCalendar(calendar);
			}
		}

		return importEntry;
	}

	@Override
	public ImportEntry deleteImportEntry(long importEntryId)
		throws PortalException, SystemException {

		ImportEntry importEntry = importEntryPersistence.findByPrimaryKey(
			importEntryId);

		return deleteImportEntry(importEntry);
	}

	@Override
	public void executeImport(long importEntryId)
		throws PortalException, SystemException {

		ImportEntry importEntry = importEntryPersistence.findByPrimaryKey(
			importEntryId);

		ImportSource importSource = ImportSourceFactory.getImportSource(
			importEntry.getType());

		Calendar calendar = getImportCalendar(importEntry);

		if (calendar == null) {
			return;
		}

		importSource.executeImport(
			calendar, importEntry.getTypeSettingsProperties());
	}

	@Override
	public List<ImportEntry> getImportEntries(long groupId, int start, int end)
		throws SystemException {

		return importEntryPersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public int getImportEntriesCount(long groupId) throws SystemException {
		return importEntryPersistence.countByGroupId(groupId);
	}

	protected Calendar getImportCalendar(ImportEntry importEntry)
		throws PortalException, SystemException {

		Calendar calendar = CalendarLocalServiceUtil.fetchCalendar(
			importEntry.getCalendarId());

		if (calendar != null) {
			return calendar;
		}

		CalendarResource calendarResource = getImportCalendarResource(
			importEntry);

		if (calendarResource == null) {
			return null;
		}

		Locale locale = LocaleUtil.getDefault();

		ServiceContext serviceContext = new ServiceContext();

		calendar = CalendarLocalServiceUtil.addCalendar(
			calendarResource.getUserId(), calendarResource.getGroupId(),
			calendarResource.getCalendarResourceId(),
			Collections.singletonMap(locale, importEntry.getName()),
			Collections.singletonMap(locale, importEntry.getDescription()), 0,
			false, false, false, serviceContext);

		importEntry.setCalendarId(calendar.getCalendarId());

		importEntryPersistence.update(importEntry);

		return calendar;
	}

	protected CalendarResource getImportCalendarResource(
			ImportEntry importEntry)
		throws PortalException, SystemException {

		Group group = groupPersistence.findByPrimaryKey(
			importEntry.getGroupId());

		long classNameId;
		long classPK;

		if (group.isUser()) {
			classNameId = PortalUtil.getClassNameId(User.class);
			classPK = group.getClassPK();
		}
		else {
			classNameId = PortalUtil.getClassNameId(Group.class);
			classPK = group.getGroupId();
		}

		CalendarResource calendarResource =
			CalendarResourceLocalServiceUtil.fetchCalendarResource(
				classNameId, classPK);

		if (calendarResource == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to import, calendar resource not found");
			}

			return null;
		}

		return calendarResource;
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new ImportEntryNameException();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ImportEntryLocalServiceImpl.class);

}