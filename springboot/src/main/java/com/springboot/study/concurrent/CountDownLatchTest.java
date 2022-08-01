package com.springboot.study.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangsenwei
 * @Description 学习CountDownLatch 多线程并发控制工具
 *  设一个阻塞值，只有到了这个值，下后面的代码才会执行后结束。
 *  不适用分布式的写法。
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getId() + " j = " + j);
                }
                //累加，至到达到初始化的值
                countDownLatch.countDown();
            });
        }


        for (Thread thread : threads) {
            thread.start();
        }

        //表明要到100才能执行下面的语句
        countDownLatch.await();

        System.out.println("------执行完了---------");
    }

}
