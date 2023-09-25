package com.comsumer.rocketmq;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author huangsenwei
 * @Description MessageListenerConcurrently接口设置消息重试
 */
public class RocketMqDancerConsumerConcurrentlyListener implements MessageListenerConcurrently {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

       return   ConsumeConcurrentlyStatus.RECONSUME_LATER;

    }
}
