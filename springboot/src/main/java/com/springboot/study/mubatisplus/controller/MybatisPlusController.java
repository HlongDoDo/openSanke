package com.springboot.study.mubatisplus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangsenwei
 * @Description Mybatis训练入口类
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisPlusController {


    @RequestMapping("select")
    public String selectRecord(){


        return null;
    }

}
