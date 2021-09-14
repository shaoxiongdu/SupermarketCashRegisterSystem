/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.productmodule;

import cn.shaoxiongdu.bean.ProductType;
import cn.shaoxiongdu.service.ProductTypeService;
import cn.shaoxiongdu.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 17:25
 * @描述: 商品类型
 */
public class ProductTypeController {

    public static void menu() {

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("---------- 商 品 类 型 管 理 模 块 --------------------");
            System.out.println("1.类 型 列 表\n2.新 增 类 型\n3.移 除 类 型\n4.返 回 上 一 级");
            System.out.println("---------------------------------------------------");
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
        System.out.print("请输入要移除的类型ID: ");
        int id = new Scanner(System.in).nextInt();
        ProductTypeService.remove(id);
    }

    /**
     * 商品类型列表
     */
    public static void printAll() {

        ArrayList<ProductType> all = ProductTypeService.getAll();

        System.out.println("--------------------------------------- 商 品 类 型 列 表 -------------------------------------------------------------");
        System.out.println("\tID\t名称");
        for (ProductType productType : all) {
            System.out.println(productType);
        }
        System.out.println("---------------------------------------- 商 品 类 型 列 表 ------------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条数据。");
    }

    public static void add() {

        System.out.println("------------- 新 增 商 品 类 型 ---------------");
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入商品类型名称:");
        String name = scanner.next();

        ProductType productType = new ProductType(name);

        ProductTypeService.add(productType);
        System.out.println(name + " 添加成功! ");
    }


}
