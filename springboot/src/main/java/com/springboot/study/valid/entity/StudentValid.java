package com.springboot.study.valid.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;


/**
 * @author huangsenwei
 * @Description
 */
@Data
@ToString
public class StudentValid {

    /**
     * 学号
     */
    @NotNull(message = "学号不能为空!")
    private String id;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为空!")
    private String name;

    /**
     * 性别
     */
    @Pattern(regexp = "^[男|女]$", message = "性别输入有误")
    @NotNull(message = "性别不能为空!")
    private String gender;

    /**
     * 是否戴眼镜
     */
    @NotNull(message = "眼镜不能为空!")
    private Boolean glasses;

    /**
     * 年龄
     */
    @Pattern(regexp = "^(([0-9]|[1-9][1-9]|1[0-4][0-9])(\\.[0-9]+)?|180)$", message = "年龄不对")
    @NotNull(message = "年龄不能为空!")
    private String age;

    /**
     * 手机号码
     */
    @NotNull(message = "手机号码不能为空!")
    private String msisdn;

}
