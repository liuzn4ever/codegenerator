package com.lzn.mybatisplus.codegenerator.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据库表名 test_code_product
 *
 * @author liuzhinan
 * @date 2020-07-17
 */
@Getter
@Setter
@ToString
public class CodeProduct  {

    /**
     * 数据库字段名 id 类型 bigint(20)
     */
    private Long  id;

    /**
     * 数据库字段名 create_date 类型 datetime
     */
    private Date  createDate;

    /**
     * 数据库字段名 modify_date 类型 datetime
     */
    private Date  modifyDate;

    /**
     * 数据库字段名 name 类型 varchar(100)
     */
    private String  name;

    /**
     * 数据库字段名 mobile 类型 varchar(13)
     */
    private String  mobile;

    /**
     * 数据库字段名 bulid_date 类型 datetime
     */
    private Date  bulidDate;

    /**
     * 数据库字段名 company_name 类型 varchar(255)
     */
    private String  companyName;

    /**
     * 数据库字段名 shop_goods 类型 varchar(255)
     */
    private String  shopGoods;

    /**
     * 数据库字段名 other_info 类型 varchar(500)
     */
    private String  otherInfo;

    /**
     * 数据库字段名 status 类型 int(2)
     */
    private Integer  status;

    /**
     * 数据库字段名 operator 类型 varchar(50)
     */
    private String  operator;


}