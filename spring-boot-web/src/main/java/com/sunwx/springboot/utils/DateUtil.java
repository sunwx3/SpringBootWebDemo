package com.sunwx.springboot.utils;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 当前时间偏差任意天(整数) + 表示往后 - 表示往前
     *
     * @param date
     * @return
     */
    public static Date addDay(Date date, int span) {
        return DateUtils.addDays(date, span);
    }

    /**
     * 当前时间的上一个月
     *
     * @param date
     * @return
     */
    public static Date previousMonth(Date date) {
        return DateUtils.addMonths(date, -1);
    }

    /**
     * 设置日期从00:00:00 000开始
     *
     * @param date
     * @return
     */
    public static Date setDayBegin(Date date) {
        if (date == null) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static float getPassDayPercent(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int nowDayOfYear = c.get(Calendar.DAY_OF_YEAR);
        int year = c.get(Calendar.YEAR);
        int allDays;//某年(year)的天数
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){//闰年的判断规则
            allDays=366;
        }else{
            allDays=365;
        }
        float percent = (float)nowDayOfYear/allDays;
//        DecimalFormat df = new DecimalFormat("0.00");
//        df.format(percent);
        return percent;
    }

    /**
     * 设置日期从23:59:59 999结束
     *
     * @param date
     * @return
     */
    public static Date setDayEnd(Date date) {
        if (date == null) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 获取当前月第一天开始时间
     * @param date
     * @return
     */
    public static Date setMonthBegin(Date date){
        if(date==null){
            return  date;
        }
        Calendar c =Calendar.getInstance();
        c.add(Calendar.MONTH,0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }


    public static Date getFirstDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        return firstDayOfMonth;
    }
    public static Date getLastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDayOfMonth = calendar.getTime();
        return lastDayOfMonth;
    }



    /**
     * 日期格式化
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 日期格式化
     *
     * @param date
     * @param format
     * @return
     */
    public static Date format(String date, String format) throws ParseException {
        return DateUtils.parseDate(date, new String[]{format});
    }

}
