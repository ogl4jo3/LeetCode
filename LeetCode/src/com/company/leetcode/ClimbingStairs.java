package com.company.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[] testN = new int[]{
                2, 3, 4, 6, 12
        };
        int[] testAns = new int[]{
                2, 3, 5, 13, 233
        };
        for (int i = 0; i < testN.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testN: " + testN[i]);
            System.out.println("testAns: " + testAns[i]);
            int act = climbStairs(testN[i]);
            System.out.println("act: " + act);
        }

    }

    public static int climbStairs(int n) {
        if (n <= 3) return n;
        int[] ansArray = new int[n + 1];
        ansArray[1] = 1;
        ansArray[2] = 2;
        ansArray[3] = 3;

        for (int i = 4; i < n + 1; i++) {
            ansArray[i] = ansArray[i - 1] + ansArray[i - 2];
        }

        return ansArray[n];
    }

}
