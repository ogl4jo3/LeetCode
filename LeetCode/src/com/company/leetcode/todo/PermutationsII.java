package com.company.leetcode.todo;

import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {1, 1, 2},
                {1, 2, 3},
        };
        int[][][] testAns = new int[][][]{
                {{1, 1, 2}, {1, 2, 1}, {2, 1, 1}},
                {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}},
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
        //TODO:
        return null;
    }

}
