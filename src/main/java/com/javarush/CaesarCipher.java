package com.javarush;

import com.javarush.input.InputVariables;

public class CaesarCipher {

    private static int bestKey = -1;
    private static int bestMatchCount = 0;


    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Characters.characterList.contains(character)) {
                int index = Characters.characterList.indexOf(character);
                int newIndex = (index + key) % Characters.characterList.size(); //Щоб підбирати ключ циклічно
                if (newIndex < 0) {
                    newIndex += Characters.characterList.size();
                }
                encryptedText.append(Characters.characterList.get(newIndex));
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();

    }

    public static String decrypt(String text, int key) {
        return encrypt(text, Characters.characterList.size() - key);
    }

    public static void bruteForce(String encryptedText) {

        String[] wordsToMatch = {
                //Додано англійські слова
                "the", "and", "you", "that", "for", "this", "with", "from", "have", "not", "what",
                "are", "but", "all", "were", "when", "can", "your", "use", "how", "said",
                "one", "will", "some", "see", "make", "like", "time", "know", "just", "into",
                "of", "day", "out", "take", "come", "they", "has", "good", "get", "look",
                // Додано українські слова
                "це", "як", "що", "із", "до", "він", "також", "може", "або", "зараз",
                "наш", "світ", "любов", "робота", "знання", "думка", "мова", "розвиток", "освіта",
                "від", "країна", "мовлення", "політика", "громадянин", "економіка", "культура", "історія", "наука"
        };

        for (int key = 0; key < Characters.characterList.size(); key++) {
            String decryptedText = decrypt(encryptedText, key);
            int matchCount = countMatches(decryptedText, wordsToMatch);
            if (matchCount > bestMatchCount) {
                bestMatchCount = matchCount;
                bestKey = key;
            }
        }

    }

    public static int countMatches(String text, String[] wordsToMatch) {
        int count = 0;
        for (String word : wordsToMatch) {
            if (text.toLowerCase().contains(word)) {
                count++;
            }
        }
        return count;
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
            
        } else if ("brute-force".equalsIgnoreCase(InputVariables.getCommand())) {
            String encryptedText = FileReaderWriter.readTextFromFile(InputVariables.getFilePath());
            bruteForce(encryptedText);

            System.out.println("Key - " + bestKey);
            String decryptedText = decrypt(encryptedText, bestKey);
            FileReaderWriter.writeTextToFile(FileReaderWriter.getDecryptedFileName(), decryptedText);
        }

    }

}
