package com.study.chainofresponsibilitypattern;

/**
 * @author huangsenwei
 * @Description
 */
public class CarCheck extends AbstractSubSendMessageCheck {

    @Override
    String checkImpl(String name) {
        System.out.println("car is checking");
        return  name.equals("car")? "car" : null;
    }
}
