package com.company.leetcode.todo;

import java.util.Arrays;

public class InsertIntervals {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][][] testIntervals = new int[][][]{
                {{1, 3}, {6, 9}},
                {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                {},
                {{1, 5}},
                {{1, 5}},
                {{1, 5}},
                {{1, 5}},
                {{1, 5}}
        };
        int[][] testNewInterval = new int[][]{
                {2, 5},
                {4, 8},
                {5, 7},
                {2, 3},
                {2, 7},
                {6, 8},
                {0, 3},
                {0, 0}
        };
        int[][][] testAns = new int[][][]{
                {{1, 5}, {6, 9}},
                {{1, 2}, {3, 10}, {12, 16}},
                {{5, 7}},
                {{1, 5}},
                {{1, 7}},
                {{1, 5}, {6, 8}},
                {{0, 5}},
                {{0, 0}, {1, 5}}
        };
        for (int i = 0; i < testIntervals.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testIntervals: ");
            for (int[] nums : testIntervals[i]) {
                System.out.println(Arrays.toString(nums));
            }
            System.out.println("testNewInterval: ");
            System.out.println(Arrays.toString(testNewInterval[i]));
            System.out.println("testAns: ");
            for (int[] ans : testAns[i]) {
                System.out.println(Arrays.toString(ans));
            }
            int[][] act = insert(testIntervals[i], testNewInterval[i]);
            System.out.println("act: ");
            for (int[] a : act) {
                System.out.println(Arrays.toString(a));
            }
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //TODO:
        return null;
    }

    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}