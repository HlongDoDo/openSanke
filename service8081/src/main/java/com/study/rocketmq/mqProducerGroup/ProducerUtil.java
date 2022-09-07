package com.study.rocketmq.mqProducerGroup;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author huangsenwei
 * @Description
 */
@Component
public class ProducerUtil {

    public byte[] toMessageBody(Object body){
        String jsonString = JSON.toJSONString(body);
        return jsonString.getBytes(StandardCharsets.UTF_8);
    }
}
