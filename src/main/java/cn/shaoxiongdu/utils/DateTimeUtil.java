/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 9:45
 * @描述: 日期工具类
 */
public class DateTimeUtil {

    /**
     * yyyy年MM月dd日
     */
    public static final String DATE = "yyyy年MM月dd日";
    /**
     * HH时mm分ss秒
     */
    public static final String TIME = "HH时mm分ss秒";
    /**
     * yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final String DATE_TIME = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 返回当前日期
     *
     * @return yyyy年MM月dd日
     */
    public static String getNowDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE);
        return dateTimeFormatter.format(LocalDate.now());
    }

    /**
     * 返回当前时间
     *
     * @return HH时mm分ss秒
     */
    public static String getNowTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME);
        return dateTimeFormatter.format(LocalTime.now());
    }

    /**
     * 返回当前日期+时间
     *
     * @return yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String getNowDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

}
