package com.springboot.study.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author huangsenwei
 * @Description 学习CyclicBarrier，多线程并发控制工具
 * 设一个循环拦截的值，累计特定的次数会触发指定方法，自己本方法才能往下执行。
 * 找不到合适的使用场景 不是分布式就是多线程的问题
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(5, () ->
                System.out.println("满人"));


        for (int i = 0; i < 20; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i = " + i);
            new Thread(() -> {
                try {
                    barrier.await();
                    System.out.println("篱笆推到了后才能执行这里代码");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
