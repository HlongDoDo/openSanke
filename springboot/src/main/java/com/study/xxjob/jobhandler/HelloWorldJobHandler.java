package com.study.xxjob.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author huangsenwei
 * @Description xx-job定时任务
 */
@Slf4j
@Component
public class HelloWorldJobHandler {

    @XxlJob("xxlJobTest")
    public ReturnT<String> xxlJobTest(String date) {
        log.info("---------xxlJobTest定时任务执行成功--------");
        return ReturnT.SUCCESS;
    }
}
