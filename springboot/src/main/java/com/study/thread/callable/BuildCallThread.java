package com.study.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author huangsenwei
 * @Description
 */
public class BuildCallThread implements Callable{


    public static void main(String[] args) throws Exception {
        //继承类的方式
        BuildCallThread buildCallThread = new BuildCallThread();
        System.out.println(buildCallThread.call());

        //算是隐式创建
        FutureTask<String> stringFutureTask = new FutureTask<>(() -> "task");
        new Thread(stringFutureTask).start();
        String s = stringFutureTask.get();
        System.out.println(s);
    }

    @Override
    public Object call() throws Exception {
        return "hello";
    }
}
