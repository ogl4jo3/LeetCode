package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {1, 2, 3},
                {0, 1},
                {1}
        };
        int[][][] testAns = new int[][][]{
                {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}},
                {{0, 1}, {1, 0}},
                {{1}}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: ");
            for (int[] ans : testAns[i]) {
                System.out.println(Arrays.toString(ans));
            }
            List<List<Integer>> act = permute(testNums[i]);
            System.out.println("act: ");
            for (List<Integer> a : act) {
                System.out.println(Arrays.toString(a.toArray()));
            }
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, result, new ArrayList<>(), visited);
        return result;
    }

    public static void permute(int[] nums, List<List<Integer>> result, List<Integer> out, boolean[] visited) {
        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            out.add(nums[i]);
            permute(nums, result, out, visited);
            out.remove(out.size() - 1);
            visited[i] = false;
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute2(nums, result, 0);
        return result;
    }

    public static void permute2(int[] nums, List<List<Integer>> result, int start) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (Integer n : nums) {
                list.add(n);
            }
            result.add(list);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute2(nums, result, start + 1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
