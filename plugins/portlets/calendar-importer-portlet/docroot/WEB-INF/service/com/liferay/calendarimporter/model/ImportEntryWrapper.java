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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ImportEntry}.
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see ImportEntry
 * @generated
 */
public class ImportEntryWrapper implements ImportEntry,
	ModelWrapper<ImportEntry> {
	public ImportEntryWrapper(ImportEntry importEntry) {
		_importEntry = importEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return ImportEntry.class;
	}

	@Override
	public String getModelClassName() {
		return ImportEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("importEntryId", getImportEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("calendarId", getCalendarId());
		attributes.put("type", getType());
		attributes.put("typeSettings", getTypeSettings());
		attributes.put("importDate", getImportDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long importEntryId = (Long)attributes.get("importEntryId");

		if (importEntryId != null) {
			setImportEntryId(importEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long calendarId = (Long)attributes.get("calendarId");

		if (calendarId != null) {
			setCalendarId(calendarId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}

		Date importDate = (Date)attributes.get("importDate");

		if (importDate != null) {
			setImportDate(importDate);
		}
	}

	/**
	* Returns the primary key of this import entry.
	*
	* @return the primary key of this import entry
	*/
	@Override
	public long getPrimaryKey() {
		return _importEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this import entry.
	*
	* @param primaryKey the primary key of this import entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_importEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the import entry ID of this import entry.
	*
	* @return the import entry ID of this import entry
	*/
	@Override
	public long getImportEntryId() {
		return _importEntry.getImportEntryId();
	}

	/**
	* Sets the import entry ID of this import entry.
	*
	* @param importEntryId the import entry ID of this import entry
	*/
	@Override
	public void setImportEntryId(long importEntryId) {
		_importEntry.setImportEntryId(importEntryId);
	}

	/**
	* Returns the group ID of this import entry.
	*
	* @return the group ID of this import entry
	*/
	@Override
	public long getGroupId() {
		return _importEntry.getGroupId();
	}

	/**
	* Sets the group ID of this import entry.
	*
	* @param groupId the group ID of this import entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_importEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this import entry.
	*
	* @return the company ID of this import entry
	*/
	@Override
	public long getCompanyId() {
		return _importEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this import entry.
	*
	* @param companyId the company ID of this import entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_importEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this import entry.
	*
	* @return the user ID of this import entry
	*/
	@Override
	public long getUserId() {
		return _importEntry.getUserId();
	}

	/**
	* Sets the user ID of this import entry.
	*
	* @param userId the user ID of this import entry
	*/
	@Override
	public void setUserId(long userId) {
		_importEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this import entry.
	*
	* @return the user uuid of this import entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _importEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this import entry.
	*
	* @param userUuid the user uuid of this import entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_importEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this import entry.
	*
	* @return the user name of this import entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _importEntry.getUserName();
	}

	/**
	* Sets the user name of this import entry.
	*
	* @param userName the user name of this import entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_importEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this import entry.
	*
	* @return the create date of this import entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _importEntry.getCreateDate();
	}

	/**
	* Sets the create date of this import entry.
	*
	* @param createDate the create date of this import entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_importEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this import entry.
	*
	* @return the modified date of this import entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _importEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this import entry.
	*
	* @param modifiedDate the modified date of this import entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_importEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this import entry.
	*
	* @return the name of this import entry
	*/
	@Override
	public java.lang.String getName() {
		return _importEntry.getName();
	}

	/**
	* Sets the name of this import entry.
	*
	* @param name the name of this import entry
	*/
	@Override
	public void setName(java.lang.String name) {
		_importEntry.setName(name);
	}

	/**
	* Returns the description of this import entry.
	*
	* @return the description of this import entry
	*/
	@Override
	public java.lang.String getDescription() {
		return _importEntry.getDescription();
	}

	/**
	* Sets the description of this import entry.
	*
	* @param description the description of this import entry
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_importEntry.setDescription(description);
	}

	/**
	* Returns the calendar ID of this import entry.
	*
	* @return the calendar ID of this import entry
	*/
	@Override
	public long getCalendarId() {
		return _importEntry.getCalendarId();
	}

	/**
	* Sets the calendar ID of this import entry.
	*
	* @param calendarId the calendar ID of this import entry
	*/
	@Override
	public void setCalendarId(long calendarId) {
		_importEntry.setCalendarId(calendarId);
	}

	/**
	* Returns the type of this import entry.
	*
	* @return the type of this import entry
	*/
	@Override
	public java.lang.String getType() {
		return _importEntry.getType();
	}

	/**
	* Sets the type of this import entry.
	*
	* @param type the type of this import entry
	*/
	@Override
	public void setType(java.lang.String type) {
		_importEntry.setType(type);
	}

	/**
	* Returns the type settings of this import entry.
	*
	* @return the type settings of this import entry
	*/
	@Override
	public java.lang.String getTypeSettings() {
		return _importEntry.getTypeSettings();
	}

	/**
	* Sets the type settings of this import entry.
	*
	* @param typeSettings the type settings of this import entry
	*/
	@Override
	public void setTypeSettings(java.lang.String typeSettings) {
		_importEntry.setTypeSettings(typeSettings);
	}

	/**
	* Returns the import date of this import entry.
	*
	* @return the import date of this import entry
	*/
	@Override
	public java.util.Date getImportDate() {
		return _importEntry.getImportDate();
	}

	/**
	* Sets the import date of this import entry.
	*
	* @param importDate the import date of this import entry
	*/
	@Override
	public void setImportDate(java.util.Date importDate) {
		_importEntry.setImportDate(importDate);
	}

	@Override
	public boolean isNew() {
		return _importEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_importEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _importEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_importEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _importEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _importEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_importEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _importEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_importEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_importEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_importEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImportEntryWrapper((ImportEntry)_importEntry.clone());
	}

	@Override
	public int compareTo(
		com.liferay.calendarimporter.model.ImportEntry importEntry) {
		return _importEntry.compareTo(importEntry);
	}

	@Override
	public int hashCode() {
		return _importEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.calendarimporter.model.ImportEntry> toCacheModel() {
		return _importEntry.toCacheModel();
	}

	@Override
	public com.liferay.calendarimporter.model.ImportEntry toEscapedModel() {
		return new ImportEntryWrapper(_importEntry.toEscapedModel());
	}

	@Override
	public com.liferay.calendarimporter.model.ImportEntry toUnescapedModel() {
		return new ImportEntryWrapper(_importEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _importEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _importEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_importEntry.persist();
	}

	@Override
	public com.liferay.portal.kernel.util.UnicodeProperties getTypeSettingsProperties() {
		return _importEntry.getTypeSettingsProperties();
	}

	@Override
	public java.lang.String getTypeSettingsProperty(java.lang.String key) {
		return _importEntry.getTypeSettingsProperty(key);
	}

	@Override
	public java.lang.String getTypeSettingsProperty(java.lang.String key,
		java.lang.String defaultValue) {
		return _importEntry.getTypeSettingsProperty(key, defaultValue);
	}

	@Override
	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties) {
		_importEntry.setTypeSettingsProperties(typeSettingsProperties);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportEntryWrapper)) {
			return false;
		}

		ImportEntryWrapper importEntryWrapper = (ImportEntryWrapper)obj;

		if (Validator.equals(_importEntry, importEntryWrapper._importEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ImportEntry getWrappedImportEntry() {
		return _importEntry;
	}

	@Override
	public ImportEntry getWrappedModel() {
		return _importEntry;
	}

	@Override
	public void resetOriginalValues() {
		_importEntry.resetOriginalValues();
	}

	private ImportEntry _importEntry;
}