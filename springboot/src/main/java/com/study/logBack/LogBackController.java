package com.study.logBack;

import com.study.my.mapper.FsmpRwhCategoryMapper;
import com.study.my.outoutentity.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangsenwei
 * @Description logBackController
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogBackController {

    @Resource
    FsmpRwhCategoryMapper mapper;

    @RequestMapping("/logInfo")
    public ReturnData<Object> logInfo(){

        for (int i = 0; i < 10000; i++) {
            log.info("log.info is logging");
        }
        System.out.println(mapper.selectByPrimaryKey(1));
        return ReturnData.success();
    }

}
