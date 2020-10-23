package com.company;


import java.io.*;
import java.util.Random;

public class Game {
    private static Word word;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String[] valueWord;

    public static void main(String[] args) throws IOException {
        try (BufferedReader bf = new BufferedReader( new FileReader(new File("src/com/company/resourse/Words.txt")))){
            String line = bf.readLine();
            valueWord = new String[Integer.parseInt(line)];
            int i = 0;
            while (true){
                line = bf.readLine();
                if(line == null){
                    break;
                }
                valueWord[i] = line;
                i++;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        Random r = new Random();
        String randomWord = valueWord[r.nextInt(valueWord.length)];
        word = new Word(randomWord);

        enterLetter();


    }

    public static void enterLetter() throws IOException {
        System.out.println("\n" + "Enter a letter");
        String value = reader.readLine();
        if (value.toCharArray().length == 1) {
            word.checkLetters(value.toCharArray()[0]);
            enterLetter();
        } else {
            if (word.checkWord(value)) {
                System.out.println("!!Win!!");
                reset();
            } else {
                System.out.println("!!You lose!!");
                reset();
            }
        }


    }

    public static void reset() throws IOException {
        System.out.println("Start the game over?\n" + "Yes, No");
        String str = reader.readLine();
        if (str.equals("Yes") || str.equals("yes")) {
            enterLetter();
        } else if(str.equals("No") || str.equals("no")){
            System.exit(0);
        }
        reset();
    }
}
