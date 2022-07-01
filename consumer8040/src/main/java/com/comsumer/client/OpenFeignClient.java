package com.comsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangsenwei
 * @Description
 */
@FeignClient(name = "service8081")
public interface OpenFeignClient {

    @ResponseBody
    @RequestMapping(value = "/service//getRecord/{id}",produces = "application/json;charset=UTF-8")
    String consumerGetService(@PathVariable("id") int id);
}
