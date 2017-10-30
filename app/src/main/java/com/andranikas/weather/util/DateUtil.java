package com.andranikas.weather.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import static com.andranikas.weather.util.Constants.DATE_FORMAT_AM_PM;
import static com.andranikas.weather.util.Constants.MILLISECONDS_IN_MINUTE;
import static org.joda.time.DateTimeConstants.FRIDAY;
import static org.joda.time.DateTimeConstants.MONDAY;
import static org.joda.time.DateTimeConstants.SATURDAY;
import static org.joda.time.DateTimeConstants.SUNDAY;
import static org.joda.time.DateTimeConstants.THURSDAY;
import static org.joda.time.DateTimeConstants.TUESDAY;
import static org.joda.time.DateTimeConstants.WEDNESDAY;
import static org.joda.time.DateTimeZone.UTC;

/**
 * Created by andranikas on 10/24/2017.
 */

public final class DateUtil {

    private DateUtil() {
    }

    public static String amPmTimeFromUTCSeconds(long seconds) {
        return DateTimeFormat.forPattern(DATE_FORMAT_AM_PM).withZoneUTC().print(MILLISECONDS_IN_MINUTE * seconds);
    }

    public static int dayFromUTCSeconds(long seconds) {
        DateTime dateTime = new DateTime(MILLISECONDS_IN_MINUTE * seconds, UTC);
        return dateTime.getDayOfMonth();
    }

    public static String dayNameFromUTCSeconds(long seconds) {
        DateTime dateTime = new DateTime(MILLISECONDS_IN_MINUTE * seconds, UTC);
        return getDayOfWeek(dateTime.getDayOfWeek());
    }

    private static String getDayOfWeek(int day) {
        switch (day) {
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            case FRIDAY:
                return "Friday";
            case SATURDAY:
                return "Saturday";
            case SUNDAY:
                return "Sunday";
        }
        return "";
    }
}
