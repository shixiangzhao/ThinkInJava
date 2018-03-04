package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * 简单的CheckBoxes
 * 
 * @author Shixiang
 *
 */
public class CheckBoxes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea jta = new JTextArea(5,13);
	private JCheckBox jcb1 = new JCheckBox("游泳");
	private JCheckBox jcb2 = new JCheckBox("读书");
	private JCheckBox jcb3 = new JCheckBox("旅行");

	public CheckBoxes() {
		jcb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trace(jcb1.getText(), jcb1);
			}
		});
		jcb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trace(jcb2.getText(), jcb2);
			}
		});
		jcb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trace(jcb3.getText(), jcb3);
			}
		});
		setLayout(new FlowLayout());
		JPanel jp = new JPanel();
		jp.add(jcb1);
		jp.add(jcb2);
		jp.add(jcb3);
		jp.setBorder(new TitledBorder("爱好"));
		add(jp);
		add(new JScrollPane(jta));
	}

	private void trace(String str, JCheckBox jcb) {
		if(jcb.isSelected()) {
			jta.append("Box " + str + " Set\n");
		} else {
			jta.append("Box " + str + " Cleared\n");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new CheckBoxes(), 300, 300);
	}
}
