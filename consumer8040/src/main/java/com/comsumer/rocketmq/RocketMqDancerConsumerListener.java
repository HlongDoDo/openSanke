package com.comsumer.rocketmq;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author huangsenwei
 * @Description 舞者消费者监听类
 *
 * 如果抛异常会似的消息重消费
 */
//注册成bean+监听配置
@Service
@RocketMQMessageListener(consumerGroup = "dancerConsumerGroup", topic = "dancerTopic")
public class RocketMqDancerConsumerListener implements RocketMQListener<String> {

    @SneakyThrows
    @Override
    public void onMessage(String s) {
        System.out.println("消费消息：" + s);

        System.out.println("55555\"\" = " + 55555);
        throw new RuntimeException("哈哈");
    }



}


