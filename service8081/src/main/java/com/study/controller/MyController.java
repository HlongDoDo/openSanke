package com.study.controller;

import com.study.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangsenwei
 * @Description
 */
@RestController
@RequestMapping("/service")
public class MyController {

    @Autowired
    MyService myService;

    @RequestMapping("/getRecord/{id}")
    public String getRecord(@PathVariable("id") Integer id){
        return myService.search(id);
    }
}
