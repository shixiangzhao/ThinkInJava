package com.shixiang.think.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的BorderLayout1
 * 
 * @author Shixiang
 *
 */
public class BorderLayout1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public BorderLayout1() {
		add(BorderLayout.CENTER, new JButton("Center"));
		add(BorderLayout.NORTH, new JButton("North"));
		add(BorderLayout.EAST, new JButton("East"));
		add(BorderLayout.WEST, new JButton("West"));
		add(BorderLayout.SOUTH, new JButton("South"));
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new BorderLayout1(), 500, 300);
	}
}
