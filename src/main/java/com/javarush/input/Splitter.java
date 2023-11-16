package com.javarush.input;

public class Splitter {

    private static String command;

    public static String getCommand() {
        return command;
    }

    public static void setCommand(String command) {
        Splitter.command = command;
    }

    private static String filePath;

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        Splitter.filePath = filePath;
    }

    private static int key;

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Splitter.key = key;
    }

    public static void splitter() {

        String[] inputArray = ConsoleInput.getConsoleInput().split("\\s+");

        setCommand(inputArray[0]);
        setFilePath(inputArray[1]);
        setKey(Integer.parseInt(inputArray[2])); //Тому що масив String[]

        //System.out.println(getCommand() + " " + getFilePath() + " " + getKey());

    }

}
