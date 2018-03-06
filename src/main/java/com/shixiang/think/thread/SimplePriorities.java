package com.shixiang.think.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {

	private int countDown = 5;
	private volatile double d;
	private int priority;

	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			// 因为CPU提升，运算量不大达不到书中的效果。
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			es.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		es.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		es.shutdown();
	}
}
