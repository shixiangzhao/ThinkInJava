package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 简单的TextArea
 * 
 * @author Shixiang
 *
 */
public class TextArea extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton addButton = new JButton("Add Data");
	private JButton cancelButton = new JButton("Cancel");

	private JTextArea txtArea = new JTextArea(5, 30);
	private Map<String, String> map = new HashMap<>();

	public TextArea() {
		map.putAll(Countries.capitals());
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Entry<String, String> entry: map.entrySet()) {
					txtArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
				}
			}

		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("");

			}

		});
		setLayout(new FlowLayout());
		add(addButton);
		add(cancelButton);
		add(new JScrollPane(txtArea));
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new TextArea(), 500, 300);
	}
}
