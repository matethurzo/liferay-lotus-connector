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

package com.liferay.calendarimporter.source;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendarimporter.ImportSourceException;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Andrea Di Giorgi
 */
public abstract class BaseImportSource implements ImportSource {

	@Override
	public void executeImport(
			Calendar calendar, UnicodeProperties typeSettingsProperties)
		throws ImportSourceException {

		try {
			doExecuteImport(calendar, typeSettingsProperties);
		}
		catch (Exception e) {
			throw new ImportSourceException(e);
		}
	}

	protected abstract void doExecuteImport(
			Calendar calendar, UnicodeProperties typeSettingsProperties)
		throws Exception;

}