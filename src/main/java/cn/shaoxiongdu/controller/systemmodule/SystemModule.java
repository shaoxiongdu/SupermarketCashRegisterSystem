/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.controller.systemmodule;

import cn.shaoxiongdu.utils.InputUtils;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:26
 * @描述: 系统模块控制层
 */
public class SystemModule {

    public static void menu() {


        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("--------------- 系 统 管 理 ---------------------");
            System.out.println("1.收 银 员 管 理 \n2.日 志 管 理\n3.返 回 上 级");
            System.out.println("--------------- 系 统 管 理 ---------------------");

            System.out.print("\n 请 输 入 您 的 选 择:");

            int select = InputUtils.inputInt(1, 3);

            switch (select) {
                case 1:
                    CashierController.menu();
                    break;
                case 2:
                    LogController.menu();
                    break;
                case 3:
                    return;
            }
        }
    }

}
