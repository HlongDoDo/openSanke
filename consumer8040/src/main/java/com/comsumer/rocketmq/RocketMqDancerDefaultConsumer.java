package com.comsumer.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.AllocateMessageQueueStrategy;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragelyByCircle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * @author huangsenwei
 * @Description 舞者消费者监听类
 */
@Slf4j
//@Service
public class RocketMqDancerDefaultConsumer {
    @Value("${rocketmq.consumer.topic}")
    private String topic;

    @Value("${rocketmq.name-server}")
    private String nameSrvAddress;

    private static final DefaultMQPushConsumer CONSUMER = new DefaultMQPushConsumer("dancerConsumerGroup");

    @PostConstruct
    public void consumerDancerMessage() throws Exception {
        CONSUMER.setNamesrvAddr(nameSrvAddress);
        CONSUMER.subscribe(topic, "*");
        CONSUMER.setAllocateMessageQueueStrategy(new  AllocateMessageQueueAveragelyByCircle());
        CONSUMER.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            String msgbody ;
            try {
                msgbody = new String(msgs.get(0).getBody(), StandardCharsets.UTF_8);
                log.info("DancerConsumer msg={}", msgs);
                log.info("DancerConsumer mgbody={}", msgbody);
            } catch (Exception e) {
                log.error("DancerConsumer error", e);
                //标记消费失败，等待重试
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

            // 标记该消息已经被成功消费
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        CONSUMER.start();
    }

}


