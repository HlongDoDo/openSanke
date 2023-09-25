package com.study.chainofresponsibilitypattern;

/**
 * @author huangsenwei
 * @Description
 */
public class ShipCheck extends AbstractSubSendMessageCheck {

    @Override
    String checkImpl(String name) {
        System.out.println("ship is checking");

        return  name.equals("ship")? "ship" : null;
    }

}
