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
List<String> types = ImportSourceFactory.getTypes();

boolean showAddImportEntryButtons = CalendarImporterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.MANAGE);
boolean showPermissionsButton = CalendarImporterPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);

if (types.isEmpty()) {
	showAddImportEntryButtons = false;
}
%>

<c:if test="<%= showAddImportEntryButtons || showPermissionsButton %>">
	<aui:button-row>
		<c:if test="<%= showAddImportEntryButtons %>">
			<liferay-portlet:renderURL varImpl="addImportEntryURL">
				<liferay-portlet:param name="mvcPath" value="/edit_import_entry.jsp" />
				<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			</liferay-portlet:renderURL>

			<%
			for (String type : types) {
				addImportEntryURL.setParameter("type", type);
			%>

				<aui:button href="<%= addImportEntryURL.toString() %>" value='<%= LanguageUtil.format(pageContext, "add-x", type) %>' />

			<%
			}
			%>

		</c:if>

		<c:if test="<%= showPermissionsButton %>">
			<liferay-security:permissionsURL
				modelResource="com.liferay.calendarimporter"
				modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
				resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
				var="permissionsURL"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>"
			/>

			<aui:button href="<%= permissionsURL %>" useDialog="<%= true %>" value="permissions" />
		</c:if>
	</aui:button-row>
</c:if>

<liferay-ui:search-container emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= ImportEntryLocalServiceUtil.getImportEntries(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ImportEntryLocalServiceUtil.getImportEntriesCount(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.calendarimporter.model.ImportEntry"
		escapedModel="<%= true %>"
		keyProperty="importEntryId"
		modelVar="importEntry"
	>
		<liferay-ui:search-container-column-text
			property="name"
		/>

		<liferay-ui:search-container-column-text
			property="description"
		/>

		<liferay-ui:search-container-column-text
			name="type"
			value="<%= LanguageUtil.get(pageContext, importEntry.getType()) %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/import_entry_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>