package com.javarush;

import com.javarush.input.ConsoleInput;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Characters.initializeWholeList();

        if (!(args.length == 0)) {

            checkCommand(args);
            checkFilePath(args);
            checkKey(args);

        } else {

            ConsoleInput.input();

        }

    }

    private static void checkCommand(String[] args) { //Перевіряємо чи обрана одна з 3х існуючих команд

        if (!(args[0].equalsIgnoreCase("encrypt")) &&
                !(args[0].equalsIgnoreCase("decrypt")) &&
                !(args[0].equalsIgnoreCase("brute-force"))) {

            throw new IllegalArgumentException("Wrong command \"" + args[0] + "\"");

        }
    }

    private static void checkFilePath(String[] args) { //Перевіряємо чи дійсний шлях до файлу

        if (!Files.exists(Paths.get(args[1])) || !Files.isRegularFile(Paths.get(args[1]))) {

            throw new IllegalArgumentException("Invalid file path \"" + args[1] + "\"");

        }

    }

    private static void checkKey(String[] args) { //Перевіряємо чи підходить нам ключ

        try {

            if (Integer.parseInt(args[2]) < 0) {

                throw new IllegalArgumentException("Invalid key \"" + args[2] + "\". It has to be greater than 0");

            }

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Invalid key \"" + args[2] + "\". It has to be integer");

        }

    }


}
