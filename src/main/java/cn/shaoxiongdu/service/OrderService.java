/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.Log;
import cn.shaoxiongdu.bean.Order;
import cn.shaoxiongdu.db.DB;

import java.util.ArrayList;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 19:14
 * @描述:
 */
public class OrderService {

    private static ArrayList<Order> orders = DB.db.get("orderDB");

    /**
     * 查找所有
     *
     * @return
     */
    public static ArrayList<Order> getAll() {
        LogService.log("查找所有", "查看了所有的订单", true, Log.LogType.收银员管理模块日志, "无");
        return orders;
    }

    /**
     * 添加
     *
     * @param order 订单
     */
    public static void add(Order order) {
        LogService.log("下单", "添加了一个订单,订单ID为" + order.getId(), true, Log.LogType.商品模块日志, "无");
        orders.add(order);
    }

    public static Order getById(int id) {

        for (Order order : orders) {
            if (order.getId() == id) {
                LogService.log("查询订单", "查询到了一个订单,ID为" + order.getId(), true, Log.LogType.商品模块日志, "无");
                return order;
            }
        }
        return null;
    }
}
