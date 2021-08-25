package com.company.leetcode;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testNums = new int[][]{
                {1, 1, 1, 2, 2, 3},
                {1}
        };
        int[] testK = new int[]{
                2, 1
        };
        int[][] testAns = new int[][]{
                {1, 2},
                {1}
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testNums: " + Arrays.toString(testNums[i]));
            System.out.println("testK: " + testK[i]);
            System.out.println("testAns: " + Arrays.toString(testAns[i]));
            int[] act = topKFrequent(testNums[i], testK[i]);
            System.out.println("act: " + Arrays.toString(act));
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return new int[]{nums[0]};
        Map<Integer, Integer> map = new HashMap<>();// value, times
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] res = new int[priorityQueue.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : priorityQueue) {
            res[i++] = entry.getKey();
        }

        return res;
    }

}
