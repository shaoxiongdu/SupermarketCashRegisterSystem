/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.Log;
import cn.shaoxiongdu.bean.Product;
import cn.shaoxiongdu.db.DB;

import java.util.ArrayList;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:38
 * @描述: 商品类型管理
 */
public class ProductService {

    private static ArrayList<Product> products = DB.db.get("productDB");


    /**
     * 查找所有
     *
     * @return
     */
    public static ArrayList<Product> getAll() {
        LogService.log("查找所有", "查看了所有的商品", true, Log.LogType.商品模块日志, "无");
        return products;
    }

    /**
     * 添加商品
     *
     * @param product 商品
     */
    public static void add(Product product) {
        LogService.log("添加商品", "添加了一个商品:" + product.getName(), true, Log.LogType.商品模块日志, "无");
        products.add(product);
    }

    /**
     * 根据ID删除商品
     *
     * @param id
     */
    public static void remove(int id) {

        Product product = new Product();
        product.setId(id);
        boolean remove = products.remove(product);
        if (remove) {
            System.out.println("移除成功!");
            LogService.log("删除商品", "删除了ID为" + id + "的商品", true, Log.LogType.商品模块日志, "无");
        } else {
            System.out.println("移除失败，该商品不存在!");
            LogService.log("删除商品", "尝试删除ID为" + id + "的商品", false, Log.LogType.商品模块日志, "该ID的商品不存在");
        }
    }

    /**
     * 通过ID获取
     *
     * @return
     */
    public static Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
