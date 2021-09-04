package com.company.leetcode.todo;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        String[] testS = new String[]{
                "leetcode",
                "applepenapple",
                "catsandog"
        };
        String[][] testWordDict = new String[][]{
                {"leet", "code"},
                {"apple", "pen"},
                {"cats", "dog", "sand", "and", "cat"}
        };
        boolean[] testAns = new boolean[]{
                true, true, false
        };
        for (int i = 0; i < testS.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testS: " + testS[i]);
            System.out.println("testWordDict: " + Arrays.toString(testWordDict[i]));
            System.out.println("testAns: " + testAns[i]);
            boolean act = wordBreak(testS[i], Arrays.asList(testWordDict[i]));
            System.out.println("act: " + act);
        }

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        //TODO:

        return false;
    }

}
