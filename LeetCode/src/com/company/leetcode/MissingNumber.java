package com.company.leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {3, 0, 1},
                {0, 1},
                {9, 6, 4, 2, 3, 5, 7, 0, 1},
                {0}
        };
        int[] testAns = new int[]{
                2, 2, 8, 1
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: " + testAns[i]);
            int act = missingNumber(testNums[i]);
            System.out.println("act: " + act);
        }

    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] numsExisted = new boolean[n + 1];
        for (int num : nums) {
            numsExisted[num] = true;
        }
        for (int i = 0; i < numsExisted.length; i++) {
            if (!numsExisted[i]) return i;
        }

        return -1;
    }

    public static int missingNumber2(int[] nums) {
        if (nums.length <= 0) return -1;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (n) * (n + 1) / 2 - sum;
    }
}
