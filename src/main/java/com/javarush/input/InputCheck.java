package com.javarush.input;

import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class InputCheck {

    public static void checkVariables() {

        checkCommand(InputVariables.getCommand());
        checkFilePath(InputVariables.getFilePath());
        checkKey(InputVariables.getKey());

    }

    public static void checkCommand(String command) {

        if (command.equalsIgnoreCase("encrypt")) {


        } else if (command.equalsIgnoreCase("decrypt")) {


        } else if (command.equalsIgnoreCase("brute-force")) {


        } else {

            throw new IllegalArgumentException("Wrong command \"" + command + "\"");

        }

    }

    public static void checkFilePath(String filePath) {

        if (Files.exists(Paths.get(filePath)) || Files.isRegularFile(Paths.get(filePath))) {
            //Перевіряємо чи існує файл за вказаним шляхом

        } else {

            throw new IllegalArgumentException("Invalid file path \"" + filePath + "\"");

        }

    }

    public static void checkKey(int key) {

        try {

            if (key < 0) {

                throw new IllegalArgumentException("Invalid key \"" + key + "\". It has to be greater than 0");

            }

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Invalid key \"" + key + "\". It has to be integer");

        }

    }

}
