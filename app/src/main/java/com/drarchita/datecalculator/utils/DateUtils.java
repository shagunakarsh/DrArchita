package com.drarchita.datecalculator.utils;

import android.util.Log;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by Shagun on 05-11-2017.
 */

public final class DateUtils {

    private static final String TAG = DateUtils.class.getName();

    private DateUtils(){}

    public static int betweenDates(String startDate, String endDate) {
        int days = 0;

        if(StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)) {

            org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);
            org.joda.time.LocalDate startDt = org.joda.time.LocalDate.parse(startDate, dateTimeFormatter);
            org.joda.time.LocalDate endDt = org.joda.time.LocalDate.parse(endDate, dateTimeFormatter);

            days = Days.daysBetween(startDt, endDt).getDays();
        }

        return days;
    }

    public static org.joda.time.LocalDate addToDate(String startDate, String months, String weeks, String days) {
        Integer m, w, d;
        try {
            m = StringUtils.isNotBlank(months) ? Integer.parseInt(months) : 0;
            w = StringUtils.isNotBlank(weeks) ? Integer.parseInt(weeks) : 0;
            d = StringUtils.isNotBlank(days) ? Integer.parseInt(days) : 0;
        } catch (NumberFormatException e) {
            m = 0;
            w = 0;
            d = 0;
            Log.e(TAG, "Invalid numbers passed, m: " + months + " w: " + weeks + " d: " + days);
        }

        org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);
        org.joda.time.LocalDate startDt = org.joda.time.LocalDate.parse(startDate, dateTimeFormatter);

        return startDt.plusMonths(m).plusWeeks(w).plusDays(d);
    }
}
