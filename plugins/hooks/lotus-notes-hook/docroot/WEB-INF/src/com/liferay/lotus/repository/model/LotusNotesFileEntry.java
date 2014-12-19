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

import com.liferay.lotus.repository.util.LotusObjectFieldConstants;
import com.liferay.lotus.repository.util.LotusUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.repository.external.ExtRepositoryFileEntry;

import java.util.Date;

/**
 * @author Ivan Zaera
 */
public class LotusNotesFileEntry implements ExtRepositoryFileEntry {

	public LotusNotesFileEntry(JSONObject jsonObject) {
		_jsonObject = jsonObject;
	}

	@Override
	public boolean containsPermission(
		ExtRepositoryPermission extRepositoryPermission) {

		return true;
	}

	@Override
	public String getCheckedOutBy() {
		return null;
	}

	@Override
	public Date getCreateDate() {
		return getModifiedDate();
	}

	@Override
	public String getDescription() {
		return getTitle();
	}

	@Override
	public String getExtension() {
		return StringPool.BLANK;
	}

	@Override
	public String getExtRepositoryModelKey() {
		return _jsonObject.getString(LotusObjectFieldConstants.UNID);
	}

	@Override
	public String getMimeType() {
		return ContentTypes.APPLICATION_JSON;
	}

	@Override
	public Date getModifiedDate() {
		return LotusUtil.toDate(
			_jsonObject.getString(LotusObjectFieldConstants.MODIFIED));
	}

	@Override
	public String getOwner() {
		return LotusObjectFieldConstants.DEFAULT_OWNER;
	}

	@Override
	public long getSize() {
		return 0;
	}

	@Override
	public String getTitle() {
		return getExtRepositoryModelKey();
	}

	private final JSONObject _jsonObject;

}