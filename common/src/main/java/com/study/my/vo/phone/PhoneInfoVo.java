package com.study.my.vo.phone;

import lombok.Data;

import java.util.List;

/**
 * @author huangsenwei
 * @Description
 */
@Data
public class PhoneInfoVo {
    private String keyWordName;
    private List<String> keyword;
    private List<ModelInfo> modelList;
    private String brand;
    private List<String> model;
}
