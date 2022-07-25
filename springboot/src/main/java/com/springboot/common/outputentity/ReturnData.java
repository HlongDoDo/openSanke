package com.springboot.common.outputentity;

import com.springboot.common.outputentity.stateenum.OutState;
import com.springboot.study.aspectexception.customizeexception.CommonException;
import lombok.Data;

/**
 * @author huangsenwei
 * @Description 通用返回实体类
 */
@Data
public class ReturnData<T> {
    private String code;
    private String mes;
    private T data;

    public ReturnData(OutState state){
        this.code = state.getCode();
        this.mes = state.getMes();
    }

    public ReturnData(OutState state,T data){
        this.code = state.getCode();
        this.mes = state.getMes();
        this.data = data;
    }


    public ReturnData() {
    }

    public void setState(OutState state){
        this.code = state.getCode();
        this.mes = state.getMes();
    }

    public static  ReturnData fail(CommonException e) {
        return  new ReturnData<>(e.getState());
    }

    public static  ReturnData success() {
        return  new ReturnData<>(OutState.STATE_OK);
    }

}
