package com.shixiang.think.thread;


public class BasicThread {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff(10));
        t.start();
        System.out.println("Waiting for LiftOff...");
    }
}
