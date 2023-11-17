package com.javarush;

import com.javarush.input.InputVariables;

public class CaesarCipher {

    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Characters.characterList.contains(ch)) {
                int index = Characters.characterList.indexOf(ch);
                int newIndex = (index + key) % Characters.characterList.size();
                encryptedText.append(Characters.characterList.get(newIndex));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, Characters.characterList.size() - key);
    }

    public static void commands() {

        FileReaderWriter.getTextFromFile();
        FileReaderWriter.useEncryptedFileName();
        FileReaderWriter.useDecryptedFileName();

        if ("encrypt".equalsIgnoreCase(InputVariables.getCommand())) {
            String encryptedText = CaesarCipher.encrypt(FileReaderWriter.getInputText(), InputVariables.getKey());
            FileReaderWriter.writeTextToFile(FileReaderWriter.getEncryptedFileName(), encryptedText); // Запис зашифрованого тексту у файл
        } else if ("decrypt".equalsIgnoreCase(InputVariables.getCommand())) {
            String decryptedText = CaesarCipher.decrypt(FileReaderWriter.getInputText(), InputVariables.getKey());
            FileReaderWriter.writeTextToFile(FileReaderWriter.getDecryptedFileName(), decryptedText); // Запис розшифрованого тексту у файл
        } else if ("brute-force".equalsIgnoreCase(InputVariables.getCommand())){

        }

    }

}
