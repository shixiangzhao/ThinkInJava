package com.shixiang.think.swing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 简单的TaskManager
 * 
 * @author Shixiang
 */
public class TaskManager<R, C extends Callable<R>> extends ArrayList<TaskItem<R, C>> {

    private static final long serialVersionUID = 1L;
    private ExecutorService exec = Executors.newSingleThreadExecutor();

    public void add(C task) {
        add(new TaskItem<R, C>(exec.submit(task), task));
    }

    public List<R> getResults() {
        Iterator<TaskItem<R, C>> items = iterator();
        List<R> results = new ArrayList<R>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (item.future.isDone()) {
                try {
                    results.add(item.future.get());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                items.remove();
            }
        }
        return results;
    }

    public List<String> purge() {
        Iterator<TaskItem<R, C>> items = iterator();
        List<String> results = new ArrayList<String>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (!item.future.isDone()) {
                results.add("Canceling " + item.task);
                item.future.cancel(true);
                items.remove();
            }
        }
        return results;
    }
}
