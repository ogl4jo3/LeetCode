package com.company.easy.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Created by ogl4jo3 on 2017/3/5.
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] keywordGroups = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res=new ArrayList<>();
        for (String keyword : keywordGroups) {
            for (String input : words) {
                boolean correct = true;
                for (int i = 0; i < input.length(); i++) {
                    if (!keyword.contains(String.valueOf(input.charAt(i)).toLowerCase())) {
                        correct = false;
                        break;
                    }
                }
                if (correct) {
                    res.add(input);
                    System.out.println(input);
                }
            }
        }
        //String[] resArray = res.toArray(new String[0]);
        String[] resArray = res.toArray(new String[res.size()]);
        for (String result:resArray){
            System.out.println(result);
        }
    }
}
