package com.javarush;

import com.javarush.input.ApplicationInput;
import com.javarush.input.ConsoleInput;
import com.javarush.input.InputVariables;
import com.javarush.input.Splitter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Characters.initializeWholeList();

        if (args.length != 0) {

            ApplicationInput.input(args);

        } else {

            ConsoleInput.input();

        }

    }

}
