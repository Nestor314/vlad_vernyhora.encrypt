package com.javarush.input;

public class ApplicationInput extends Input {

    public static void input(String[] args) {

        InputVariables.setCommand(args[0]); //Заносимо значення аргументів до змінних
        InputVariables.setFilePath(args[1]);
        setKey(args[2]);

        checkVariables();

    }

    public static void setKey(String key) {

        try { //Якщо користувач введе не число як key
            InputVariables.setKey(Integer.parseInt(key));
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Invalid key \"" + key + "\". It has to be integer");

        }

    }

}
