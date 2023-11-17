package com.javarush;

import com.javarush.input.InputVariables;
import com.javarush.input.JFrameInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame {

    static JButton start;
    static JButton clear;
    static JTextField filePath;
    static JTextField key;

    public InputFrame() {

        //Параметри вікна
        setSize(400, 350);
        setTitle("Encrypter");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Розміщення вікна програми по центру

        JPanel panel = new JPanel();
        add(panel);
        panel.setBounds(2, 2, 396, 320);
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel inputFilePath = new JLabel("Enter file path:");
        inputFilePath.setBounds(75, 40, 150, 50);
        panel.add(inputFilePath);

        filePath = new JTextField(25);
        filePath.setBounds(72, 80, 250, 40);
        panel.add(filePath);

        JLabel inputKey = new JLabel("Enter key:");
        inputKey.setBounds(75, 120, 150, 50);
        panel.add(inputKey);

        key = new JTextField(25);
        key.setBounds(72, 160, 250, 40);
        panel.add(key);

        start = new JButton("Start");
        start.setBounds(50, 230, 120, 60);
        start.addActionListener(new Start());
        panel.add(start);

        clear = new JButton("Clear");
        clear.setBounds(220, 230, 120, 60);
        clear.addActionListener(new Clear());
        panel.add(clear);

        setFont(new Font("Calibri", Font.BOLD, 14)); //Власний шрифт

    }

    static class Start implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            //Якщо натиснули на кнопку
            if (e.getSource() == start) {

                InputVariables.setFilePath(filePath.getText());
                InputVariables.setKey(Integer.parseInt(key.getText()));

                JFrameInput.input();

                JOptionPane.showMessageDialog(null,
                        "Success!", "Info", JOptionPane.PLAIN_MESSAGE);

            }

        }

    }

    static class Clear implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            //Якщо натиснули на кнопку
            if (e.getSource() == clear) {

                filePath.setText("");
                key.setText("");

            }

        }

    }

}
