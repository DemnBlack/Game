package com.company;

import java.io.IOException;

public class Word {
    private char[] letters;
    private char[] knowLetters;
    private int number = 0;
    private int tilesLeft;

    public Word(String a) {
        this.letters = a.toCharArray();
        tilesLeft = letters.length;
        knowLetters = new char[letters.length];

        for(int i = 0; i < knowLetters.length; i++){
            knowLetters[i] = '_';
        }
        System.out.println("The length of the word: " + letters.length);
        System.out.print("Word: ");
        System.out.println(knowLetters);
    }

    public void checkLetters(char a) throws IOException {
        for(int i = 0; i < letters.length; i++){
            if(letters[i] == a){
                knowLetters[i] = a;
                tilesLeft--;
            }
        }
         if(tilesLeft  == 0){
             System.out.println("You win!!");
             Game.reset();
         }
        System.out.println("Key in one character or your guess word: " + a);
        System.out.print("Trial " + (number++) + ": ");
        System.out.println(knowLetters);

    }

    public boolean checkWord(String s){
        if(s.equals(String.valueOf(letters))){
            return true;
        }
        return false;
    }

}
