package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        int[] testN = new int[]{
                4, 1
        };
        int[] testK = new int[]{
                2, 1
        };
        int[][][] testAns = new int[][][]{
                {{2, 4}, {3, 4}, {2, 3}, {1, 2}, {1, 3}, {1, 4}},
                {{1}}
        };
        for (int i = 0; i < testN.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testN: " + testN[i]);
            System.out.println("testK: " + testK[i]);
            System.out.println("testAns: ");
            for (int[] ans : testAns[i]) {
                System.out.println(Arrays.toString(ans));
            }
            List<List<Integer>> act = combine(testN[i], testK[i]);
            System.out.println("act: ");
            for (List<Integer> a : act) {
                System.out.println(Arrays.toString(a.toArray()));
            }
        }

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(n, k, res, 1, new ArrayList<>());
        return res;
    }

    public static void combine(int n, int k, List<List<Integer>> res, int level, List<Integer> out) {
        if (out.size() == k) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = level; i <= n; i++) {
            out.add(i);
            combine(n, k, res, i + 1, out);
            out.remove(out.size() - 1);
        }

    }

}
