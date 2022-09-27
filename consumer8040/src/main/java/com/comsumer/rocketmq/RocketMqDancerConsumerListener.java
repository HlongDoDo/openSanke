package com.comsumer.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author huangsenwei
 * @Description 舞者消费者监听类
 */
//注册成bean+监听配置
//@Service
//@RocketMQMessageListener(consumerGroup = "dancerConsumerGroup", topic = "dancerTopic")
public class RocketMqDancerConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("消费消息：" + s);
    }
}


