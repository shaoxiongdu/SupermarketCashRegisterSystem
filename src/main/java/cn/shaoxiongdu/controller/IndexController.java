/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller;

import cn.shaoxiongdu.controller.cashregistermodule.CashRegisterModule;
import cn.shaoxiongdu.controller.productmodule.ProductModule;
import cn.shaoxiongdu.controller.systemmodule.SystemModule;
import cn.shaoxiongdu.utils.InputUtils;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:23
 * @描述: 主菜单控制层
 */
public class IndexController {

    public static void run() {

        System.out.println("\t\t\t 欢 迎 来 到 维 信 科 技 超 市 管 理 系 统 ~ ~ ~");

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.收 银 模 块 \n2.商 品 模 块\n3.系 统 模 块\n4.退 出 系 统");
            System.out.println("------------------------------------------------------");

            System.out.print("\n 请 输 入 您 的 选 择:");

            int select = InputUtils.inputInt(1, 4);

            switch (select) {
                case 1:
                    CashRegisterModule.login();
                    break;
                case 2:
                    ProductModule.menu();
                    break;
                case 3:
                    SystemModule.menu();
                    break;
                case 4:
                    isEnd = true;
                    break;
            }
        }
        System.out.println(" 感 谢 使 用，欢 迎 下 次 再 来 !");

    }

}
