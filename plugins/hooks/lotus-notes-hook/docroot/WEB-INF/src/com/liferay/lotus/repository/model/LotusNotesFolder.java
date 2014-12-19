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

import com.liferay.lotus.repository.placeholder.LotusFolder;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.repository.external.ExtRepositoryFolder;
import com.liferay.repository.external.ExtRepositoryObject;

import java.util.Date;

/**
 * @author Ivan Zaera
 */
public class LotusNotesFolder implements ExtRepositoryFolder {

	private final LotusFolder _lotusFolder;

	public LotusNotesFolder(LotusFolder lotusFolder) {
		_lotusFolder = lotusFolder;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean isRoot() {
		return false;
	}

	@Override
	public boolean containsPermission(ExtRepositoryPermission extRepositoryPermission) {
		return false;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getExtension() {
		return null;
	}

	@Override
	public Date getModifiedDate() {
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