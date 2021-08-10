package com.company.leetcode;


import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[][] testS = new char[][]{
                {'h', 'e', 'l', 'l', 'o'},
                {'d', 'c', 'b', 'a'}
        };
        char[][] testAns = new char[][]{
                {'o', 'l', 'l', 'e', 'h'},
                {'a', 'b', 'c', 'd'}
        };
        for (int i = 0; i < testS.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testS:" + Arrays.toString(testS[i]));
            System.out.println("testAns:" + Arrays.toString(testAns[i]));
            char[] act = testS[i].clone();
            reverseString(act);
            System.out.println("act:" + Arrays.toString(act));
        }
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
