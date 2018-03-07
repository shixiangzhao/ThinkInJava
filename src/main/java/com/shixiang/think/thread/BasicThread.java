package com.shixiang.think.thread;

import java.util.concurrent.ConcurrentHashMap;

public class BasicThread {
    
    private static ConcurrentHashMap hm;

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff(10));
        t.start();
        System.out.println("Waiting for LiftOff...");
    }
}
