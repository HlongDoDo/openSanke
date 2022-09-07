package com.study.rocketmq.mqProducerGroup;

import com.study.rocketmq.entity.DancerInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;


/**
 * @author huangsenwei
 * @Description 舞者群组生产者
 */
@Slf4j
@Component
public class ProducerGpDancer {

    @Value("${rocketMq.producerDancer.group}")
    private String dancerGroupName;

    @Value("${rocketMq.producerDancer.topic}")
    private String topic;

    @Value("${rocketMq.nameSrvAdress}")
    private String nameSrvAddress;

    @Value("${rocketMq.producerDancer.timeOut}")
    private int dancerProducerSendTimeOut;

    @Resource
    ProducerUtil producerUtil;

    public void sendSyncMessage(DancerInfo dancerInfo) throws Exception {
        DefaultMQProducer dancerProduct = new DefaultMQProducer(dancerGroupName);
        dancerProduct.setNamesrvAddr(nameSrvAddress);
        dancerProduct.start();
        Message message = new Message(topic, producerUtil.toMessageBody(dancerInfo));
        log.info("ProducerGpDancer sendSyncMessage message={}",message);
        SendResult sendResult = dancerProduct.send(message, dancerProducerSendTimeOut);
        log.info("ProducerGpDancer sendSyncMessage sendResult={}",sendResult);
        dancerProduct.shutdown();
    }

}
