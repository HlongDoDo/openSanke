package com.comsumer.controller;

import com.alibaba.fastjson.JSON;
import com.comsumer.client.OpenFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangsenwei
 * @Description
 */
@RestController
@RequestMapping("/consumer")
public class Controller {

    //得搭建了nacos才能使用FeignClient 现在用RestTemplate 试一下。
    @Autowired
    RestTemplate restTemplate;

    //使用feign调用服务
    @Autowired
    OpenFeignClient openFeignClient;

    @RequestMapping("/getRecord/{id}")
    public String consumerGetService(@PathVariable("id") int id){
//        JSON json = restTemplate.postForObject("http://127.0.0.1:8081/myController/doTry/id", null, JSON.class);
//        return json.toJSONString();

        String result = openFeignClient.consumerGetService(id);

        return result;

    }

}
