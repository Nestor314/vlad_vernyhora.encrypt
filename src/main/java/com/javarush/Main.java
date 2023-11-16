package com.javarush;

public class Main {
    public static void main(String[] args) {

        checkCommand(args);

    }

    public static void checkCommand(String[] args) {
        if (!(args[0].equalsIgnoreCase("encrypt")) &&
                !(args[0].equalsIgnoreCase("decrypt")) &&
                !(args[0].equalsIgnoreCase("brute-force"))) {

            throw new IllegalArgumentException("Wrong command \"" + args[0] + "\"");

        }
    }

}
