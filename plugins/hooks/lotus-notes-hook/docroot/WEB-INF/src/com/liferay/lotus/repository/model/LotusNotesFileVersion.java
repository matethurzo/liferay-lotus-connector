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
import com.liferay.repository.external.ExtRepositoryFileVersion;

import java.util.Date;

/**
 * @author Ivan Zaera
 */
public class LotusNotesFileVersion implements ExtRepositoryFileVersion {

	private final LotusFile _lotusFile;

	public LotusNotesFileVersion(LotusFile lotusFile) {
		_lotusFile = lotusFile;
	}

	@Override
	public String getChangeLog() {
		return null;
	}

	@Override
	public String getMimeType() {
		return null;
	}

	@Override
	public String getVersion() {
		return null;
	}

	@Override
	public Date getCreateDate() {
		return null;
	}

	@Override
	public String getExtRepositoryModelKey() {
		return null;
	}

	@Override
	public String getOwner() {
		return null;
	}

	@Override
	public long getSize() {
		return 0;
	}
}