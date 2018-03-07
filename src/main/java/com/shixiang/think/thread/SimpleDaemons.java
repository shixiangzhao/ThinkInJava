package com.shixiang.think.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

    private int count;

    public SimpleDaemons(int count) {
        this.count = count;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons(i));
            //必须start()之前setDaemon
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All Daemons started");
        TimeUnit.MICROSECONDS.sleep(175);
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this + " " + count++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
