package com.study.my.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FsmpRwhExchangeProdInfo {
    private Long id;

    @ExcelProperty("prod_id")
    private String prodId;

    @ExcelProperty("app_name")
    private String appName;

    @ExcelProperty("prod_name")
    private String prodName;

    @ExcelProperty("category")
    private String category;

    @ExcelProperty("location_name")
    private String locationName;

    @ExcelProperty("preference_tip")
    private String preferenceTip;

    @ExcelProperty("price")
    private Integer price;

    @ExcelProperty("exchange_limit")
    private Integer exchangeLimit;

    @ExcelProperty("state")
    private Integer state;

    @ExcelProperty("order")
    private Integer order;

    @ExcelProperty("logo_url")
    private String logoUrl;

    @ExcelProperty("gmt_create")
    private Date gmtCreate;

    @ExcelProperty("gmt_modified")
    private Date gmtModified;

    @ExcelProperty("preference")
    private Integer preference;

    @ExcelProperty("preference_url")
    private String preferenceUrl;

    @ExcelProperty("boss_code")
    private String bossCode;

    @ExcelProperty("app_id")
    private Integer appId;

    @ExcelProperty("prod_code")
    private String prodCode;

    @ExcelProperty("show_iop_code")
    private String showIopCode;

    @ExcelProperty("version_id")
    private String versionId;

    @ExcelProperty("gmt_create_user")
    private String gmtCreateUser;

    @ExcelProperty("gmt_modified_user")
    private String gmtModifiedUser;

    @ExcelProperty("member_price")
    private Integer memberPrice;

    @ExcelProperty("member_prod_id")
    private String memberProdId;

    @ExcelProperty("member_boss_code")
    private String memberBossCode;

    @ExcelProperty("member_prod_code")
    private String memberProdCode;

    @ExcelProperty("rule")
    private String rule;

    @ExcelProperty("member_type")
    private String memberType;

}