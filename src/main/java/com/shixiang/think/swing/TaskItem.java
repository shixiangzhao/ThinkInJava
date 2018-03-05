package com.shixiang.think.swing;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 简单的TaskItem
 * 
 * @author Shixiang
 */
public class TaskItem<R, C extends Callable<R>> {

    public final Future<R> future;
    public final C task;

    public TaskItem(Future<R> future, C task) {
        this.future = future;
        this.task = task;
    }
}
