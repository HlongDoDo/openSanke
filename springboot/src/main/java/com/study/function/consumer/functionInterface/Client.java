package com.study.function.consumer.functionInterface;

/**
 * @author huangsenwei
 * @Description
 */
public class Client {
    public static void main(String[] args) {

        TelMeSomethingConsumerFunction telMeSomethingConsumerFunction = System.out::println;

        telMeSomethingConsumerFunction.telMeThing("what is you");
    }
}
