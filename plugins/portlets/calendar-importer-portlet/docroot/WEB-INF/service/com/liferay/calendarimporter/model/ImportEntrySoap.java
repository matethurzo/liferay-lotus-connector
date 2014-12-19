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

package com.liferay.calendarimporter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.calendarimporter.service.http.ImportEntryServiceSoap}.
 *
 * @author Andrea Di Giorgi
 * @see com.liferay.calendarimporter.service.http.ImportEntryServiceSoap
 * @generated
 */
public class ImportEntrySoap implements Serializable {
	public static ImportEntrySoap toSoapModel(ImportEntry model) {
		ImportEntrySoap soapModel = new ImportEntrySoap();

		soapModel.setImportEntryId(model.getImportEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCalendarId(model.getCalendarId());
		soapModel.setType(model.getType());
		soapModel.setTypeSettings(model.getTypeSettings());
		soapModel.setImportDate(model.getImportDate());

		return soapModel;
	}

	public static ImportEntrySoap[] toSoapModels(ImportEntry[] models) {
		ImportEntrySoap[] soapModels = new ImportEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImportEntrySoap[][] toSoapModels(ImportEntry[][] models) {
		ImportEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImportEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImportEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImportEntrySoap[] toSoapModels(List<ImportEntry> models) {
		List<ImportEntrySoap> soapModels = new ArrayList<ImportEntrySoap>(models.size());

		for (ImportEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImportEntrySoap[soapModels.size()]);
	}

	public ImportEntrySoap() {
	}

	public long getPrimaryKey() {
		return _importEntryId;
	}

	public void setPrimaryKey(long pk) {
		setImportEntryId(pk);
	}

	public long getImportEntryId() {
		return _importEntryId;
	}

	public void setImportEntryId(long importEntryId) {
		_importEntryId = importEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getCalendarId() {
		return _calendarId;
	}

	public void setCalendarId(long calendarId) {
		_calendarId = calendarId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getTypeSettings() {
		return _typeSettings;
	}

	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	public Date getImportDate() {
		return _importDate;
	}

	public void setImportDate(Date importDate) {
		_importDate = importDate;
	}

	private long _importEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private long _calendarId;
	private String _type;
	private String _typeSettings;
	private Date _importDate;
}