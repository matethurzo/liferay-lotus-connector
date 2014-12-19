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

package com.liferay.lotus.repository;

import com.liferay.lotus.repository.model.LotusNotesFolder;
import com.liferay.lotus.repository.placeholder.LotusConnection;
import com.liferay.lotus.repository.placeholder.LotusException;
import com.liferay.repository.external.CredentialsProvider;
import com.liferay.repository.external.ExtRepository;
import com.liferay.repository.external.ExtRepositoryAdapter;
import com.liferay.repository.external.ExtRepositoryFileEntry;
import com.liferay.repository.external.ExtRepositoryFileVersion;
import com.liferay.repository.external.ExtRepositoryFileVersionDescriptor;
import com.liferay.repository.external.ExtRepositoryFolder;
import com.liferay.repository.external.ExtRepositoryObject;
import com.liferay.repository.external.ExtRepositoryObjectType;
import com.liferay.repository.external.ExtRepositorySearchResult;
import com.liferay.repository.external.search.ExtRepositoryQueryMapper;
import org.omg.CORBA.SystemException;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author
 */
public class LotusNotesRepository
	extends ExtRepositoryAdapter implements ExtRepository {

	public LotusNotesRepository() {
		super(null);
	}

	@Override
	public ExtRepositoryFileEntry addExtRepositoryFileEntry(
			String extRepositoryParentFolderKey, String mimeType, String title,
			String description, String changeLog, InputStream inputStream)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	@Override
	public ExtRepositoryFolder addExtRepositoryFolder(
			String extRepositoryParentFolderKey, String name,
			String description)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	public LotusConnection buildConnection() throws RepositoryException {

		// connect to lotus notes with stored parameters (from initRepository)
		// and user:password from credentialsProvider
		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public ExtRepositoryFileVersion cancelCheckOut(
			String extRepositoryFileEntryKey)
		throws SystemException {

		// may return null and the portal takes care of returning the correct version
		return null;
	}

	@Override
	public void checkInExtRepositoryFileEntry(
			String extRepositoryFileEntryKey, boolean createMajorVersion,
			String changeLog)
		throws SystemException {

	}

	@Override
	public ExtRepositoryFileEntry checkOutExtRepositoryFileEntry(
			String extRepositoryFileEntryKey)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public <T extends ExtRepositoryObject> T copyExtRepositoryObject(
			ExtRepositoryObjectType<T> extRepositoryObjectType,
			String extRepositoryFileEntryKey, String newExtRepositoryFolderKey,
			String newTitle)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public void deleteExtRepositoryObject(
			ExtRepositoryObjectType<? extends ExtRepositoryObject>
				extRepositoryObjectType,
			String extRepositoryObjectKey)
		throws SystemException {

	}

	@Override
	public String getAuthType() {
		return CompanyConstants.AUTH_TYPE_SN;
	}

	@Override
	public InputStream getContentStream(
			ExtRepositoryFileEntry extRepositoryFileEntry)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public InputStream getContentStream(
			ExtRepositoryFileVersion extRepositoryFileVersion)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public ExtRepositoryFileVersion getExtRepositoryFileVersion(
			ExtRepositoryFileEntry extRepositoryFileEntry, String version)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public ExtRepositoryFileVersionDescriptor
		getExtRepositoryFileVersionDescriptor(
			String extRepositoryFileVersionKey) {

		return new ExtRepositoryFileVersionDescriptor(
			extRepositoryFileVersionKey, "1.0");
	}

	@Override
	public List<ExtRepositoryFileVersion> getExtRepositoryFileVersions(
			ExtRepositoryFileEntry extRepositoryFileEntry)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public <T extends ExtRepositoryObject> T getExtRepositoryObject(
			ExtRepositoryObjectType<T> extRepositoryObjectType,
			String extRepositoryObjectKey)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public <T extends ExtRepositoryObject> T getExtRepositoryObject(
			ExtRepositoryObjectType<T> extRepositoryObjectType,
			String extRepositoryFolderKey, String title)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public <T extends ExtRepositoryObject> List<T> getExtRepositoryObjects(
			ExtRepositoryObjectType<T> extRepositoryObjectType,
			String extRepositoryFolderKey)
		throws SystemException {

		return Collections.emptyList();
	}

	@Override
	public int getExtRepositoryObjectsCount(
			ExtRepositoryObjectType<? extends ExtRepositoryObject>
				extRepositoryObjectType,
			String extRepositoryFolderKey)
		throws SystemException {

		return 0;
	}

	@Override
	public ExtRepositoryFolder getExtRepositoryParentFolder(
			ExtRepositoryObject extRepositoryObject)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public String getLiferayLogin(String extRepositoryLogin) {
		int index = extRepositoryLogin.lastIndexOf(StringPool.BACK_SLASH);

		return extRepositoryLogin.substring(index + 1);
	}

	@Override
	public String getRootFolderKey() {
		return _rootFolder.getExtRepositoryModelKey();
	}

	@Override
	public List<String> getSubfolderKeys(
			String extRepositoryFolderKey, boolean recurse)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public String[] getSupportedConfigurations() {
		return _SUPPORTED_CONFIGURATIONS;
	}

	@Override
	public String[][] getSupportedParameters() {
		return _SUPPORTED_PARAMETERS;
	}

	@Override
	public void initRepository(
			UnicodeProperties typeSettingsProperties,
			CredentialsProvider credentialsProvider)
		throws SystemException {

		try {
			_credentialsProvider = credentialsProvider;
			_host = typeSettingsProperties.getProperty(_PARAMETER_HOST);
			_database = typeSettingsProperties.getProperty(_DATABASE);
			_rootFolder = LotusNotesFolder.createRootFolder();
		}
		catch (LotusException lne) {
			throw new SystemException(lne);
		}
	}

	@Override
	public <T extends ExtRepositoryObject> T moveExtRepositoryObject(
			ExtRepositoryObjectType<T> extRepositoryObjectType,
			String extRepositoryObjectKey, String newExtRepositoryFolderKey,
			String newTitle)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public List<ExtRepositorySearchResult<?>> search(
			SearchContext searchContext, Query query,
			ExtRepositoryQueryMapper extRepositoryQueryMapper)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public ExtRepositoryFileEntry updateExtRepositoryFileEntry(
			String extRepositoryFileEntryKey, String mimeType,
			InputStream inputStream)
		throws SystemException {

		throw new UnsupportedOperationException("TODO");
	}

	private static final String _CONFIGURATION_WS = "LOTUS_NOTES_WS";

	private static final String _PARAMETER_HOST = "HOST";

	private static final String _PARAMETER_FORM = "FORM";

	private static final String _PARAMETER_CONTENT_FIELD = "CONTENT";

	private static final String _DATABASE = "DATABASE";

	private static final String[] _SUPPORTED_CONFIGURATIONS =
		{_CONFIGURATION_WS};

	private static final String[][] _SUPPORTED_PARAMETERS =
		{{_PARAMETER_HOST, _PARAMETER_FORM, _PARAMETER_CONTENT_FIELD}};

	private String _database;
	private String _host;
	private LotusNotesFolder _rootFolder;

}