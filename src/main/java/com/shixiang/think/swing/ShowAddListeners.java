package com.shixiang.think.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 简单的Show AddListeners
 * 
 * @author Shixiang
 *
 */
public class ShowAddListeners extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtf = new JTextField(10);
	private JTextArea jta = new JTextArea(20, 30);
	private JCheckBox jcb = new JCheckBox("Is Full Name");
	
	private Pattern addPattern = Pattern.compile("add\\w+?Listener\\(.*?\\)");
	private Pattern qualifier = Pattern.compile("\\w+\\.");

	class NameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String nm = jtf.getText().trim();
			if (nm.length() == 0) {
				jta.setText("No Match");
				return;
			}
			Class<?> kind;

			try {
				kind = Class.forName("javax.swing." + nm);
			} catch (ClassNotFoundException e1) {
				jta.setText("No Match");
				return;
			}
			Method[] methods = kind.getMethods();
			jta.setText("");
			for (Method m : methods) {
				Matcher matcher = addPattern.matcher(m.toString());
				if(matcher.find()) {
					if(jcb.isSelected()) {
						jta.append(m.toString() + "\n");
					} else {
						jta.append(qualifier.matcher(matcher.group(0)).replaceAll("") + "\n");
					}
				}
			}
		}
	}

	public ShowAddListeners() {
		NameListener nameListener = new NameListener();
		jtf.addActionListener(nameListener);
		JPanel jp = new JPanel();
		jp.add(new JLabel("Swing Class Name(press enter):"));
		jp.add(jtf);
		jp.add(jcb);
		add(BorderLayout.NORTH, jp);
		add(new JScrollPane(jta));
		jtf.setText("JFrame");
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new ShowAddListeners(), 500, 400);
	}
}
