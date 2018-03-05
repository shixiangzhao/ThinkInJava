package com.shixiang.think.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 简单的TabbedPanel
 * 
 * @author Shixiang
 */
public class TabbedPane1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Rum Raisin", "Mud Pie"
    };

    private JTextField jtf = new JTextField();
    private JTabbedPane tabs = new JTabbedPane();

    public TabbedPane1() {
        for (int i = 0; i < flavors.length; i++) {
            tabs.addTab(flavors[i], new JButton("Tabbed pane " + i));
        }
        tabs.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                jtf.setText("Tab selected: " + tabs.getSelectedIndex());
            }
        });
        add(BorderLayout.SOUTH, jtf);
        add(tabs);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new TabbedPane1(), 400, 250);
    }
}
