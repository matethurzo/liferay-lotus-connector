<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ImportEntry importEntry = (ImportEntry)row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:actionURL name="executeImport" var="importURL">
		<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
		<liferay-portlet:param name="importEntryId" value="<%= String.valueOf(importEntry.getImportEntryId()) %>" />
	</liferay-portlet:actionURL>

	<liferay-ui:icon
		image="forward"
		message="import"
		url="<%= importURL %>"
	/>

	<c:if test="<%= CalendarImporterPermission.contains(permissionChecker, importEntry.getGroupId(), ActionKeys.MANAGE) %>">
		<liferay-portlet:actionURL name="deleteImportEntry" var="deleteURL">
			<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			<liferay-portlet:param name="importEntryId" value="<%= String.valueOf(importEntry.getImportEntryId()) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>