package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的LongRunningTask
 * 
 * @author Shixiang
 */
public class LongRunningInterableTask extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton b1 = new JButton("Start Long Running Task");
    private JButton b2 = new JButton("End Long Running Task");
    private ExecutorService es = Executors.newSingleThreadExecutor();

    public LongRunningInterableTask() {
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task();
                es.execute(task);
                System.out.println(task + " added to the queue");
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                es.shutdownNow(); // Heavy-handed
            }
        });
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new LongRunningInterableTask(), 200, 150);
    }
}

class Task implements Runnable {

    private static int counter = 0;
    private final int id = counter++;

    @Override
    public void run() {
        System.out.println(this + " started");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
            return;
        }
        System.out.println(this + " completed");
    }

    public String toString() {
        return "Task " + id;
    }

    public long getId() {
        return id;
    }
}
