/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.bean;

import cn.shaoxiongdu.db.DB;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 15:59
 * @描述:
 */
public class Product {

    private static int count = 0;

    /**
     * 产品ID
     */
    private int id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品价格
     */
    private double price;

    /**
     * 所属类别ID
     */
    private int typeId;

    public Product(String name, double price, int typeId) {
        this.id = ++count;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
    }

    public Product() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    @Override
    public String toString() {

        //将所属类别的ID转为名称
        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");
        String productTypeName = null;
        for (ProductType productType : productTypes) {
            if (this.typeId == productType.getId()) {
                productTypeName = productType.getName();
            }
        }

        return new StringJoiner("\t ", "\t" + id + "\t\t", "")
                .add(name)
                .add(price + "￥")
                .add("" + productTypeName)
                .toString();
    }

    /**
     * 根据产品编号作为比较标准
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


}
