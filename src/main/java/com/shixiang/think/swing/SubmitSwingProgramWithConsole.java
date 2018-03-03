package com.shixiang.think.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * 为每一个事件，创建一个单独的线程,并使用SwingConsole
 * 
 * @author Shixiang
 *
 */
public class SubmitSwingProgramWithConsole extends JFrame {

	private static final long serialVersionUID = 1L;
	static JLabel jLabel;
	static SubmitSwingProgramWithConsole ssp;

	public static void main(String[] args) throws InterruptedException {
		jLabel = new JLabel("A Label");
		ssp = new SubmitSwingProgramWithConsole();
		SwingConsole.run1(ssp, jLabel, 500, 300);

		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				jLabel.setText("Hey! This is a different!");
			}

		});
	}
}
