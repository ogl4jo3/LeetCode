package com.company.leetcode.todo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class MergeIntervals {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][][] testNums = new int[][][]{
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                {{1, 4}, {4, 5}},
                {{1, 4}, {0, 4}},
                {{1, 4}, {2, 3}}
        };
        int[][][] testAns = new int[][][]{
                {{1, 6}, {8, 10}, {15, 18}},
                {{1, 5}},
                {{0, 4}},
                {{1, 4}}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: ");
            for (int[] nums : testNums[i]) {
                System.out.println(Arrays.toString(nums));
            }
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
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Deque<Interval> newIntervals = new ArrayDeque<>();
        newIntervals.push(new Interval(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (newIntervals.peek().end >= nextStart) {
                newIntervals.peek().end = Math.max(newIntervals.peek().end, nextEnd);
            } else {
                newIntervals.push(new Interval(nextStart, nextEnd));
            }
        }
        int[][] res = new int[newIntervals.size()][2];
        for (int i = newIntervals.size() - 1; i >= 0; i--) {
            Interval tmp = newIntervals.pop();
            res[i][0] = tmp.start;
            res[i][1] = tmp.end;
        }
        return res;
    }

    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}