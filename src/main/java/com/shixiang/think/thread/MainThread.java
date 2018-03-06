package com.shixiang.think.thread;


public class MainThread {

    public static void main(String[] args) {
        LiftOff leftOff = new LiftOff(10);
        leftOff.run();
    }
}
