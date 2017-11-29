package com.foodapplication.utils;

import android.text.TextUtils;

import com.foodapplication.helper.Constants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {
    private static Calendar calendar;

    public static HashMap<String, Integer> getDate(int dayOffSet) {
        HashMap<String, Integer> dateMap = new HashMap<>();
        calendar = Calendar.getInstance();
        if (dayOffSet > 0) {
            calendar.add(Calendar.DAY_OF_MONTH, dayOffSet);
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateMap.put("year", year);
        dateMap.put("month", month + 1);
        dateMap.put("day", day);

        return dateMap;
    }

    public static String getMonthName(Integer month) {
        return Constants.MONTH.get(month);
    }

    public static String getDayOfTheWeek(String date) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String goal = "";
        try {
            Date date2 = inFormat.parse(date);
            SimpleDateFormat outFormat = new SimpleDateFormat("EEE", Locale.ENGLISH);
            goal = outFormat.format(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return goal;
    }

    public static String getFullDayOfTheWeek(String date) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String goal = "";
        try {
            Date date2 = inFormat.parse(date);
            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
            goal = outFormat.format(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return goal;
    }

    public static String getCurrent24HourTime(int additionalMinute) {
        calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:45"));
        if (additionalMinute > 0) {
            calendar.add(Calendar.MINUTE, additionalMinute);
        }
        Date currentTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        date.setTimeZone(TimeZone.getTimeZone("GMT+5:45"));
        /*-------------------------------------------------------*/
        String time = date.format(currentTime);

        String[] a = time.split(":");
        //hour = Integer.parseInt(a[0]);
        String[] b = a[1].split("\\s+");
        int minute = Integer.parseInt(b[0]);

        return time;
    }

    public static String getCurrent12HourTime(int additionalMinute) {
        calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:45"));
        if (additionalMinute > 0) {
            calendar.add(Calendar.MINUTE, additionalMinute);
        }
        Date currentTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("KK:mm a", Locale.ENGLISH);
        date.setTimeZone(TimeZone.getTimeZone("GMT+5:45"));
        /*-------------------------------------------------------*/
        String time = date.format(currentTime);

        String[] a = time.split(":");
        //hour = Integer.parseInt(a[0]);
        String[] b = a[1].split("\\s+");
        int minute = Integer.parseInt(b[0]);

        return time;
    }

    public static String convert24to12(String time24Hour) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        try {
            Date date = parseFormat.parse(time24Hour);
            String time = displayFormat.format(date);
            int x = Integer.parseInt(time.substring(0, 1));
            if (x == 0) {
                time = time.substring(1);
            }
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convert12to24(String time12Hour) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
        try {
            Date date = parseFormat.parse(time12Hour);
            return displayFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDayOfMonthSuffix(int n) {
        String[] suffixes =
                //    0     1     2     3     4     5     6     7     8     9
                {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
                        //    10    11    12    13    14    15    16    17    18    19
                        "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
                        //    20    21    22    23    24    25    26    27    28    29
                        "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
                        //    30    31
                        "th", "st"};
        return suffixes[n];

    }

    public static HashMap<String, Object> offSetDay(String fullDate, int offSet) {
        String date[] = TextUtils.split(fullDate, "-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[2]));

        /*int newOffSet;
        if (offSet > 0) {
            newOffSet = offSet - 1;
        } else {
            newOffSet = offSet;
        }*/

        calendar.add(Calendar.DAY_OF_MONTH, offSet);

        int year, month, day;
        String newFullDate;

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        newFullDate = year + "-" + month + "-" + day;

        HashMap<String, Object> dateMap = new HashMap<>();
        dateMap.put("year", year);
        dateMap.put("month", month);
        dateMap.put("day", day);
        dateMap.put("dayOfWeek", getDayOfTheWeek(newFullDate));
        dateMap.put("fullDate", newFullDate);
        return dateMap;
    }

    public static String getFullDate(String date) {
        String[] dateArray = date.split("-");
        String month, day;
        if (dateArray[1].length() == 1) {
            month = 0 + dateArray[1];
        } else {
            month = dateArray[1];
        }
        if (dateArray[2].length() == 1) {
            day = 0 + dateArray[2];
        } else {
            day = dateArray[2];
        }
        return dateArray[0] + "-" + month + "-" + day;
    }

    public static Integer getDateDifference(String lastDate) {
        HashMap<String, Integer> dateMap = getDate(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        if (lastDate.length() == 0) {
            lastDate = dateMap.get("year") + "-" + dateMap.get("month") + "-" + dateMap.get("day");
        }
        try {
            Date date1 = dateFormat.parse(dateMap.get("year") + "-" + dateMap.get("month") + "-" + dateMap.get("day"));
            Date date2 = dateFormat.parse(lastDate);

            Long difference = Math.abs(date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
            return Integer.parseInt(difference.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Integer getTimeDifference(String dateTime) {
        return 0;
    }

    public static String getDuration(String primary, String secondary) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        try {
            Date date1 = simpleDateFormat.parse(primary);
            Date date2 = simpleDateFormat.parse(secondary);

            long different = date2.getTime() - date1.getTime();

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            String day = "", hour = "";

            if (elapsedDays > 0) {
                day = elapsedDays + "d ";
            }

            if (elapsedHours > 0) {
                hour = elapsedHours + "h ";
            }

            return day + hour + elapsedMinutes + "m";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
}