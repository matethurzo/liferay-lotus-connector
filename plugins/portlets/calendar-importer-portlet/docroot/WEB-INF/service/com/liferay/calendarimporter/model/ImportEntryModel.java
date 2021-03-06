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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ImportEntry service. Represents a row in the &quot;CI_ImportEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.calendarimporter.model.impl.ImportEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.calendarimporter.model.impl.ImportEntryImpl}.
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see ImportEntry
 * @see com.liferay.calendarimporter.model.impl.ImportEntryImpl
 * @see com.liferay.calendarimporter.model.impl.ImportEntryModelImpl
 * @generated
 */
public interface ImportEntryModel extends BaseModel<ImportEntry>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a import entry model instance should use the {@link ImportEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this import entry.
	 *
	 * @return the primary key of this import entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this import entry.
	 *
	 * @param primaryKey the primary key of this import entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the import entry ID of this import entry.
	 *
	 * @return the import entry ID of this import entry
	 */
	public long getImportEntryId();

	/**
	 * Sets the import entry ID of this import entry.
	 *
	 * @param importEntryId the import entry ID of this import entry
	 */
	public void setImportEntryId(long importEntryId);

	/**
	 * Returns the group ID of this import entry.
	 *
	 * @return the group ID of this import entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this import entry.
	 *
	 * @param groupId the group ID of this import entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this import entry.
	 *
	 * @return the company ID of this import entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this import entry.
	 *
	 * @param companyId the company ID of this import entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this import entry.
	 *
	 * @return the user ID of this import entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this import entry.
	 *
	 * @param userId the user ID of this import entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this import entry.
	 *
	 * @return the user uuid of this import entry
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this import entry.
	 *
	 * @param userUuid the user uuid of this import entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this import entry.
	 *
	 * @return the user name of this import entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this import entry.
	 *
	 * @param userName the user name of this import entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this import entry.
	 *
	 * @return the create date of this import entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this import entry.
	 *
	 * @param createDate the create date of this import entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this import entry.
	 *
	 * @return the modified date of this import entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this import entry.
	 *
	 * @param modifiedDate the modified date of this import entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this import entry.
	 *
	 * @return the name of this import entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this import entry.
	 *
	 * @param name the name of this import entry
	 */
	public void setName(String name);

	/**
	 * Returns the description of this import entry.
	 *
	 * @return the description of this import entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this import entry.
	 *
	 * @param description the description of this import entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the calendar ID of this import entry.
	 *
	 * @return the calendar ID of this import entry
	 */
	public long getCalendarId();

	/**
	 * Sets the calendar ID of this import entry.
	 *
	 * @param calendarId the calendar ID of this import entry
	 */
	public void setCalendarId(long calendarId);

	/**
	 * Returns the type of this import entry.
	 *
	 * @return the type of this import entry
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this import entry.
	 *
	 * @param type the type of this import entry
	 */
	public void setType(String type);

	/**
	 * Returns the type settings of this import entry.
	 *
	 * @return the type settings of this import entry
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this import entry.
	 *
	 * @param typeSettings the type settings of this import entry
	 */
	public void setTypeSettings(String typeSettings);

	/**
	 * Returns the import date of this import entry.
	 *
	 * @return the import date of this import entry
	 */
	public Date getImportDate();

	/**
	 * Sets the import date of this import entry.
	 *
	 * @param importDate the import date of this import entry
	 */
	public void setImportDate(Date importDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ImportEntry importEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ImportEntry> toCacheModel();

	@Override
	public ImportEntry toEscapedModel();

	@Override
	public ImportEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}