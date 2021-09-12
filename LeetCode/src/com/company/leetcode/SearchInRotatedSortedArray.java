package com.company.leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {4, 5, 6, 7, 0, 1, 2},
                {4, 5, 6, 7, 0, 1, 2},
                {1},
                {6, 0, 1, 2, 3, 4, 5},
                {2, 4, 5, 6, 7, 0, 1},
                {1, 3}
        };
        int[] testTarget = new int[]{
                0, 3, 0, 0, 4, 3
        };
        int[] testAns = new int[]{
                4, -1, -1, 1, 1, 1
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testTarget: " + testTarget[i]);
            System.out.println("testAns: " + testAns[i]);
            int act = search(testNums[i], testTarget[i]);
            System.out.println("act: " + act);
        }

    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[r]) { //代表左半邊為遞減
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { //代表右半邊為遞增
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
