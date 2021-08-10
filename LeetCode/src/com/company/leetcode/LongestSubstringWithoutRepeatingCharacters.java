package com.company.leetcode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        String[] testS = new String[]{
                "abcabcbb", "bbbbb", "pwwkew", ""
        };
        int[] testAns = new int[]{
                3, 1, 3, 0
        };
        for (int i = 0; i < testS.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testS: " + testS[i]);
            System.out.println("testAns: " + testAns[i]);
            int act = lengthOfLongestSubstring(testS[i]);
            System.out.println("act: " + act);
        }

    }

    public static int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int longestLen = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            longestLen = Math.max(longestLen, i - left);
        }
        return longestLen;
    }

}
