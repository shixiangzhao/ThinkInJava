package com.shixiang.think.thread;

public class LiftOff implements Runnable {

    int countDown = 10; //Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {}

    public LiftOff(int cutDown) {
        this.countDown = cutDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LeftOff") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            //告诉其他线程，我的主任务已经完成，现在是交出CPU的最佳时机。加了之后，会有一定的顺序。比如循环，会一层循环一层的遍历。
            Thread.yield();
        }
    }

}
