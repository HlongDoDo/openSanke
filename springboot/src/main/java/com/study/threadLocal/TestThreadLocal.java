package com.study.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @author huangsenwei
 * @Description
 */
public class TestThreadLocal {

    private static   ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("我是主线程");

        Thread[] threads = new Thread[3];
        initThread(threads);
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println(threadLocal.get());
        }

    }

    private static void initThread(Thread[] threads) {
        threads[0] = new Thread(()->{
            threadLocal.set("线程0");
            System.out.println(Thread.currentThread().getId() + "设置线程0");

            System.out.println(Thread.currentThread().getId() +"get方法 " +  threadLocal.get());

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threads[1] = new Thread(()->{

            threadLocal.set("线程1");
            System.out.println(Thread.currentThread().getId() + "设置线程1");
            threadLocal.remove();
            System.out.println(Thread.currentThread().getId() +"get方法 " +  threadLocal.get());

        });

        threads[2] = new Thread(()->{
            threadLocal.set("线程2");

            System.out.println(Thread.currentThread().getId() + "设置线程2");
            System.out.println(Thread.currentThread().getId() +"get方法 " +  threadLocal.get());

        });
    }

}
