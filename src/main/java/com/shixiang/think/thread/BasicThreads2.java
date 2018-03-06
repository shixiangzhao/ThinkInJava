package com.shixiang.think.thread;

public class BasicThreads2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new LiftOff(10)).start();
        }
        System.out.println("Waiting for LiftOff...");
    }
}
