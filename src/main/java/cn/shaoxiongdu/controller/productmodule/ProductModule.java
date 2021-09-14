/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.productmodule;

import cn.shaoxiongdu.utils.InputUtils;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:26
 * @描述: 产品模块控制层
 */
public class ProductModule {

    public static void menu() {

        System.out.println("--------------- 商 品 模 块 ---------------------");

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("1.商 品 管 理 \n2.商 品 类 型 管 理\n3.返 回 上 级");
            System.out.println("--------------- 系 统 管 理 ---------------------");

            System.out.print("\n 请 输 入 您 的 选 择:");

            int select = InputUtils.inputInt(1, 3);

            switch (select) {
                case 1:
                    ProductController.menu();
                    break;
                case 2:
                    ProductTypeController.menu();
                    break;
                case 3:
                    return;
            }
        }
    }

}
