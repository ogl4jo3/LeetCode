package com.company.easy.DetectCapital;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Created by ogl4jo3 on 2017/3/12.
 */
public class DetectCapital {
    public static void main(String[] args) {
        String word = "FlaG";
        boolean capital = true;
        if (word.length() == 0) {
            capital = false;
        } else if (word.length() > 1) {
            if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        capital = false;
                        break;
                    }
                }
            } else if (Character.isLowerCase(word.charAt(0))) {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        capital = false;
                        break;
                    }
                }
            } else if (Character.isUpperCase(word.charAt(0)) && Character.isLowerCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        capital = false;
                        break;
                    }
                }
            }

        }
        System.out.println(capital);
        // Answer
        System.out.println(word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+"));
    }
}
