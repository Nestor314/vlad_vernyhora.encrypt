package com.javarush;

import com.javarush.input.InputVariables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderWriter {

    private static String inputText;

    public static String getInputText() {
        return inputText;
    }

    private static String encryptedFileName;

    public static String getEncryptedFileName() {
        return encryptedFileName;
    }

    private static String decryptedFileName;

    public static String getDecryptedFileName() {
        return decryptedFileName;
    }

    // Метод для зчитування тексту з файлу
    public static String readTextFromFile(String filePath) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            return new String(encoded);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Метод для запису тексту у файл
    public static void writeTextToFile(String filePath, String text) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getTextFromFile() {

        inputText = FileReaderWriter.readTextFromFile(InputVariables.getFilePath());

    }

    public static String setEncryptedFileName(String originalFileName) {
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex != -1) { // Якщо є крапка, "[ENCRYPTED]" перед нею
            return originalFileName.substring(0, dotIndex) + "[ENCRYPTED]" + originalFileName.substring(dotIndex);
        } else { // Якщо ні - "[ENCRYPTED]" в кінці
            return originalFileName + "[ENCRYPTED]";
        }
    }

    public static void useEncryptedFileName() {

        encryptedFileName = setEncryptedFileName(InputVariables.getFilePath());

    }

    private static String setDecryptedFileName(String encryptedFileName) {
        // Видалення "[ENCRYPTED]" з імені файлу, якщо воно присутнє
        return encryptedFileName.replace("[ENCRYPTED]", "[DECRYPTED]");
    }

    public static void useDecryptedFileName() {

        decryptedFileName = setDecryptedFileName(InputVariables.getFilePath());

    }

}
