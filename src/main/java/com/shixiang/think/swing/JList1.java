package com.shixiang.think.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 简单的JList1
 * 
 * @author Shixiang
 */
public class JList1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Rum Raisin", "Mud Pie"
    };
    private DefaultListModel<String> lItems = new DefaultListModel<>();
    private JList<String> jl = new JList<>(lItems);
    private JTextArea jta = new JTextArea(flavors.length, 20);
    private JButton jb = new JButton("Add Items");
    private int count = 0;
    private ActionListener bl = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (count < flavors.length) {
                lItems.add(0, flavors[count++]);
            } else {
                jb.setEnabled(false);
            }
        }
    };
    private ListSelectionListener ll = new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting())
                return;
            jta.setText("");
            for (Object item : jl.getSelectedValues()) {
                jta.append(item + "\n");
            }
        }
    };

    public JList1() {
        setLayout(new FlowLayout());
        jta.setEnabled(false);
        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.black);
        jta.setBorder(brd);
        for (int i = 0; i < 4; i++) {
            lItems.addElement(flavors[count++]);
        }
        add(jta);
        add(jl);
        add(jb);
        jl.addListSelectionListener(ll);
        jb.addActionListener(bl);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new JList1(), 250, 375);
    }
}
