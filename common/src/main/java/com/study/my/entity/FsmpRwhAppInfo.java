package com.study.my.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FsmpRwhAppInfo {
    private Integer id;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("app_order")
    private Integer appOrder;

    @ExcelProperty("logo_url")
    private String logoUrl;
    @ExcelProperty("gmt_create")
    private Date gmtCreate;
    @ExcelProperty("gmt_modified")
    private Date gmtModified;

    @ExcelProperty("state")
    private Integer state;

    @ExcelProperty("category_id")
    private Integer categoryId;

    @ExcelProperty("version_id")
    private String versionId;

    @ExcelProperty("gmt_create_user")
    private String gmtCreateUser;

    @ExcelProperty("gmt_modified_user")
    private String gmtModifiedUser;

    @ExcelProperty("logo_pic_attach_id")
    private String logoPicAttachId;

    @ExcelProperty("recommend_date")
    private Date recommendDate;

    @ExcelProperty("recommend_day")
    private Integer recommendDay;

    @ExcelProperty("prod_desc")
    private String prodDesc;

    @ExcelProperty("category_name")
    private String categoryName;

}