package com.company.leetcode;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {3, 4, 5, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {11, 13, 15, 17},
                {5, 1, 2, 3, 4},
                {4, 5, 1, 2, 3},
        };
        int[] testAns = new int[]{
                1, 0, 11, 1, 1
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: " + testAns[i]);
            int act = findMin(testNums[i]);
            System.out.println("act: " + act);
        }

    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        if (nums[r] > nums[l]) {
            return nums[0];
        }
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

}
