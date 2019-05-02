package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Palindrome extends JFrame {

    private ArrayList<String> stack;

    public Palindrome() {
        stack = new ArrayList<String>();
        windowSetup();
        setComponents();
        this.pack();
        this.setVisible(true);
    }

    public void windowSetup() {
        this.setTitle("Palindrome");
        this.setLayout(new GridLayout(5, 4));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setComponents() {
        JLabel enterTextLnl = new JLabel("Write: ");
        final JTextField word = new JTextField();
        JButton btn = new JButton("Check");
        final JLabel lbl = new JLabel();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                push(word.getText());
                if (isPalindrome()) {
                    lbl.setText("Palindrome");
                } else {
                    lbl.setText("Not palindrome");
                }
                pack();
                pop();
            }
        });

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 4));

        textPanel.add(enterTextLnl);
        textPanel.add(word);

        this.add(textPanel);
        this.add(btn);
        this.add(lbl);
    }

    public void push(String x) {
        stack.add(x);
    }

    public String pop() {
        return stack.remove(stack.size() - 1);
    }

    public boolean find(String x) {
        return stack.contains(x);

    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public boolean isPalindrome() {
        if (stack.get(0).length() == 0) return true;
        String string = stack.get(0).replaceAll(" ", "").toLowerCase();

        for (int i = 0, j = string.length() - 1; i < string.length() / 2; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
