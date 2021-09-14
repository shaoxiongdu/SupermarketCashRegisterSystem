/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.bean;

import cn.shaoxiongdu.service.CashierService;
import cn.shaoxiongdu.service.ProductService;
import cn.shaoxiongdu.utils.DateTimeUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:14
 * @描述: 订单
 */
public class Order {

    private static int count = 0;

    /**
     * 订单ID
     */
    private int id;

    /**
     * 收银员ID
     */
    private int cashierId;

    /**
     * 产品列表
     */
    private HashMap<Integer, Integer> products = null;

    /**
     * 总价
     */
    private double totalPrice;

    /**
     * 订单日期
     */
    private String dateTime;

    public Order(int cashierId, HashMap<Integer, Integer> products) {
        this.id = ++count;
        this.id = id;
        this.cashierId = cashierId;
        this.products = products;
        this.dateTime = DateTimeUtil.getNowDateTime();
    }


    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        double totalPrice = 0;
        String product = "===================";
        Set<Map.Entry<Integer, Integer>> entries = products.entrySet();
        for (Map.Entry entry : entries) {
            Product p = ProductService.getById((Integer) entry.getKey());
            totalPrice += p.getPrice() * (Integer) entry.getValue();
            product += "\n\t" + p.getName() + "\t单价:" + p.getPrice() + "\t数量:" + entry.getValue() + "\t\t";
        }
        product += "\n=================== 商 品 列 表 ===================";
        this.totalPrice = totalPrice;

        return new StringJoiner("\t\t", "--------------" + id + "号订单-------------\n", "--------------" + id + "号订单-------------\n")
                .add("收银员:" + CashierService.getById(cashierId).getName())
                .add("\n=================== 商 品 列 表 "  + product + "\n")
                .add("总价:" + this.totalPrice + "\t")
                .add("下单日期:" + dateTime + "\n")
                .toString();
    }
}
