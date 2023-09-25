package com.study.threadpool.client;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author huangsenwei
 * @Description
 */
@Service
public class DoClient {

    @Qualifier("taskExecutor")
    @Resource
    ThreadPoolTaskExecutor taskExecutor;


    public void tryAsync() throws InterruptedException, ExecutionException {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        ArrayList<Future<String>> strings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            strings.add(taskExecutor.submit(() -> this.doRun(countDownLatch)));
        }
        countDownLatch.await();
        System.out.println("执行到最后");
        for (Future<String> result : strings) {
            System.out.println(JSON.toJSONString(result.get()));
        }
    }

    private String  doRun(CountDownLatch countDownLatch ) throws InterruptedException {
        System.out.println("异步执行任务中");
        TimeUnit.SECONDS.sleep(1);
        countDownLatch.countDown();
        return String.valueOf(countDownLatch.getCount());
    }

}
