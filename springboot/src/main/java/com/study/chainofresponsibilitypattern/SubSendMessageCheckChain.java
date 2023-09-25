package com.study.chainofresponsibilitypattern;

/**
 * @author huangsenwei
 * @Description
 */
public class SubSendMessageCheckChain {
    public static void main(String[] args) {
        CarCheck carCheck = new CarCheck();
        PlaneCheck planeCheck = new PlaneCheck();
        ShipCheck shipCheck = new ShipCheck();

        carCheck.setNextCheck(planeCheck);
        planeCheck.setNextCheck(shipCheck);


        carCheck.doCheck(carCheck,"plane");
    }
}
