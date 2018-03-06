package com.shixiang.think.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可以保证一个线程一个线程的顺序执行。
 * 多用于文件系统的读写，可以让你省去为了维持某些事物的原型而进行的更重协调努力。
 * @author shixiang.zhao
 *
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            es.execute(new LiftOff(10));
        }
        es.shutdown();
    }
}
