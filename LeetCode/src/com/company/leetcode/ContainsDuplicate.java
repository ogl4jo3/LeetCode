package com.company.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[][] testNums = new int[][]{
                {1, 2, 3, 1},
                {1, 2, 3, 4},
                {1, 1, 1, 3, 3, 4, 3, 2, 4, 2},
        };
        boolean[] testAns = new boolean[]{
                true, false, true
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testNums:" + Arrays.toString(testNums[i]));
            System.out.println("testAns: " + testAns[i]);
            boolean act = containsDuplicate(testNums[i]);
            System.out.println("act: " + act);
        }

    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

}
