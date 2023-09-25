package com.study.my.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FsmpRwhIopProdInfo {
    private Long id;

    @ExcelProperty("iop_code")
    private String iopCode;

    @ExcelProperty("iop_name")
    private String iopName;

    @ExcelProperty("prod_id")
    private String prodId;

    @ExcelProperty("gmt_create")
    private Date gmtCreate;

    @ExcelProperty("gmt_modified")
    private Date gmtModified;

    @ExcelProperty("state")
    private Integer state;

    @ExcelProperty("match_order")
    private Integer matchOrder;

    @ExcelProperty("version_id")
    private String versionId;

    @ExcelProperty("gmt_create_user")
    private String gmtCreateUser;

    @ExcelProperty("gmt_modified_user")
    private String gmtModifiedUser;

}