package com.shixiang.think.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * 简单的TextPane，具有自动换行等内置功能
 * 
 * @author Shixiang
 *
 */
public class TextPane extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton b = new JButton("Add Text");
	private JTextPane tp = new JTextPane();
	//private static Generator sg = new RandomGenerator.String(7);
	
	public TextPane() {
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=1;i<10;i++) {
					tp.setText(tp.getText() + i + "\n");
				}
			}
		});
		add(new JScrollPane(tp));
		add(BorderLayout.SOUTH, b);
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new TextPane(), 300, 300);
	}
}
