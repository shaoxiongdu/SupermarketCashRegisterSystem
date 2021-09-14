/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.bean;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 16:02
 * @描述:
 */
public class ProductType {

    private static int count = 0;

    /**
     * 类别ID
     */
    private int id;

    /**
     * 类别名称
     */
    private String name;


    public ProductType(String name) {
        this.id = ++count;
        this.name = name;
    }

    public ProductType() {

    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ProductType.count = count;
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


    @Override
    public String toString() {
        return new StringJoiner(", ", "\t" + id + "\t", "")
                .add(name)
                .toString();
    }

    /**
     * 根据ID作为比较的标准
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return id == that.id;
    }

    /**
     * ID参与到哈希值的计算中
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
