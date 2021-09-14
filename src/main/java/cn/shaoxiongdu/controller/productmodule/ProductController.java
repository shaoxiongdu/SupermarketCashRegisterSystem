/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.productmodule;

import cn.shaoxiongdu.bean.Product;
import cn.shaoxiongdu.bean.ProductType;
import cn.shaoxiongdu.service.ProductService;
import cn.shaoxiongdu.service.ProductTypeService;
import cn.shaoxiongdu.utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 17:25
 * @描述: 产品
 */
public class ProductController {

    public static void menu() {

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("---------- 商 品 管 理 模 块 --------------------");
            System.out.println("1.商 品 列 表\n2.新 增 商 品 \n3.移 除 商 品 \n4.返 回 上 一 级");
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
        System.out.print("请输入要移除的类型ID: ");
        int id = new Scanner(System.in).nextInt();
        ProductTypeService.remove(id);
    }

    /**
     * 商品列表
     */
    public static void printAll() {

        ArrayList<Product> all = ProductService.getAll();

        System.out.println("--------------------------------------- 商 品 列 表 -------------------------------------------------------------");
        System.out.println("\t编号\t\t名称\t\t价格\t\t所属类别");
        for (Product product : all) {
            System.out.println(product);
        }
        System.out.println("---------------------------------------- 商 品 列 表 ------------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条数据。");
    }

    public static void add() {

        System.out.println("------------- 新 增 商 品 ---------------");
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入商品名称:");
        String name = scanner.next();

        System.out.print("请输入商品价格:");
        Double price = scanner.nextDouble();

        ArrayList<ProductType> all = ProductTypeService.getAll();
        for (ProductType productType : all) {
            System.out.println(productType);
        }
        System.out.print("请输入商品类型编号:");
        int typeId = scanner.nextInt();

        Product product = new Product(name, price, typeId);

        ProductService.add(product);

        System.out.println(name + " 添加成功! ");
    }

}
