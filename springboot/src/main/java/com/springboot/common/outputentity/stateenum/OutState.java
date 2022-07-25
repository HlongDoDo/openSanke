package com.springboot.common.outputentity.stateenum;

/**
 * @author huangsenwei
 * @Description 输出状态码枚举类
 */
public enum OutState {

    /**
     * 成功
     */
    STATE_OK("0000", "成功"),

    /**
     * 错误
     */
    STATE_FAIL("4001", "系统繁忙，请稍后再试");

    /**
     * 状态码
     */
    final String code;

    /**
     * 信息
     */
    final String mes;

    OutState(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }


    public String getCode() {
        return code;
    }

    public String getMes() {
        return mes;
    }


    @Override
    public String toString() {
        return "OutState{" +
                "code='" + code + '\'' +
                ", mes='" + mes + '\'' +
                '}';
    }
}
