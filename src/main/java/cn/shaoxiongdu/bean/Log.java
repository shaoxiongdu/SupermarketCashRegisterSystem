/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.bean;

import cn.shaoxiongdu.utils.DateTimeUtil;

import java.util.StringJoiner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 9:52
 * @描述: 日志记录
 */
public class Log {

    /**
     * ID累加器
     */
    private static long count = 0;

    /**
     * 记录ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 记录时间
     */
    private String dateTime;

    /**
     * 是否成功
     */
    private Boolean isSuccess;

    /**
     * 日志类型
     */
    private LogType logType;

    private String remark;

    /**
     * 无参构造
     */
    public Log() {
    }

    /**
     * 构造方法
     *
     * @param title
     * @param description
     * @param isSuccess
     * @param logType
     * @param remark
     */
    public Log(String title, String description, Boolean isSuccess, LogType logType, String remark) {
        this.id = ++count;
        this.title = title;
        this.description = description;
        this.isSuccess = isSuccess;
        this.logType = logType;
        this.remark = remark;
        this.dateTime = DateTimeUtil.getNowDateTime();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return new StringJoiner("\t", id + "\t", "")
                .add(dateTime)
                .add("" + logType)
                .add((isSuccess ? "成功" : "失败"))
                .add("\t" + title)
                .add(":" + description)
                .add("\t\t备注:" + remark)
                .toString();
    }

    /**
     * 日志类型枚举
     */
    public enum LogType {
        收银员管理模块日志,
        日志管理模块日志,
        收银员登录日志,
        订单模块日志,
        商品模块日志,
    }
}
