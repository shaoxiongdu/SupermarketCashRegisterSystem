
<html>
    <center>
    <h1 id="title">超市收银管理系统</h1>
    <h3><a href="https://shaoxiongdu.github.io/SupermarketCashRegisterSystem/#/" target="_blank">在线站点</a></h3>
    <img src="https://img.shields.io/badge/超市收银-管理系统-blue"/>
    <img src="https://img.shields.io/badge/收银-模块-blue"/>
    <img src="https://img.shields.io/badge/商品管理-模块-yellow"/>
    <img src="https://img.shields.io/badge/商品类型管理-模块-purple"/>
    <img src="https://img.shields.io/badge/收银员管理-模块-green"/>
    <img src="https://img.shields.io/badge/日志管理-模块-orange"/>
</center>
</html>

## 一、模块架构图

![收银管理系统](https://gitee.com/ShaoxiongDu/imageBed/raw/master/%E6%94%B6%E9%93%B6%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F.png)

## 二、系统设计图

![超市收银系统分析图](https://gitee.com/ShaoxiongDu/imageBed/raw/master/%E8%B6%85%E5%B8%82%E6%94%B6%E9%93%B6%E7%B3%BB%E7%BB%9F%E5%88%86%E6%9E%90%E5%9B%BE.png)

[系统设计图在线地址](http://assets.processon.com/chart_image/613ff3df7d9c081bd8011e4b.png)

## 三、实体属性表

### 3.1、收银员 Cashier

| 属性名称    | 类型   | 备注     |
| ----------- | ------ | -------- |
| id          | String | 收银员ID |
| account     | String | 账号     |
| password    | String | 密码     |
| name        | String | 姓名     |
| sex         | char   | 性别     |
| age         | int    | 年龄     |
| address     | String | 家庭地址 |
| phoneNumber | String | 手机号   |

### 3.2、产品 Product

| 属性名称 | 类型   | 备注       |
| -------- | ------ | ---------- |
| id       | String | 产品编号   |
| name     | String | 产品名称   |
| price    | double | 价格       |
| typeId   | String | 所属类别ID |

#### 3.3、商品类别type

| 属性名称 | 类型   | 备注         |
| -------- | ------ | ------------ |
| id       | String | 产品类别编号 |
| name     | String | 产品类别名称 |

### 3.4、订单 order

| 属性名称   | 类型                 | 备注                                   |
| ---------- | -------------------- | -------------------------------------- |
| id         | String               | 订单号                                 |
| cashierId  | String               | 收银员ID                               |
| product    | Map<productId,count> | 产品列表 map中key为产品ID，value为数量 |
| totalPrice | double               | 总价                                   |
| date       | DateTime             | 收银日期                               |

### 3.5、日志 Log

| 属性名称    | 类型     | 备注                        |
| ----------- | -------- | --------------------------- |
| id          | String   | 日志编号                    |
| title       | String   | 日志概要                    |
| description | String   | 日志详情                    |
| datetime    | DateTime | 记录时间                    |
| success     | boolean  | 是否成功                    |
| logType     | int      | 对应各种类型的日志 方便管理 |

## 四、开源许可证

在 MIT 许可下分发。有关更多信息，请参阅[`LICENSE`](LICENSE)。
