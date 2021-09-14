/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.cashregistermodule;

import cn.shaoxiongdu.bean.Cashier;
import cn.shaoxiongdu.bean.Order;
import cn.shaoxiongdu.controller.productmodule.ProductController;
import cn.shaoxiongdu.db.DB;
import cn.shaoxiongdu.service.OrderService;
import cn.shaoxiongdu.utils.InputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 19:12
 * @描述: 订单模块控制层
 */
public class OrderController {

    public static void printAll() {

        ArrayList<Order> all = OrderService.getAll();

        System.out.println("--------------------------------------- 订 单 列 表 -------------------------------------------------------------");

        for (Order order : all) {
            System.out.println(order);
        }
        System.out.println("---------------------------------------- 订 单 列 表 ------------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条订单数据。");
    }

    /**
     * 新增订单
     */
    public static void add() {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        ProductController.printAll();
        while (true) {
            System.out.print("请输入想要购买的商品编号:");
            int productId = scanner.nextInt();
            System.out.print("请输入购买数量: ");
            int count = scanner.nextInt();
            map.put(productId, count);
            System.out.println("是否继续? (y/n):");
            if (!InputUtils.inputBoolean()) {
                break;
            }
        }

        //获取当前登录的收银员列表
        ArrayList<Cashier> arrayList = DB.db.get("loginCashier");

        //获取当前登录的收银员
        Cashier cashier = arrayList.get(0);

        //填充订单中的收银员ID
        Order order = new Order(cashier.getId(), map);

        System.out.println("下单成功,您的购物车如下:");
        System.out.println(order);

        System.out.println("请付款!");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("付款成功！");

        OrderService.add(order);

    }


    public static void find() {
        System.out.print("请输入订单编号: ");
        int id = new Scanner(System.in).nextInt();

        Order order = OrderService.getById(id);

        if (order != null) {
            System.out.println("为您查询到了如下结果！");
            System.out.println(order);
        } else {
            System.out.println("订单不存在!");
        }
    }
}
