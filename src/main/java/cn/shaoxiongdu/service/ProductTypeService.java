/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.Log;
import cn.shaoxiongdu.bean.ProductType;
import cn.shaoxiongdu.db.DB;

import java.util.ArrayList;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:38
 * @描述: 商品类型管理
 */
public class ProductTypeService {

    private static ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");


    /**
     * 查找所有
     *
     * @return
     */
    public static ArrayList<ProductType> getAll() {
        LogService.log("查找所有", "查看了所有的商品类型", true, Log.LogType.商品模块日志, "无");
        return productTypes;
    }

    public static void add(ProductType productType) {
        LogService.log("添加商品类型", "添加了一个商品类型:" + productType.getName(), true, Log.LogType.商品模块日志, "无");
        productTypes.add(productType);
    }

    public static void remove(int id) {

        ProductType productType = new ProductType();
        productType.setId(id);
        boolean remove = productTypes.remove(productType);
        if (remove) {
            System.out.println("移除成功!");
            LogService.log("删除商品类型", "删除了ID为" + id + "的商品类型", true, Log.LogType.商品模块日志, "无");
        } else {
            System.out.println("移除失败，该商品类型不存在!");
            LogService.log("删除商品类型", "尝试删除ID为" + id + "的商品类型", false, Log.LogType.商品模块日志, "该ID的类型不存在");
        }
    }
}
