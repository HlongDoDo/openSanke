package com.study.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.PrimitiveIterator;

/**
 * @author huangsenwei
 * @Description
 */
@Data
public class MarketingFront {
    @Excel(name = "prodCode", orderNum = "0")
    private String prodCode;
    @Excel(name = "prodId", orderNum = "1")
    private String prodId;
}
