/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.systemmodule;

import cn.shaoxiongdu.bean.Cashier;
import cn.shaoxiongdu.service.CashierService;
import cn.shaoxiongdu.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:38
 * @描述: 收银员管理控制层
 */
public class CashierController {

    public static void menu() {

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("---------- 收 银 员 管 理 模 块 --------------------");
            System.out.println("1.收 银 员 列 表\n2.新 增 收 银 员\n3.移 除 收 银 员\n4.返 回 上 一 级");
            System.out.println("-------------------------------------------------");
            System.out.print("\n 请 输 入 您 的 选 择:");

            int select = InputUtils.inputInt(1, 4);

            switch (select) {
                case 1:
                    printAll();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    isEnd = true;
                    break;
            }
        }

    }

    private static void remove() {
        printAll();
        System.out.print("请输入要移除的收银员ID: ");
        int id = new Scanner(System.in).nextInt();
        CashierService.remove(id);

    }

    /**
     * 收银员列表
     */
    public static void printAll() {

        ArrayList<Cashier> all = CashierService.getAll();

        System.out.println("--------------------------------------- 收 银 员 列 表 -------------------------------------------------------------");
        System.out.println("\tID\t账号\t\t\t\t密码\t\t\t\t性别\t\t年龄\t\t\t姓名\t\t\t联系方式\t\t\t\t地址");
        for (Cashier cashier : all) {
            System.out.println(cashier);
        }
        System.out.println("---------------------------------------- 收 银 员 列 表 ------------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条数据。");
    }

    public static void add() {

        System.out.println("------------- 新 增 收 银 员 ---------------");
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入账号:");
        String account = scanner.next();

        System.out.print("请输入密码:");
        String password = scanner.next();
        System.out.print("请输入姓名:");
        String name = scanner.next();
        System.out.print("请输入性别:");
        String sex = scanner.next();

        System.out.print("请输入年龄:");
        int age = InputUtils.inputInt(10, 100);
        System.out.print("请输入家庭住址:");
        String address = scanner.next();
        System.out.print("请输入手机号:");
        String phone = scanner.next();

        Cashier cashier = new Cashier(account, password, name, sex, age, address, phone);

        CashierService.add(cashier);

        System.out.println(name + " 添加成功! ");
    }

}
