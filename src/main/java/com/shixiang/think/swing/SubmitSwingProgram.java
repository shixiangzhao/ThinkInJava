package com.shixiang.think.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * 为每一个事件，创建一个单独的线程。
 * 
 * @author Shixiang
 *
 */
public class SubmitSwingProgram extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel jLabel;
	JLabel nice;
	static SubmitSwingProgram ssp;

	SubmitSwingProgram() {
		super("HelloSwing");
		jLabel = new JLabel("A Label");
		add(jLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ssp = new SubmitSwingProgram();
			}
		});
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ssp.jLabel.setText("Hey! This is a different!");
			}

		});
	}
}
