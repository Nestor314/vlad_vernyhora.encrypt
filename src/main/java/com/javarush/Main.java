package com.javarush;

import com.javarush.input.ApplicationInput;
import com.javarush.input.ConsoleInput;

import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main {

    static Scanner input = new Scanner(System.in);
    private static int wayOfUsing;

    public static void main(String[] args) {

        Characters.initializeWholeList();

        //MainFrame frame = new MainFrame();

        if (args.length != 0) {

            ApplicationInput.input(args);

        } else {

            guiOrConsole();

        }

    }

    public static void guiOrConsole() {


        System.out.println("Choose how you want to use encrypter (enter number):" +
                "\n1 - GUI" +
                "\n2 - Console");

        checkWayOfUsing();

        if (wayOfUsing == 1) {


        } else if (wayOfUsing == 2) {

            ConsoleInput.input();
            CaesarCipher.commands();

        }

    }

    public static void checkWayOfUsing() {

        try {
            wayOfUsing = input.nextInt();
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Invalid way of using \"" + wayOfUsing + "\". It has to be 1 or 2");

        }

    }

}
