package com.study.thread.threadpool;

import com.study.thread.callable.BuildCallThread;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangsenwei
 * @Description
 */
public class ThreadPoolClient {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executorOne = new ThreadPoolExecutor(5, 5, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(20), new CustomizableThreadFactory("Tianluo-Thread-pool"));
        for (int i = 0; i < 10; i++) {
            executorOne.execute(() -> System.out.println("关注公众号：捡田螺的小男孩"));
            System.out.println(executorOne.submit(new BuildCallThread()).get());
        }

        //关闭线程池
        executorOne.shutdown();
    }
}
