package com.shixiang.think.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * 简单的Swing应用
 * @author Shixiang
 *
 */
public class HelloSwing {

	public static void main(String[] args) throws InterruptedException {
		JFrame jf = new JFrame("HelloSwing");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(200, 200);
		jf.setSize(500, 300);
		jf.setVisible(true);
		
		JLabel jLabel = new JLabel("A Label");
		jf.add(jLabel);
		TimeUnit.SECONDS.sleep(1);
		jLabel.setText("Hey! This is a different!");

		TimeUnit.SECONDS.sleep(1);
		JLabel nice = new JLabel("nice day");
		jf.add(nice);
	}
}
