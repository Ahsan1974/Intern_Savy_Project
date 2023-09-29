package com.company1;

import java.util.Scanner;

public class Task2 {
    private static final String[] words={"java","dart","swift","ruby","typescript","fortran"};
    private static String wordToGuess;
    private static StringBuilder guessWord;
    private static int remainingAttempts;
    private static String guessedLetters;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to Hangman!!!");
        chooseWordToGuess();

        guessWord=new StringBuilder(wordToGuess.length());
        guessWord.append("_".repeat(wordToGuess.length()));

        remainingAttempts= 5;
        guessedLetters="";
        while (remainingAttempts > 0 && guessWord.toString().contains("_")) {
            Status();
            System.out.print("Guess a letter: ");
            String guess = sc.next().toLowerCase();

            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                Guess(guess.charAt(0));
            } else {
                System.out.println("Invalid input. Please enter a single letter.");
            }
        }
        if (remainingAttempts == 0) {
            System.out.println("Sorry, You Lost."+"\n"+"The word was: " + wordToGuess);
        } else {
            System.out.println("Congratulations, You Won!!! You guessed the word: " + wordToGuess);
        }



    }
    public static void chooseWordToGuess(){
        wordToGuess=words[(int) (Math.random()*words.length)];
    }
    public static void Status(){
        System.out.println("Word: "+guessWord);
        System.out.println("Guessed Letters: "+guessedLetters);
        System.out.println("Attempts Remaining: "+remainingAttempts);
    }
    public static void Guess(char guess){
        if (guessedLetters.contains(String.valueOf(guess))){
            System.out.println("You already guessed that Letter");
            return;
        }
        guessedLetters+=guess;
        if (wordToGuess.contains(String.valueOf(guess))){
            for (int i=0;i<wordToGuess.length();i++){
                if (wordToGuess.charAt(i)==guess){
                    guessWord.setCharAt(i,guess);
                }
            }
        }else {
            remainingAttempts--;
        }
    }
}
