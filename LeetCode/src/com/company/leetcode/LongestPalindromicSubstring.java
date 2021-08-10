package com.company.leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        String[] testS = new String[]{
                "babad", "cbbd", "a", "ac"
        };
        String[] testAns = new String[]{
                "bab", "bb", "a", "a"
        };
        for (int i = 0; i < testS.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testS: " + testS[i]);
            System.out.println("testAns: " + testAns[i]);
            String act = longestPalindrome(testS[i]);
            System.out.println("act: " + act);
        }

    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        int sLen = s.length();
        int startPos = 0;
        int maxLen = 0;
        for (int i = 0; i < sLen; ) {
            if (sLen - i <= maxLen / 2) break;
            int left = i;
            int right = i;
            while (right < sLen - 1 && s.charAt(right) == s.charAt(right + 1)) right++;
            i = right + 1;
            while (left > 0 && right < sLen - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left + 1 > maxLen) {
                startPos = left;
                maxLen = right - left + 1;
            }
        }

        return s.substring(startPos, startPos + maxLen);
    }
}
