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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.repository.external.ExtRepositoryFolder;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * @author Ivan Zaera
 */
public class LotusNotesFolder implements ExtRepositoryFolder {

	public static final LotusNotesFolder createRootFolder() {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();


		jsonObject.put(
			LotusObjectFieldConstants.UNID, "7E93D7B2-8D12-4EAB-9F0E-66572B0F0E4F");
		jsonObject.put(
			LotusObjectFieldConstants.CREATED, new Date());
		jsonObject.put(
			LotusObjectFieldConstants.MODIFIED, new Date());

		return new LotusNotesFolder(true, jsonObject);
	}

	public LotusNotesFolder(Boolean rootFolder, JSONObject jsonObject) {
		_rootFolder = rootFolder;
		_jsonObject = jsonObject;
	}

	@Override
	public String getName() {
		return getExtRepositoryModelKey();
	}

	@Override
	public boolean isRoot() {
		return _rootFolder;
	}

	@Override
	public boolean containsPermission(
		ExtRepositoryPermission extRepositoryPermission) {

		return true;
	}

	@Override
	public String getDescription() {
		return getExtRepositoryModelKey();
	}

	@Override
	public String getExtension() {
		return StringPool.BLANK;
	}

	@Override
	public Date getModifiedDate() {
		return _toDate(
			_jsonObject.getString(LotusObjectFieldConstants.MODIFIED));
	}

	private Date _toDate(String isoDate) {
		try {
			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ssZ");

			return dateFormat.parse(isoDate);
		}
		catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	@Override
	public Date getCreateDate() {
		return getModifiedDate();
	}

	@Override
	public String getExtRepositoryModelKey() {
		return _jsonObject.getString(LotusObjectFieldConstants.UNID);
	}

	@Override
	public String getOwner() {
		return LotusObjectFieldConstants.DEFAULT_OWNER;
	}

	@Override
	public long getSize() {
		return 0;
	}

	private final boolean _rootFolder;
	private final JSONObject _jsonObject;
}