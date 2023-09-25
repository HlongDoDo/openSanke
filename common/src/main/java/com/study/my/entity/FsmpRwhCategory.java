package com.study.my.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class FsmpRwhCategory {

    private Integer id;

    @ExcelProperty("category")
    private String category;

    @ExcelProperty("show_name")
    private String showName;

    @ExcelProperty("location_name")
    private String locationName;

    @ExcelProperty("category_order")
    private Integer categoryOrder;

    @ExcelProperty("gmt_create")
    private Date gmtCreate;

    @ExcelProperty("gmt_modified")
    private Date gmtModified;

    @ExcelProperty("state")
    private Integer state;

    @ExcelProperty("introduction")
    private String introduction;

    @ExcelProperty("version_id")
    private String versionId;

    @ExcelProperty("gmt_create_user")
    private String gmtCreateUser;

    @ExcelProperty("gmt_modified_user")
    private String gmtModifiedUser;
}