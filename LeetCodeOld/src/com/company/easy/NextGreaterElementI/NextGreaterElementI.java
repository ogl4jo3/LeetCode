package com.company.easy.NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * Created by ogl4jo3 on 2017/3/5.
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] findNums = {4, 1, 2};
        int[] nums = {1, 3, 4, 2};
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        for (int findNum : findNums) System.out.println(findNum);

        /*int[] resIntArray = new int[findNums.length];
        for (int k = 0; k < findNums.length; k++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == findNums[k]) {
                    if (i + 1 == nums.length) {
                        resIntArray[k]=-1;
                        break;
                    }
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > nums[i]) {
                            resIntArray[k]=nums[j];
                            break;
                        } else if (nums[j] < nums[i] && j == nums.length - 1) {
                            resIntArray[k]=-1;
                        }

                    }
                }
            }
        }
        for (int i = 0; i < resIntArray.length; i++)
            System.out.println(resIntArray[i]);*/
    }
}
