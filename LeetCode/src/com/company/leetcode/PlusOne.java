package com.company.leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {1, 2, 3},
                {4, 3, 2, 1},
                {1, 9},
                {9, 9},
                {1}
        };
        int[][] testAns = new int[][]{
                {1, 2, 4},
                {4, 3, 2, 2},
                {2, 0},
                {1, 0, 0},
                {2}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: " + Arrays.toString(testAns[i]));
            int[] act = plusOne(testNums[i]);
            System.out.println("act: " + Arrays.toString(act));
        }

    }

    public static int[] plusOne(int[] digits) {
        boolean a = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (a) {
                digits[i] = digits[i] + 1;
            }
            if (digits[i] == 10) {
                digits[i] = 0;
                a = true;
            } else {
                a = false;
                break;
            }
        }
        if (a) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
