package com.shixiang.think.thread;

public class SelfManaged implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }

    private Thread t = new Thread(this);
    private int countDown = 5;

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0)
                return;
        }

    }
}
