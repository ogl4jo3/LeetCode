package com.company.leetcode;


import java.util.Arrays;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[][] testNums = new int[][]{
                {1, 1, 2, 3, 3, 4, 4, 8, 8},
                {3, 3, 7, 7, 10, 11, 11},
                {1, 1, 2, 2, 3},
                {3, 7, 7, 10, 10, 11, 11}
        };
        int[] testAns = new int[]{
                2,
                10,
                3,
                3
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testNums:" + Arrays.toString(testNums[i]));
            System.out.println("testAns:" + testAns[i]);
            int act = singleNonDuplicate(testNums[i]);
            System.out.println("act:" + act);
        }

    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    if (mid % 2 == 0) {
                        r = mid - 2;
                    } else {
                        l = mid + 1;
                    }
                } else {//nums[mid] == nums[mid + 1]
                    if (mid % 2 == 0) {
                        l = mid + 2;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return nums[l];
    }

}
