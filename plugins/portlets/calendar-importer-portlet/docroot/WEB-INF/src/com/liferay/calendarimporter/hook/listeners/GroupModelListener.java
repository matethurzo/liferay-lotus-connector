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

package com.liferay.calendarimporter.hook.listeners;

import com.liferay.calendarimporter.service.ImportEntryLocalServiceUtil;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Group;

/**
 * @author Andrea Di Giorgi
 */
public class GroupModelListener extends BaseModelListener<Group> {

	@Override
	public void onAfterRemove(Group group) throws ModelListenerException {
		try {
			doOnAfterRemove(group);
		}
		catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	protected void doOnAfterRemove(Group group) throws Exception {
		ImportEntryLocalServiceUtil.deleteImportEntries(group.getGroupId());
	}

}