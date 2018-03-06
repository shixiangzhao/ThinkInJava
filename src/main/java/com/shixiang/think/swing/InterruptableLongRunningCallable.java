package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的LongRunningTask
 * 
 * @author Shixiang
 */
public class InterruptableLongRunningCallable extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton b1 = new JButton("开始同步");
    private JButton b2 = new JButton("取消同步");
    private JButton b3 = new JButton("同步结果");
    private TaskManager<String, CallableTask> manager = new TaskManager<String, CallableTask>();

    public InterruptableLongRunningCallable() {
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CallableTask task = new CallableTask();
                manager.add(task);
                System.out.println(task + " added to the queue");
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (String result : manager.purge())
                    System.out.println(result);
            }
        });
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (TaskItem<String, CallableTask> tt : manager)
                    tt.task.getId();
                for (String result : manager.getResults())
                    System.out.println(result);
            }
        });
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new InterruptableLongRunningCallable(), 200, 150);
    }
}

class CallableTask extends Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        run();
        return "Return value of " + this;
    }
}
