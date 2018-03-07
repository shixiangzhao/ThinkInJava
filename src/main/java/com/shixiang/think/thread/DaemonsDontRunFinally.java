package com.shixiang.think.thread;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.MICROSECONDS.sleep(1000);
    }
}

class ADaemon implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Starting ADaemon");
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This should be always run?");
        }
    }
}
