package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的LongRunningTask
 * 
 * @author Shixiang
 *
 */
public class LongRunningTask extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton b1 = new JButton("Start Long Running Task");
    private JButton b2 = new JButton("End Long Running Task");
    

	public LongRunningTask() {
	    b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println("Task completed");
            }
	    });
	    b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread.currentThread().interrupt();
            }
	    });
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new LongRunningTask(), 200, 150);
	}
}
