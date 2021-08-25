package com.company.leetcode;


public class ValidPalindrome {

    public static void main(String[] args) {
        String[] testS = new String[]{
                "A man, a plan, a canal: Panama",
                "race a car",
                "0P"
        };
        boolean[] testAns = new boolean[]{
                true,
                false,
                false
        };
        for (int i = 0; i < testS.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testS:" + testS[i]);
            System.out.println("testAns:" + testAns[i]);
            boolean act = isPalindrome(testS[i]);
            System.out.println("act:" + act);
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            if (!((iChar >= '0' && iChar <= '9') || (iChar >= 'a' && iChar <= 'z') || (iChar >= 'A' && iChar <= 'Z'))) {
                i++;
                continue;
            } else if (!((jChar >= 48 && jChar <= 57) || (jChar >= 65 && jChar <= 90) || (jChar >= 97 && jChar <= 122))) {
                j--;
                continue;
            } else {
                if (Character.toLowerCase(iChar) != Character.toLowerCase(jChar)) return false;
            }

            i++;
            j--;
        }

        return true;
    }

}
