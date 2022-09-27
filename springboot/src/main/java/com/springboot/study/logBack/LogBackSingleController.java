package com.springboot.study.logBack;

import com.study.my.outoutentity.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangsenwei
 * @Description logBackSingleController
 */
@Slf4j
@RestController
@RequestMapping("/logSingle")
public class LogBackSingleController {

    @RequestMapping("/logInfo")
    public ReturnData<Object> logInfo(){

        for (int i = 0; i < 10000; i++) {
            log.info("log.info is logging");
        }


        return ReturnData.success();
    }
}
