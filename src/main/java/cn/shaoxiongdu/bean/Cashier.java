/*
 * Copyright (c) 2021. 杜少雄 AllRightsReserved
 */

package cn.shaoxiongdu.bean;

import com.apifan.common.random.source.AreaSource;
import com.apifan.common.random.source.NumberSource;
import com.apifan.common.random.source.PersonInfoSource;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @作者: 杜少雄 <email@shaoxiongdu.cn>
 * @日期: 2021年09月13日 | 10:37
 * @描述: 收银员实体类
 */
public class Cashier {

    private static PersonInfoSource personInfoSource = PersonInfoSource.getInstance();

    private static AreaSource areaSource = AreaSource.getInstance();

    //累加ID器
    private static int count = 0;

    /**
     * id
     */
    private int id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 手机号
     */
    private String phoneNumber;

    public Cashier(String account, String password, String name, String sex, Integer age, String address, String phoneNumber) {
        this.id = ++count;
        this.account = account;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Cashier() {
        this.id = ++count;
    }

    /**
     * 返回随机实例
     *
     * @return
     */
    public static Cashier getRandom() {
        Cashier user = new Cashier();
        //随机生成姓名
        user.name = personInfoSource.randomChineseName();
        //随机生成性别
        user.sex = personInfoSource.randomGender() == 1 ? "男" : "女";
        user.address = areaSource.randomAddress();
        user.phoneNumber = personInfoSource.randomChineseMobile();
        //随机年龄
        user.age = NumberSource.getInstance().randomInt(10, 80);
        //随即账号
        user.account = personInfoSource.randomQQAccount();
        //随机密码
        user.password = personInfoSource.randomStrongPassword(8, false);
        return user;
    }

    public static PersonInfoSource getPersonInfoSource() {
        return personInfoSource;
    }

    public static void setPersonInfoSource(PersonInfoSource personInfoSource) {
        Cashier.personInfoSource = personInfoSource;
    }

    public static AreaSource getAreaSource() {
        return areaSource;
    }

    public static void setAreaSource(AreaSource areaSource) {
        Cashier.areaSource = areaSource;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Cashier.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner("\t\t", "\t" + id + "\t", "")
                .add(account)
                .add(password)
                .add(sex + "")
                .add(age + "岁")
                .add(name)
                .add(phoneNumber)
                .add(address)

                .toString();
    }

    /**
     * 根据ID判断equals
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return id == cashier.id;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
