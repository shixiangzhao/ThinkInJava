package com.shixiang.think.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * 简单的SimpleMenus
 * 
 * @author Shixiang
 */
public class SimpleMenus extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField jtf = new JTextField(15);
    private ActionListener al = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            jtf.setText(((JMenuItem) e.getSource()).getText());
        }
    };
    private JMenu[] menus = {
            new JMenu("购物"), new JMenu("结算"), new JMenu("用户"),
    };
    private JMenuItem[] items = {
            new JMenuItem("衣服"), new JMenuItem("微信"), new JMenuItem("注册"),
            new JMenuItem("鞋子"), new JMenuItem("支付宝"), new JMenuItem("登录"),
            new JMenuItem("水果"), new JMenuItem("信用卡"), new JMenuItem("修改密码"),
    };

    public SimpleMenus() {
        for (int i = 0; i < items.length; i++) {
            items[i].addActionListener(al);
            menus[i % 3].add(items[i]);
        }
        JMenuBar jmb = new JMenuBar();
        for(JMenu jm :menus)
            jmb.add(jm);
        setJMenuBar(jmb);
        setLayout(new FlowLayout());
        add(jtf);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingConsole.run2(new SimpleMenus(), 200, 150);
    }
}
