/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.cashregistermodule;

import cn.shaoxiongdu.bean.Cashier;
import cn.shaoxiongdu.db.DB;
import cn.shaoxiongdu.service.CashierService;
import cn.shaoxiongdu.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:26
 * 收银模块控制层
 */
public class CashRegisterModule {

    public static void login() {

        Scanner scanner = new Scanner(System.in);

        Cashier cashier = null;
        while (true) {
            System.out.println("请输入您的收银员账号:");
            String account = scanner.next();
            System.out.println("请输入您的收银员密码:");
            String password = scanner.next();
            System.out.println("正在登录");
            cashier = CashierService.login(account, password);
            if (cashier != null) {
                break;
            }
            System.out.println("\n账号或者密码错误, 请重试!");
        }
        ArrayList<Cashier> cashiers = new ArrayList<>();

        cashiers.add(cashier);
        System.out.println("\n登录成功!，欢迎您:" + cashier.getName());
        DB.db.put("loginCashier", cashiers);

        //显示主菜单
        menu();

    }

    public static void menu() {

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("------------ 收 银 模 块  -----------------");
            System.out.println("1.新 增 订 单 \n2.订 单 列 表\n3.查 找 订 单 \n4.返回上一级");

            System.out.print("\n 请 输 入 您 的 选 择:");

            int select = InputUtils.inputInt(1, 4);

            switch (select) {
                case 1:
                    OrderController.add();
                    break;
                case 2:
                    OrderController.printAll();
                    break;
                case 3:
                    OrderController.find();
                    break;
                case 4:
                    return;
            }
        }
        System.out.println("\t\t\t ------------ 收 银 模 块 结 束 -----------------");

    }

}
