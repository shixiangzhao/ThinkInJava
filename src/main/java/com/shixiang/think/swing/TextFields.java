package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * 简单的TextFields
 * 
 * @author Shixiang
 *
 */
public class TextFields extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton b1 = new JButton("Get Text");
	private JButton b2 = new JButton("Set Text");
	private JTextField t1 = new JTextField(30);
	private JTextField t2 = new JTextField(30);
	private JTextField t3 = new JTextField(30);
	private String s = "";
	private UpperCaseDocument ucd = new UpperCaseDocument();

	class T1D implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			t2.setText(t1.getText());
			t3.setText("Text:" + t1.getText());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			t2.setText(t1.getText());
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
		}

	}

	class T1 implements ActionListener {

		private int count = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			t3.setText("t1 Action Event " + count++);
		}
	}

	class B1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (t1.getSelectedText() == null)
				s = t1.getText();
			else
				s = t1.getSelectedText();
			t1.setEditable(true);
		}
	}

	class B2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ucd.setUpperCase(false);
			t1.setText("Inserted by Button 2: " + s);
			ucd.setUpperCase(true);
			t1.setEditable(false);
		}
	}

	public TextFields() {
		t1.setDocument(ucd);
		ucd.addDocumentListener(new T1D());
		b1.addActionListener(new B1());
		b2.addActionListener(new B2());
		t1.addActionListener(new T1());
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(t1);
		add(t2);
		add(t3);
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new TextFields(), 375, 200);
	}
}

class UpperCaseDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private boolean upperCase = true;

	public void setUpperCase(boolean flag) {
		upperCase = flag;
	}

	public void insertString(int offset, String str, AttributeSet attSet) throws BadLocationException {
		if (upperCase)
			str = str.toUpperCase();
		super.insertString(offset, str, attSet);
	}
}
