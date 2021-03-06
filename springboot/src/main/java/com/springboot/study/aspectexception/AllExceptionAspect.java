package com.springboot.study.aspectexception;

import com.alibaba.fastjson.JSONObject;
import com.springboot.common.outputentity.ReturnData;
import com.springboot.common.outputentity.stateenum.OutState;
import com.springboot.study.aspectexception.customizeexception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangsenwei
 * @Description 全局统一异常处理
 */
@ControllerAdvice
@Slf4j
public class AllExceptionAspect {

    /**
     * 处理系统异常
     *
     * @param exception 系统异常
     * @return WebResult 自定义返回集合
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ReturnData exception(Exception exception) {
        log.error("出现异常",exception);
        ReturnData<Object> returnData = new ReturnData<>();
        returnData.setCode(OutState.STATE_FAIL.getCode());
        returnData.setMes(exception.getMessage());
        return returnData;
    }


    /**
     * 处理自定义异常
     *
     * @param exception 系统异常
     * @return WebResult 自定义返回集合
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public ReturnData exception(CommonException exception) {
        log.error("出现异常",exception);
       return ReturnData.fail(exception);
    }
}
