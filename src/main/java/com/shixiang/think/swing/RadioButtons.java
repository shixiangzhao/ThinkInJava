package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 简单的RadioButtons
 * 
 * @author Shixiang
 */
public class RadioButtons extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField jtf = new JTextField(15);
    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton rb1 = new JRadioButton("博士", false);
    private JRadioButton rb2 = new JRadioButton("研究生", false);
    private JRadioButton rb3 = new JRadioButton("本科", false);
    private ActionListener al = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            jtf.setText(((JRadioButton) e.getSource()).getText());
        }
    };

    public RadioButtons() {
        rb1.addActionListener(al);
        rb2.addActionListener(al);
        rb3.addActionListener(al);
        //如果不加在一个ButtonGroup中，那么可以多选
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        setLayout(new FlowLayout());
        jtf.setEnabled(false);
        add(jtf);
        add(rb1);
        add(rb2);
        add(rb3);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new RadioButtons(), 200, 125);
    }
}
