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
ImportEntry importEntry = (ImportEntry)request.getAttribute(WebKeys.IMPORT_ENTRY);

long importEntryId = BeanParamUtil.getLong(importEntry, request, "importEntryId");
String type = BeanParamUtil.getString(importEntry, request, "type");

UnicodeProperties typeSettingsProperties = null;

if (importEntry != null) {
	typeSettingsProperties = importEntry.getTypeSettingsProperties();
}
else {
	typeSettingsProperties = new UnicodeProperties();
}

ImportSource importSource = ImportSourceFactory.getImportSource(type);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	localizeTitle="<%= false %>"
	title='<%= (importEntry == null) ? LanguageUtil.format(pageContext, "new-x", type) : importEntry.getName() %>'
/>

<liferay-portlet:actionURL name="updateImportEntry" var="updateImportEntryURL">
	<liferay-portlet:param name="mvcPath" value="/edit_import_entry.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%= updateImportEntryURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveImportEntry();" %>'>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="importEntryId" type="hidden" value="<%= importEntryId %>" />
	<aui:input name="type" type="hidden" value="<%= type %>" />

	<aui:model-context bean="<%= importEntry %>" model="<%= ImportEntry.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<aui:input name="description" />

		<%
		for (String key : importSource.getSettingKeys()) {
		%>

			<aui:input name='<%= "settings--" + key + "--" %>' type="text" value="<%= typeSettingsProperties.getProperty(key) %>" />

		<%
		}
		%>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />saveImportEntry() {
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>