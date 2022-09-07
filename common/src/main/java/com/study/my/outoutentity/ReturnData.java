package com.study.my.outoutentity;

import com.study.my.customizeexception.CommonException;
import com.study.my.outoutentity.stateenum.OutState;
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

    public static  ReturnData<Object> fail(CommonException e) {
        return  new ReturnData<>(e.getState());
    }

    public static  ReturnData<Object> success() {
        return  new ReturnData<>(OutState.STATE_OK);
    }

}
