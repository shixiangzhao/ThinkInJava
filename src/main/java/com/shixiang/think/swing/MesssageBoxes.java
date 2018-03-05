package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 简单的MesssageBoxes
 * 
 * @author Shixiang
 */
public class MesssageBoxes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton[] jbs = {
            new JButton("Alert"), new JButton("Yes/No"), new JButton("Color"),
            new JButton("Input"), new JButton("3 Vals")
    };
    private JTextField jtf = new JTextField(15);
    private ActionListener al = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = ((JButton) e.getSource()).getText();
            if (id.equals("Alert")) {
                JOptionPane.showMessageDialog(null, "There's a bug on you!", "Hey", JOptionPane.ERROR_MESSAGE);
            } else if (id.equals("Yes/No")) {
                JOptionPane.showMessageDialog(null, "or no", "choose yes", JOptionPane.YES_NO_OPTION);
            } else if (id.equals("Color")) {
                Object[] options = { "Red", "Green" };
                int sel = JOptionPane.showOptionDialog(null, "Choose a Color!", "Warning", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (sel != JOptionPane.CLOSED_OPTION)
                    jtf.setText("Color selectedd: " + options[sel]);
            } else if (id.equals("Input")) {
                String val = JOptionPane.showInputDialog("How many fingers do you see?");
                jtf.setText(val);
            } else if (id.equals("3 Vals")) {
                Object[] selections = {
                        "First", "Second", "Third"
                };
                Object val = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
                        null, selections, selections[0]);
                if (val != null)
                    jtf.setText(val.toString());
            }
        }
    };

    public MesssageBoxes() {
        setLayout(new FlowLayout());
        for (JButton jb : jbs) {
            jb.addActionListener(al);
            add(jb);
        }
        add(jtf);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new MesssageBoxes(), 200, 200);
    }
}
