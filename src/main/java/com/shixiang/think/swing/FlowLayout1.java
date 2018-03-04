package com.shixiang.think.swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 简单的BorderLayout1
 * 
 * @author Shixiang
 *
 */
public class FlowLayout1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public FlowLayout1() {
		setLayout(new GridLayout(7,3));
		for(int i=0;i<20;i++) {
			add(new JButton("Button" + i));
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new FlowLayout1(), 300, 300);
	}
}
