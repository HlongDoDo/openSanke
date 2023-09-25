package com.study.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * @author huangsenwei
 * @Description 学生实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Excel(name = "序号", orderNum = "0")
    private Integer id;
    @Excel(name = "姓名", orderNum = "1")
    private String name;
    /**
     * 照片,type=2 将excel列的内容设置图片 ，默认type=1
     */
    @Excel(name = "照片", width = 20, type = 2, savePath = "D:\\img")
    private String foodImg;
}
