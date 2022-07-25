package com.springboot.study.aspectexception.customizeexception;

import com.alibaba.fastjson.JSON;
import com.springboot.common.outputentity.stateenum.OutState;

/**
 * @author huangsenwei
 * @Description 算数异常
 */
public class CommonException extends Exception {

    private final OutState state;

    public CommonException(OutState state) {
        this.state = state;
    }

    public OutState getState() {
        return state;
    }
}
