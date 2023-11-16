package com.javarush.input;

public class InputVariables {

    private static String command;

    public static String getCommand() {
        return command;
    }

    public static void setCommand(String command) {
        InputVariables.command = command;
    }

    private static String filePath;

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        InputVariables.filePath = filePath;
    }

    private static int key;

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        InputVariables.key = key;
    }

}
