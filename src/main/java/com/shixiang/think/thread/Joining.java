package com.shixiang.think.thread;

import java.util.concurrent.TimeUnit;

public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();

    }
}

class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int time) {
        super(name);
        this.duration = time;
        start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.MICROSECONDS.sleep(duration);
        } catch (InterruptedException e) {
            //异常被捕获时，清理中断标志，所以为false
            System.out.println(getName() + " is interrupted. isInterrupted(): " + isInterrupted());
            return;
        }
        //如果没有被中断，则完成sleep
        System.out.println(getName() + " is awakened");
    }
}

class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println(getName() + " is interrupted. isInterrupted(): " + isInterrupted());
        }
        //等待sleeper完成，然后执行
        System.out.println(getName() + " join completed");
    }
}
