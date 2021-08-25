package com.company.leetcode;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {1},
                {5, 4, -1, 7, 8}
        };
        int[] testAns = new int[]{
                6, 1, 23
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: " + testAns[i]);
            int act = maxSubArray(testNums[i]);
            System.out.println("act: " + act);
        }

    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxValue) {
                maxValue = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxValue;
    }

}
