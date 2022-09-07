package com.study.my.customizeexception;


import com.study.my.outoutentity.stateenum.OutState;

/**
 * @author huangsenwei
 * @Description 通用异常
 */
public class CommonException extends Exception {

    private OutState state;

    public CommonException(OutState state) {
        this.state = state;
    }

    public OutState getState() {
        return state;
    }
}
