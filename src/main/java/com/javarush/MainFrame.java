package com.javarush;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{ //Головне меню

    static JButton encrypt;
    static JButton decrypt;
    static JButton bruteForce;
    static JButton help;
    static JButton exit;

    public MainFrame(){

        //Параметри вікна
        setSize(600, 429);
        setVisible(true);
        setTitle("Encrypter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Розміщення вікна програми по центру

        JPanel headPanel = new JPanel();
        headPanel.setBounds(2, 2, 596, 100);
        headPanel.setBackground(Color.GRAY);

        JLabel menu = new JLabel("Main Menu");
        menu.setBounds(215,25,200,50);
        menu.setFont(new Font("Calibri", Font.BOLD, 30));
        headPanel.add(menu);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBounds(2, 104, 596, 500);
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        encrypt = new JButton("Encrypt");
        encrypt.setBounds(1, 1, 298, 100);
        encrypt.setFont(new Font("Calibri", Font.BOLD, 14));
        //encrypt.addActionListener(new Encrypt());
        bodyPanel.add(encrypt);

        decrypt = new JButton("Decrypt");
        decrypt.setBounds(297, 1, 298, 100);
        decrypt.setFont(new Font("Calibri", Font.BOLD, 14));
        //decrypt.addActionListener(new Decrypt());
        bodyPanel.add(decrypt);

        bruteForce = new JButton("Pick up the key");
        bruteForce.setBounds(1, 99, 298, 100);
        bruteForce.setFont(new Font("Calibri", Font.BOLD, 14));
        //bruteForce.addActionListener(new BruteForce());
        bodyPanel.add(bruteForce);

        help = new JButton("Help");
        help.setBounds(297, 99, 298, 100);
        help.setFont(new Font("Calibri", Font.BOLD, 14));
        //help.addActionListener(new Help());
        bodyPanel.add(help);

        exit = new JButton("Exit");
        exit.setBounds(1, 197, 594, 100);
        exit.setFont(new Font("Calibri", Font.BOLD, 14));
        exit.addActionListener(new Exit());
        bodyPanel.add(exit);

        setFont(new Font("Calibri", Font.BOLD, 14)); //Власний шрифт

        add(headPanel); //Додаємо панель, на якій знаходяться наші елементи, до фрейму
        add(bodyPanel);
    }

    static class Exit implements ActionListener { //Реалізація дії при натисканні на Exit

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == exit){

                System.exit(0);

            }

        }

    }

}
