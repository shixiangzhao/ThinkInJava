package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 简单的Button，监听事件
 * 
 * @author Shixiang
 *
 */
public class Button2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton 
	b1 = new JButton("Button1"), 
	b2 = new JButton("Button2");

	private JTextField txt = new JTextField(10);
	class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	}

	private ButtonActionListener bal = new ButtonActionListener();

	public static void main(String[] args) throws InterruptedException {
		Button2 button2 = new Button2();
		SwingConsole.run2(button2, 500, 300);
	}

	Button2() {
		setLayout(new FlowLayout());
		b1.addActionListener(bal);
		b2.addActionListener(bal);
		add(b1);
		add(b2);
		add(txt);
	}
}
