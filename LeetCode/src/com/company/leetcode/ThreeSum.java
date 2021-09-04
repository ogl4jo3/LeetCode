package com.company.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[][] testNums = new int[][]{
                {-1, 0, 1, 2, -1, -4},
                {},
                {0},
                {0, 0, 0},
                {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}
        };
        int[][][] testAns = new int[][][]{
                {{-1, -1, 2}, {-1, 0, 1}},
                {},
                {},
                {{0, 0, 0}},
                {{-4, 0, 4}, {-4, 1, 3}, {-3, -1, 4}, {-3, 0, 3}, {-3, 1, 2}, {-2, -1, 3}, {-2, 0, 2}, {-1, -1, 2}, {-1, 0, 1}}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testNums:" + Arrays.toString(testNums[i]));
            System.out.println("testAns: ");
            for (int[] ans : testAns[i]) {
                System.out.println(Arrays.toString(ans));
            }
            List<List<Integer>> act = threeSum(testNums[i]);
            System.out.println("act: ");
            for (List<Integer> content : act) {
                System.out.println(Arrays.toString(content.toArray()));
            }
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println("sorted nums:" + Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
                while (j > i + 1 && j < k && nums[j] == nums[j - 1]) j++;
                while (k < nums.length - 2 && j < k && nums[k] == nums[k + 1]) k--;
            }
        }

        return ans;
    }

}
