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

package com.liferay.calendarimporter.source;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarBookingConstants;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.text.DateFormat;
import java.text.ParseException;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Andrea Di Giorgi
 */
public class LotusNotesImportSource extends BaseImportSource {

	@Override
	public String[] getSettingKeys() {
		return new String[] {"url", "user-name", "password"};
	}

	@Override
	public String getType() {
		return _TYPE;
	}

	@Override
	protected void doExecuteImport(
			Calendar calendar, UnicodeProperties typeSettingsProperties)
		throws Exception {

		String url = typeSettingsProperties.getProperty("url");
		String userName = typeSettingsProperties.getProperty("user-name");
		String password = typeSettingsProperties.getProperty("password");

		if (!StringUtil.endsWith(url, CharPool.SLASH)) {
			url += CharPool.SLASH;
		}

		url += _EVENTS_PATH;

		Http.Options options = new Http.Options();

		options.setAuth(null, 0, null, userName, password);
		options.setLocation(url);

		String json = HttpUtil.URLtoString(options);

		if (Validator.isNull(json)) {
			return;
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);

		JSONArray eventsJSON = jsonObject.getJSONArray("events");

		importEvents(calendar, eventsJSON);
	}

	protected Map<Locale, String> getLocalizedMap(
		JSONObject eventJSON, Locale locale, String key) {

		String value = eventJSON.getString(key);

		Map<Locale, String> map = new HashMap<Locale, String>();

		map.put(locale, value);

		return map;
	}

	protected long getTime(JSONObject eventJSON, String key)
		throws ParseException {

		DateFormat dateFormatDateTime =
			DateFormatFactoryUtil.getSimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.US, _utcTimeZone);

		JSONObject jsonObject = eventJSON.getJSONObject(key);

		String dateString = jsonObject.getString("date");
		String timeString = jsonObject.getString("time");

		Date date = (Date)dateFormatDateTime.parseObject(
			dateString + StringPool.SPACE + timeString);

		return date.getTime();
	}

	protected void importEvent(Calendar calendar, JSONObject eventJSON)
		throws Exception {

		User user = UserLocalServiceUtil.getUser(calendar.getUserId());
		Locale locale = user.getLocale();

		String uuid = eventJSON.getString("id");
		Map<Locale, String> titleMap = getLocalizedMap(
			eventJSON, locale, "summary");
		Map<Locale, String> descriptionMap = getLocalizedMap(
			eventJSON, locale, "description");
		String location = eventJSON.getString("location");
		long startTime = getTime(eventJSON, "start");
		long endTime = getTime(eventJSON, "end");
		boolean allDay = false;
		String recurrence = null;
		long firstReminder = 0;
		String firstReminderType = null;
		long secondReminder = 0;
		String secondReminderType = null;

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setUuid(uuid);

		CalendarBooking calendarBooking =
			CalendarBookingLocalServiceUtil.fetchCalendarBooking(
				uuid, calendar.getGroupId());

		if (calendarBooking != null) {
			CalendarBookingLocalServiceUtil.updateCalendarBooking(
				user.getUserId(), calendarBooking.getCalendarBookingId(),
				calendarBooking.getCalendarId(), titleMap, descriptionMap,
				location, startTime, endTime, allDay, recurrence, firstReminder,
				firstReminderType, secondReminder, secondReminderType,
				WorkflowConstants.STATUS_APPROVED, serviceContext);
		}
		else {
			CalendarBookingLocalServiceUtil.addCalendarBooking(
				user.getUserId(), calendar.getCalendarId(), new long[0],
				CalendarBookingConstants.PARENT_CALENDAR_BOOKING_ID_DEFAULT,
				titleMap, descriptionMap, location, startTime, endTime, allDay,
				recurrence, firstReminder, firstReminderType, secondReminder,
				secondReminderType, serviceContext);
		}
	}

	protected void importEvents(Calendar calendar, JSONArray eventsJSON)
		throws Exception {

		for (int i = 0; i < eventsJSON.length(); i++) {
			JSONObject eventJSON = eventsJSON.getJSONObject(i);

			importEvent(calendar, eventJSON);
		}
	}

	private static final String _EVENTS_PATH = "api/calendar/events";

	private static final String _TYPE = "lotus-notes";

	private static TimeZone _utcTimeZone = TimeZoneUtil.getTimeZone(
		StringPool.UTC);

}