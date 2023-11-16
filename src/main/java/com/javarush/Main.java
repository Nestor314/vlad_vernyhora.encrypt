package com.javarush;

import com.javarush.input.ApplicationInput;
import com.javarush.input.ConsoleInput;

public class Main {
    public static void main(String[] args) {

        Characters.initializeWholeList();

        //MainFrame frame = new MainFrame();

        if (args.length != 0) {

            ApplicationInput.input(args);

        } else {

            ConsoleInput.input();

        }

    }

}
