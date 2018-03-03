package com.shixiang.think.swing;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * 为更改标签创建一个单独的线程
 * @author Shixiang
 *
 */
public class SubmitLabelMunipulationTask {

	public static void main(String[] args) throws InterruptedException {
		JFrame jf = new JFrame("HelloSwing");
		JLabel jLabel = new JLabel("A Label");
		jf.add(jLabel);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(200, 200);
		jf.setSize(500, 300);
		jf.setVisible(true);

		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				jLabel.setText("Hey! This is a different!");
			}

		});
	}
}
