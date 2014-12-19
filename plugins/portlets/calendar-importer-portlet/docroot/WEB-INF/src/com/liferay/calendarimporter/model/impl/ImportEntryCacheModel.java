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

package com.liferay.calendarimporter.model.impl;

import com.liferay.calendarimporter.model.ImportEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ImportEntry in entity cache.
 *
 * @author Andrea Di Giorgi
 * @see ImportEntry
 * @generated
 */
public class ImportEntryCacheModel implements CacheModel<ImportEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{importEntryId=");
		sb.append(importEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", calendarId=");
		sb.append(calendarId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append(", importDate=");
		sb.append(importDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportEntry toEntityModel() {
		ImportEntryImpl importEntryImpl = new ImportEntryImpl();

		importEntryImpl.setImportEntryId(importEntryId);
		importEntryImpl.setGroupId(groupId);
		importEntryImpl.setCompanyId(companyId);
		importEntryImpl.setUserId(userId);

		if (userName == null) {
			importEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			importEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importEntryImpl.setCreateDate(null);
		}
		else {
			importEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importEntryImpl.setModifiedDate(null);
		}
		else {
			importEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			importEntryImpl.setName(StringPool.BLANK);
		}
		else {
			importEntryImpl.setName(name);
		}

		if (description == null) {
			importEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			importEntryImpl.setDescription(description);
		}

		importEntryImpl.setCalendarId(calendarId);

		if (type == null) {
			importEntryImpl.setType(StringPool.BLANK);
		}
		else {
			importEntryImpl.setType(type);
		}

		if (typeSettings == null) {
			importEntryImpl.setTypeSettings(StringPool.BLANK);
		}
		else {
			importEntryImpl.setTypeSettings(typeSettings);
		}

		if (importDate == Long.MIN_VALUE) {
			importEntryImpl.setImportDate(null);
		}
		else {
			importEntryImpl.setImportDate(new Date(importDate));
		}

		importEntryImpl.resetOriginalValues();

		return importEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		importEntryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		calendarId = objectInput.readLong();
		type = objectInput.readUTF();
		typeSettings = objectInput.readUTF();
		importDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(importEntryId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(calendarId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}

		objectOutput.writeLong(importDate);
	}

	public long importEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public long calendarId;
	public String type;
	public String typeSettings;
	public long importDate;
}