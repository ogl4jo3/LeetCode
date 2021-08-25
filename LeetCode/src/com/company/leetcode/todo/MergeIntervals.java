package com.company.leetcode.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][][] testNums = new int[][][]{
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                {{1, 4}, {4, 5}}
        };
        int[][][] testAns = new int[][][]{
                {{1, 6}, {8, 10}, {15, 18}},
                {{1, 5}}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testAns: ");
            for (int[] ans : testAns[i]) {
                System.out.println(Arrays.toString(ans));
            }
            int[][] act = merge(testNums[i]);
            System.out.println("act: ");
            for (int[] a : act) {
                System.out.println(Arrays.toString(a));
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<Interval> newIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

        }


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