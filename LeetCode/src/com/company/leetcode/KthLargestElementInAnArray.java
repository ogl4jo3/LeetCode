package com.company.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        int[][] testNums = new int[][]{
                {3, 2, 1, 5, 6, 4},
                {3, 2, 3, 1, 2, 4, 5, 5, 6}
        };
        int[] testK = new int[]{
                2, 4
        };
        int[] testAns = new int[]{
                5, 4
        };
        for (int i = 0; i < testNums.length; i++) {
            System.out.println("================================================================");
            System.out.println("i:" + i);
            System.out.println("testNums:" + Arrays.toString(testNums[i]));
            System.out.println("testK:" + testK[i]);
            System.out.println("testAns:" + testAns[i]);
            int act = findKthLargest(testNums[i], testK[i]);
            System.out.println("act:" + act);
        }

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
            } else {
                if (nums[i] >= heap.peek()) {
                    heap.poll();
                    heap.offer(nums[i]);
                }
            }
        }

        return heap.peek();
    }

}
