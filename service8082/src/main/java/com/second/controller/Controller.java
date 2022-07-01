package com.second.controller;

import com.second.service.MyService;
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
public class Controller {
    @Autowired
    MyService myService;

    @RequestMapping("/getRecord/{id}")
    public String getRecord(@PathVariable("id") Integer id){
        return myService.search(id);
    }

    @RequestMapping("/dododo")
    public String trydo(){
        return "456";
    }
}
