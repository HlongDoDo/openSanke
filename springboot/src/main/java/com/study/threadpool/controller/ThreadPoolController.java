package com.study.threadpool.controller;

import com.study.threadpool.client.DoClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author huangsenwei
 * @Description
 */
@RestController
@RequestMapping("/threadPool")
public class ThreadPoolController {

    @Resource
    DoClient doClient;

    @RequestMapping("/doThreadPool")
    public String doThreadPool() throws InterruptedException, ExecutionException {
        doClient.tryAsync();
        return "doThreadPool";
    }
}
