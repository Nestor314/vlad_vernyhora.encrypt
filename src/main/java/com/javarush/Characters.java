package com.javarush;

import java.util.ArrayList;
import java.util.List;

public class Characters {

    static List<java.lang.Character> characterList = new ArrayList<>();

    public static void initializeWholeList() {

        initializeEngCharacters();
        initializeRusUkrCharacters();
        initializePunctuationCharacters();

        //for (char character : characterList) {
        //    System.out.print(character + " ");
        //}

    }

    private static void initializeEngCharacters() {

        for (char engBig = 'A'; engBig <= 'Z'; engBig++) { //от 0 до 25
            characterList.add(engBig);
        }

        for (char engSmall = 'a'; engSmall <= 'z'; engSmall++) { //от 26 до 51
            characterList.add(engSmall);
        }

    }

    private static void initializeRusUkrCharacters() {

        for (char rusBig = 'А'; rusBig <= 'Я'; rusBig++) { //от 52 до 77
            characterList.add(rusBig);
        }
        characterList.add('Ґ'); //78
        characterList.add('Є'); //79
        characterList.add('І'); //80
        characterList.add('Ї'); //81

        for (char rusSmall = 'а'; rusSmall <= 'я'; rusSmall++) { //от 82 до 107
            characterList.add(rusSmall);
        }
        characterList.add('ґ'); //108
        characterList.add('є'); //109
        characterList.add('і'); //110
        characterList.add('ї'); //111

    }

    private static void initializePunctuationCharacters() {

        String stringPunctuation = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        for (char punctuation : stringPunctuation.toCharArray()) {
            characterList.add(punctuation);
        }

    }

}
