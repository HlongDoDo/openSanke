package com.study.function.consumer.functionInterface;

/**
 * @author huangsenwei
 * @Description consumer 接口只进不出
 */
@FunctionalInterface
public interface TelMeSomethingConsumerFunction {

    void telMeThing(String anyYouSay);

}
