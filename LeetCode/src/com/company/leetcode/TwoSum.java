package com.company.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[][] testNums = new int[][]{
                {2, 7, 11, 15},
                {3, 2, 4},
                {3, 3}
        };
        int[] testTarget = new int[]{
                9, 6, 6
        };
        int[][] testAns = new int[][]{
                {0, 1},
                {1, 2},
                {0, 1}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testNums:" + Arrays.toString(testNums[i]));
            System.out.println("testTarget:" + testTarget[i]);
            System.out.println("testAns:" + Arrays.toString(testAns[i]));
            int[] act = twoSum(testNums[i], testTarget[i]);
            System.out.println("act:" + Arrays.toString(act));
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int numsLen = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numsLen; i++) {
            map.put((target - nums[i]), i);
        }
        for (int i = 0; i < numsLen; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
