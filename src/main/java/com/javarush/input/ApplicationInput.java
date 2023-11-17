package com.javarush.input;

import com.javarush.CaesarCipher;

public class ApplicationInput extends InputCheck {

    public static void input(String[] args) {

        InputVariables.setCommand(args[0]); //Заносимо значення аргументів до змінних
        InputVariables.setFilePath(args[1]);
        setKey(args[2]);

        checkVariables();

        CaesarCipher.commands();

    }

    private static void setKey(String key) {

        try { //Якщо користувач введе не число як key
            InputVariables.setKey(Integer.parseInt(key));
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Invalid key \"" + key + "\". It has to be integer");

        }

    }

}
