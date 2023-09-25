package com.study.thread.runable;

/**
 * @author huangsenwei
 * @Description 显示lamb
 */
public class CarThread implements Runnable {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("car is running");
        }).start();
    }

    @Override
    public void run() {
        System.out.println("car is running");
    }
}
