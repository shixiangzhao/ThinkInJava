package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 * Button Groups
 * 
 * @author Shixiang
 *
 */
public class ButtonGroups extends JFrame {

	private static final long serialVersionUID = 1L;
	private static String[] ids = { "June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy" };

	static JPanel makeBPanel(Class<? extends AbstractButton> kind, String[] ids) {
		ButtonGroup bg = new ButtonGroup();
		JPanel jp = new JPanel();
		String title = kind.getName();
		title = title.substring(title.lastIndexOf('.') + 1);
		jp.setBorder(new TitledBorder(title));
		for (String id : ids) {
			AbstractButton ab = new JButton("failed");
			try {
				Constructor<? extends AbstractButton> ctor = kind.getConstructor(String.class);
				ab = (AbstractButton) ctor.newInstance(id);
			} catch (Exception ex) {
				System.out.println("cat't create " + kind);
			}
			bg.add(ab);
			jp.add(ab);
		}
		return jp;
	}

	ButtonGroups() {
		setLayout(new FlowLayout());
		add(makeBPanel(JButton.class, ids));
		add(makeBPanel(JToggleButton.class, ids));
		add(makeBPanel(JCheckBox.class, ids));
		add(makeBPanel(JRadioButton.class, ids));
	}

	public static void main(String[] args) throws InterruptedException {
		SwingConsole.run2(new ButtonGroups(), 500, 350);
	}

}
