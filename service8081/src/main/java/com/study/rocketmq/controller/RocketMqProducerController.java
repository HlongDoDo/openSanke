package com.study.rocketmq.controller;

import com.study.my.outoutentity.ReturnData;
import com.study.my.outoutentity.stateenum.OutState;
import com.study.rocketmq.entity.DancerInfo;
import com.study.rocketmq.mqProducerGroup.ProducerGpDancer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangsenwei
 * @Description mq方法入口类
 */
@RestController
@RequestMapping("/rocketMqProducerController")
public class RocketMqProducerController {

    @Resource
    ProducerGpDancer producerGpDancer;

    @RequestMapping("/sendSyncMessage")
    public ReturnData<Object> sendSyncMessage(@RequestBody DancerInfo dancerInfo) throws Exception {
        producerGpDancer.sendSyncMessage(dancerInfo);
        return ReturnData.success();
    }
}
