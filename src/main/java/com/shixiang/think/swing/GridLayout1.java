package com.shixiang.think.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的BorderLayout1
 * 
 * @author Shixiang
 *
 */
public class GridLayout1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public GridLayout1() {
		setLayout(new FlowLayout());
		for(int i=0;i<10;i++) {
			add(new JButton("Button" + i));
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new GridLayout1(), 300, 300);
	}
}
