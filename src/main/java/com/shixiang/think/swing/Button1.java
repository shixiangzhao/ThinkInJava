package com.shixiang.think.swing;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * 简单的Button
 * 
 * @author Shixiang
 *
 */
public class Button1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private Button b1 = new Button("Button1"), 
			b2 = new Button("Button2");

	Button1() {
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new Button1(), 500, 300);
	}
}
