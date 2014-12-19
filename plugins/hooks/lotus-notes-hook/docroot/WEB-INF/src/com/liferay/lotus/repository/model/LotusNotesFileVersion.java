/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.lotus.repository.model;

import com.liferay.lotus.repository.placeholder.LotusFile;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.model.DLFileEntryConstants;
import com.liferay.repository.external.ExtRepositoryFileVersion;

import java.util.Date;

/**
 * @author Ivan Zaera
 */
public class LotusNotesFileVersion implements ExtRepositoryFileVersion {

	public LotusNotesFileVersion(LotusNotesFileEntry fileEntry) {
		_fileEntry = fileEntry;
	}

	@Override
	public String getChangeLog() {
		return StringPool.BLANK;
	}

	@Override
	public String getMimeType() {
		return ContentTypes.APPLICATION_JSON;
	}

	@Override
	public String getVersion() {
		return DLFileEntryConstants.VERSION_DEFAULT;
	}

	@Override
	public Date getCreateDate() {
		return _fileEntry.getCreateDate();
	}

	@Override
	public String getExtRepositoryModelKey() {
		return _fileEntry.getExtRepositoryModelKey() + "." + getVersion();
	}

	@Override
	public String getOwner() {
		return _fileEntry.getOwner();
	}

	@Override
	public long getSize() {
		return _fileEntry.getSize();
	}

	private final LotusNotesFileEntry _fileEntry;
}