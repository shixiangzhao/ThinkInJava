package com.shixiang.think.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

/**
 * 简单的Borders
 * 
 * @author Shixiang
 *
 */
public class Borders extends JFrame {

	private static final long serialVersionUID = 1L;

	static JPanel showBorder(Border b) {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		String nm = b.getClass().toString();
		nm = nm.substring(nm.lastIndexOf('.') + 1);
		jp.add(new JLabel(nm, JLabel.CENTER), BorderLayout.CENTER);
		jp.setBorder(b);
		return jp;
	}

	public Borders() {
		setLayout(new GridLayout(2, 4));
		add(showBorder(new TitledBorder("Title")));
		add(showBorder(new EtchedBorder()));
		add(showBorder(new LineBorder(Color.BLUE)));
		add(showBorder(new MatteBorder(5, 5, 30, 30, Color.BLUE)));
		add(showBorder(new BevelBorder(BevelBorder.RAISED)));
		add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.RED))));
		
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new Borders(), 500, 300);
	}
}
