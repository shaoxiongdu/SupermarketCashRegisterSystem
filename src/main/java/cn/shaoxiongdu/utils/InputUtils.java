/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.utils;

import java.util.Scanner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 11:04
 * @描述: 输入工具类
 */
public class InputUtils {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取范围内的整数 如果失败  一直读取
     *
     * @param min
     * @param max
     * @return
     */
    public static int inputInt(int min, int max) {
        int result = 0;
        while (true) {
            try {
                String input = scanner.next();
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.print("范围有误,重新输入:");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("格式有误，重新输入: ");
            }
        }
        return result;
    }

    /**
     * 读取 y n 返回 布尔值
     *
     * @return
     */
    public static boolean inputBoolean() {
        boolean result = false;
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                result = true;
                break;
            }
            if (input.equalsIgnoreCase("n")) break;
            System.out.print("格式有误，重新输入:");
        }
        return result;
    }

    /**
     * 读取范围内的浮点数 如果失败  一直读取
     *
     * @param min
     * @param max
     * @return
     */
    public static double inputDouble(double min, double max) {
        double result = 0;
        while (true) {
            try {
                String input = scanner.next();
                result = Double.parseDouble(input);
                if (result < min || result > max) continue;
                break;
            } catch (NumberFormatException e) {
                System.out.print("格式有误，重新输入: ");
            }
        }
        return result;
    }

}
