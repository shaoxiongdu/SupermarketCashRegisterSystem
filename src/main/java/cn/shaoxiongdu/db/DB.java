/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.db;

import cn.shaoxiongdu.bean.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:09
 * @描述: 仿数据库
 */
public class DB {

    //总数据库
    public static HashMap<String, ArrayList> db = new HashMap<>();

    /**
     * 初始化数据
     */
    public static void init() {

        //日志管理数据库
        db.put("logDB", new ArrayList<Log>());

        //收银员管理数据库
        db.put("cashierDB", new ArrayList<Calendar>());

        //产品管理数据库
        db.put("productDB", new ArrayList<Product>());

        //产品类型管理数据库
        db.put("productTypeDB", new ArrayList<ProductType>());

        //订单管理数据库
        db.put("orderDB", new ArrayList<Order>());

        db.put("loginCashier", null);

        //随机生成5个收银员
        ArrayList<Cashier> calendars = DB.db.get("cashierDB");
        calendars.add(Cashier.getRandom());
        calendars.add(Cashier.getRandom());
        calendars.add(Cashier.getRandom());
        calendars.add(Cashier.getRandom());
        calendars.add(Cashier.getRandom());

        //添加商品类型
        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");
        productTypes.add(new ProductType("食品类"));
        productTypes.add(new ProductType("日用品类"));
        productTypes.add(new ProductType("文具类"));
        productTypes.add(new ProductType("水果类"));
        productTypes.add(new ProductType("饮料类"));
        productTypes.add(new ProductType("数码类"));

        //添加商品
        ArrayList<Product> products = DB.db.get("productDB");
        products.add(new Product("小米11", 5999.99, 6));
        products.add(new Product("康师傅冰红茶", 3.00, 5));
        products.add(new Product("新疆进口西瓜", 10.00, 4));
        products.add(new Product("中性笔", 1.00, 3));
        products.add(new Product("保温杯", 15.00, 2));
        products.add(new Product("康佳锅巴", 3.00, 1));

        ArrayList<Order> orders = DB.db.get("orderDB");

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1, 1);
        integerIntegerHashMap.put(2, 2);
        integerIntegerHashMap.put(3, 3);

        orders.add(new Order(1, integerIntegerHashMap));


    }

}
