package com.javarush.input;

public class Splitter {

    private static String[] inputArray = ConsoleInput.getConsoleInput().split("\\s+");

    public static String[] getInputArray() {
        return inputArray;
    }

    public static void split() {

        InputVariables.setCommand(getInputArray()[0]);
        InputVariables.setFilePath(getInputArray()[1]);
        setKey(getInputArray()[2]);

    }

    private static void setKey(String key) {

        try { //Якщо користувач введе не число як key
            InputVariables.setKey(Integer.parseInt(key)); //Тому що масив String[], а нам потрібен int
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Invalid key \"" + key + "\". It has to be integer");

        }

    }

}
