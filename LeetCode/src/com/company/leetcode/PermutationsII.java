package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {1, 1, 2},
                {1, 2, 3},
                {2, 2, 1, 1}
        };
        int[][][] testAns = new int[][][]{
                {{1, 1, 2}, {1, 2, 1}, {2, 1, 1}},
                {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}},
                {{1, 1, 2, 2}, {1, 2, 1, 2}, {1, 2, 2, 1}, {2, 1, 1, 2}, {2, 1, 2, 1}, {2, 2, 1, 1}}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: ");
            for (int[] ans : testAns[i]) {
                System.out.println(Arrays.toString(ans));
            }
            List<List<Integer>> act = permuteUnique(testNums[i]);
            System.out.println("act: ");
            for (List<Integer> a : act) {
                System.out.println(Arrays.toString(a.toArray()));
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, result, 0);
        return result;
    }

    public static void permuteUnique(int[] nums, List<List<Integer>> result, int start) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (Integer n : nums) {
                list.add(n);
            }
            result.add(list);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
//            if (nums[i] == nums[start] && i != start) continue;
            if (set.add(nums[i])) {
                swap(nums, start, i);
                permuteUnique(nums, result, start + 1);
                swap(nums, start, i);
            }

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}