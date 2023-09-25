package com.study.chainofresponsibilitypattern;

/**
 * @author huangsenwei
 * @Description
 */
public class PlaneCheck extends AbstractSubSendMessageCheck {

    @Override
    String checkImpl(String name) {
        System.out.println("plane is checking");

        return  name.equals("plane")? "plane" : null;
    }
}
