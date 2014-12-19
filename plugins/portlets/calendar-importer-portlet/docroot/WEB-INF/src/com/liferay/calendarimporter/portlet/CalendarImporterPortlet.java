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

package com.liferay.calendarimporter.portlet;

import com.liferay.calendarimporter.ImportEntryNameException;
import com.liferay.calendarimporter.ImportSourceException;
import com.liferay.calendarimporter.NoSuchImportEntryException;
import com.liferay.calendarimporter.model.ImportEntry;
import com.liferay.calendarimporter.service.ImportEntryLocalServiceUtil;
import com.liferay.calendarimporter.service.ImportEntryServiceUtil;
import com.liferay.calendarimporter.util.WebKeys;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Andrea Di Giorgi
 */
public class CalendarImporterPortlet extends MVCPortlet {

	public void deleteImportEntry(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long importEntryId = ParamUtil.getLong(actionRequest, "importEntryId");

		ImportEntryServiceUtil.deleteImportEntry(importEntryId);
	}

	public void executeImport(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long importEntryId = ParamUtil.getLong(actionRequest, "importEntryId");

		ImportEntryLocalServiceUtil.executeImport(importEntryId);
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		super.processAction(actionRequest, actionResponse);

		if (!copyRequestParameters && !SessionErrors.isEmpty(actionRequest)) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		try {
			long importEntryId = ParamUtil.getLong(
				renderRequest, "importEntryId");

			ImportEntry importEntry = null;

			if (importEntryId > 0) {
				importEntry = ImportEntryLocalServiceUtil.getImportEntry(
					importEntryId);
			}

			renderRequest.setAttribute(WebKeys.IMPORT_ENTRY, importEntry);
		}
		catch (Exception e) {
			if (e instanceof NoSuchImportEntryException) {
				SessionErrors.add(renderRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}

		super.render(renderRequest, renderResponse);
	}

	public void updateImportEntry(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		// TODO Handle import entry update

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String type = ParamUtil.getString(actionRequest, "type");
		UnicodeProperties typeSettingsProperties =
			PropertiesParamUtil.getProperties(actionRequest, "settings--");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ImportEntry.class.getName(), actionRequest);

		ImportEntryServiceUtil.addImportEntry(
			name, description, type, typeSettingsProperties, serviceContext);
	}

	@Override
	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof ImportEntryNameException ||
			cause instanceof ImportSourceException) {

			return true;
		}

		return false;
	}

}