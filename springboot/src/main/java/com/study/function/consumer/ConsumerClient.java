package com.study.function.consumer;


import com.alibaba.fastjson.JSON;
import com.study.easypoi.entity.Student;

/**
 * @author huangsenwei
 * @Description
 */
public class ConsumerClient {

    public static void main(String[] args) {

        ConsumerMethod consumerMethod = new ConsumerMethod();
        consumerMethod.doConsumerSout(x-> System.out.println("ConsumerClient do method"));


        Student student = new Student(11, "男孩","no");
        consumerMethod.doConsumerChangeValue(x -> student.setName("女孩"));

        System.out.println(JSON.toJSONString(student));

    }
}
