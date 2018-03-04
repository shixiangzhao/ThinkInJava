package com.shixiang.think.swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 简单的TrackEvent
 * 
 * @author Shixiang
 *
 */
public class TrackEvent extends JFrame {

	private static final long serialVersionUID = 1L;
	private Map<String, JTextField> hm = new HashMap<>();
	private String[] event = { "focusGained", "focusLost", "keyPressed", "keyReleased", "keyTyped", "mouseClicked",
			"mouseEntered", "mouseExited", "mousePressed", "mouseReleased", "mouseDragged", "mouseMoved" };

	class MyButton extends JButton {

		private static final long serialVersionUID = 1L;

		void report(String field, String msg) {
			hm.get(field).setText(msg);
		}

		FocusListener fl = new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				report("focusGained", e.paramString());

			}

			@Override
			public void focusLost(FocusEvent e) {
				report("focusLost", e.paramString());

			}
		};
		KeyListener kl = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				report("keyTyped", e.paramString());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				report("keyPressed", e.paramString());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				report("keyReleased", e.paramString());
			}
		};
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				report("mouseClicked", e.paramString());

			}

			@Override
			public void mousePressed(MouseEvent e) {
				report("mousePressed", e.paramString());

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				report("mouseReleased", e.paramString());

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				report("mouseEntered", e.paramString());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				report("mouseExited", e.paramString());

			}

		};
		MouseMotionListener mml = new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				report("mouseDragged", e.paramString());

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				report("mouseMoved", e.paramString());

			}

		};

		public MyButton(Color color, String label) {
			super(label);
			setBackground(color);
			addFocusListener(fl);
			addKeyListener(kl);
			addMouseListener(ml);
			addMouseMotionListener(mml);
		}
	}

	private MyButton b1 = new MyButton(Color.BLUE, "test1");
	private MyButton b2 = new MyButton(Color.RED, "test2");

	public TrackEvent() {
		setLayout(new GridLayout(event.length + 1, 2));
		for (String evt : event) {
			JTextField txt = new JTextField();
			txt.setEditable(false);
			add(new JLabel(evt, JLabel.RIGHT));
			add(txt);
			hm.put(evt, txt);
			add(b1);
			add(b2);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new TrackEvent(), 700, 500);
	}
}
