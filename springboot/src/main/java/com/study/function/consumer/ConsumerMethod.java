package com.study.function.consumer;

import com.study.easypoi.entity.Student;

import java.util.function.Consumer;

/**
 * @author huangsenwei
 * @Description consumer
 */
public class ConsumerMethod {

    public void doConsumerSout(Consumer<String> consumer){
        System.out.println("mu ban before");
        consumer.accept(null);
        System.out.println("mu ban after");
    }

    public void doConsumerChangeValue(Consumer<Student> consumer){
        System.out.println("mu ban before");
        consumer.accept(null);
        System.out.println("mu ban after");
    }
}
