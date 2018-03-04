package com.shixiang.think.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * 不同种类的Button，
 * 
 * @author Shixiang
 *
 */
public class Buttons extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jb = new JButton("JButton");
	private BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH);
	private BasicArrowButton down = new BasicArrowButton(BasicArrowButton.SOUTH);
	private BasicArrowButton right = new BasicArrowButton(BasicArrowButton.EAST);
	private BasicArrowButton left = new BasicArrowButton(BasicArrowButton.WEST);

	Buttons() {
		setLayout(new FlowLayout());
		add(jb);
		add(new JToggleButton("JToggleButton"));
		add(new JCheckBox(""));
		add(new JRadioButton(""));
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("Directions"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		add(jp);
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new Buttons(), 350, 200);
	}

}
