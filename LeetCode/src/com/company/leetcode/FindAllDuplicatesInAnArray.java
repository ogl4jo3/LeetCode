package com.company.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[][] testNums = new int[][]{
                {4, 3, 2, 7, 8, 2, 3, 1},
                {1, 1, 2},
                {1}
        };
        int[][] testAns = new int[][]{
                {2, 3},
                {1},
                {}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testNums:" + Arrays.toString(testNums[i]));
            System.out.println("testAns:" + Arrays.toString(testAns[i]));
            int[] act = findDuplicates(testNums[i]).stream().mapToInt(Integer::intValue).toArray();
            System.out.println("act:" + Arrays.toString(act));
        }

    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] tmp = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (tmp[nums[i]])
                res.add(nums[i]);
            else
                tmp[nums[i]] = true;
        }
        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }


}
