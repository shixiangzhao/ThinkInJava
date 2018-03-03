package com.shixiang.think.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Swing通用框架
 * 
 * @author Shixiang
 *
 */
public class SwingConsole {

	public static void run1(final JFrame jf, final JLabel jLabel, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jf.setTitle(jf.getClass().getSimpleName());
				jf.add(jLabel);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setSize(width, height);
				jf.setLocation(200, 200);
				jf.setVisible(true);
			}
		});
	}

	public static void run2(final JFrame jf, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jf.setTitle(jf.getClass().getSimpleName());
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setSize(width, height);
				jf.setLocation(200, 200);
				jf.setVisible(true);
			}
		});
	}
}
