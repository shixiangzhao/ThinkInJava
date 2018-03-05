package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 简单的ComboBoxes
 * 
 * @author Shixiang
 */
public class ComboBoxes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField jtf = new JTextField(15);
    private JButton jb = new JButton("Add Items");
    private JComboBox<String> jcb = new JComboBox<>();
    private int count = 0;
    private String[] description = {
            "Ebullient", "Obtuse", "Recalcitrant", "Brilliant",
            "Somnescent", "Timorous", "Florid", "Putrescent"
    };

    public ComboBoxes() {
        for (int i = 0; i < 4; i++) {
            jcb.addItem(description[count++]);
        }
        jtf.setEnabled(false);
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < description.length) {
                    jcb.addItem(description[count++]);
                }
            }
        });
        jcb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("index: " + jcb.getSelectedIndex() + " "
                        + ((JComboBox<String>) e.getSource()).getSelectedItem());
            }
        });
        setLayout(new FlowLayout());
        add(jtf);
        add(jb);
        add(jcb);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new ComboBoxes(), 300, 300);
    }
}
