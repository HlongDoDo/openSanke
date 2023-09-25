package com.study.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author huangsenwei
 * @Description 学习CyclicBarrier，多线程并发控制工具
 * 设一个循环拦截的值，累计特定的次数会触发指定方法，自己本方法才能往下执行。
 * 找不到合适的使用场景 不是分布式就是多线程的问题
 * <p>
 * 场景：可以适配组队的需求。准备好了就执行 barrier.await();等人数够了就把他们的信息绑定
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("满人");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        for (int i = 0; i < 20; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("i = " + i);
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("执行完了");
                }
            }).start();

        }
    }
}
