package com.example.todayhistory.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @PackageName: com.example.todayhistory.utils
 * @ClassName: DateUtils
 * @Author: winwa
 * @Date: 2023/1/12 8:20
 * @Description:
 **/
public class DateUtils {
    private static Calendar mCalendar = Calendar.getInstance();
    private static String[] WEEK_NAME = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    public static Date getDate(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int getYear(Date date) {
        mCalendar.setTime(date);
        return mCalendar.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        mCalendar.setTime(date);
        return mCalendar.get(Calendar.MONTH) + 1;
    }

    public static int getDay(Date date) {
        mCalendar.setTime(date);
        return mCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getWeekName(Date date) {
        mCalendar.setTime(date);
        if (mCalendar.getFirstDayOfWeek() == Calendar.SUNDAY) {
            return WEEK_NAME[mCalendar.get(Calendar.DAY_OF_WEEK) - 1];
        } else {
            return WEEK_NAME[(mCalendar.get(Calendar.DAY_OF_WEEK) + 1 % 7) - 1];
        }
    }

    public static String getDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
