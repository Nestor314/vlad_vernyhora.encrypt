package com.javarush.input;

import java.util.Scanner;

public class ConsoleInput extends Input {

    static Scanner reader = new Scanner(System.in);

    private static String consoleInput;

    public static String getConsoleInput() {
        return consoleInput;
    }

    public static void setConsoleInput(String consoleInput) {
        ConsoleInput.consoleInput = consoleInput;
    }

    public static void input() {

        System.out.println("Enter command, file path and key." +
                "\nExample: ENCRYPT /Users/nestor/IdeaProjects/vlad_vernyhora.encrypt/test.txt 7");

        setConsoleInput(reader.nextLine());

        Splitter.split();

        checkVariables(); //Метод класу Input

    }

}
