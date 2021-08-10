package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        int[] testN = new int[]{
                3, 1
        };
        List<List<String>> testAns = new ArrayList<>();
        testAns.add(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
        testAns.add(Arrays.asList("()"));
        for (int i = 0; i < testN.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testN: " + testN[i]);
            System.out.println("testAns: " + Arrays.toString(testAns.get(i).toArray()));
            List<String> act = generateParenthesis(testN[i]);
            System.out.println("act: " + act);
        }

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, "", 0, 0);
        return result;
    }

    private static void dfs(List<String> result, int n, String str, int left, int right) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left > n || right > n || left < right) {
            return;
        }
        dfs(result, n, str + "(", left + 1, right);
        dfs(result, n, str + ")", left, right + 1);
    }

}
