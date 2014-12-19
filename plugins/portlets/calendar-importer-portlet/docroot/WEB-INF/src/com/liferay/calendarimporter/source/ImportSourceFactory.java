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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrea Di Giorgi
 */
public class ImportSourceFactory {

	public static ImportSource getImportSource(String type)
		throws PortalException {

		ImportSource importSource = _importSources.get(type);

		if (importSource == null) {
			throw new PortalException("Invalid type " + type);
		}

		return importSource;
	}

	public static List<ImportSource> getImportSources() {
		return ListUtil.fromMapValues(_importSources);
	}

	public static List<String> getTypes() {
		return ListUtil.fromMapKeys(_importSources);
	}

	public void setImportSources(List<ImportSource> importSources) {
		_importSources = new HashMap<String, ImportSource>();

		for (ImportSource importSource : importSources) {
			_importSources.put(importSource.getType(), importSource);
		}
	}

	private static Map<String, ImportSource> _importSources;

}