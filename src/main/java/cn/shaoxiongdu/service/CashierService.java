/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.Cashier;
import cn.shaoxiongdu.bean.Log;
import cn.shaoxiongdu.db.DB;

import java.util.ArrayList;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:38
 * @描述: 收银员管理
 */
public class CashierService {

    private static ArrayList<Cashier> calendars = DB.db.get("cashierDB");

    public static Cashier login(String account, String password) {

        for (Cashier calendar : calendars) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (calendar.getAccount().equals(account) && calendar.getPassword().equals(password)) {
                LogService.log("尝试登录", "使用【账号:" + account + ",密码:" + password + "】登录", true, Log.LogType.收银员登录日志, "账号密码正确");
                return calendar;
            }
        }
        LogService.log("尝试登录", "使用【账号:" + account + ",密码:" + password + "】登录", false, Log.LogType.收银员登录日志, "账号密码验证错误");
        return null;
    }

    /**
     * 通过ID获取收银员
     *
     * @return
     */
    public static Cashier getById(int id) {
        for (Cashier calendar : calendars) {
            if (calendar.getId() == id) {
                return calendar;
            }
        }
        return null;
    }


    /**
     * 查找所有
     *
     * @return
     */
    public static ArrayList<Cashier> getAll() {
        LogService.log("查看所有收银员", "查看了所有的收银员信息", true, Log.LogType.收银员管理模块日志, "无");
        return calendars;
    }

    /**
     * 添加
     *
     * @param cashier
     */
    public static void add(Cashier cashier) {
        LogService.log("添加收银员", "添加了一个收银员:" + cashier.getName(), true, Log.LogType.收银员管理模块日志, "无");
        calendars.add(cashier);
    }

    public static void remove(int id) {

        Cashier cashier = new Cashier();
        cashier.setId(id);
        boolean remove = calendars.remove(cashier);
        if (remove) {
            System.out.println("移除收银员成功!");
            LogService.log("删除收银员", "删除了ID为" + id + "的收银员", true, Log.LogType.收银员管理模块日志, "无");
        } else {
            System.out.println("移除失败，该收银员不存在!");
            LogService.log("删除收银员", "尝试删除ID为" + id + "的收银员", false, Log.LogType.收银员管理模块日志, "该ID不存在");
        }
    }
}
