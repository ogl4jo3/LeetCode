package com.company.leetcode;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

        int[][] testCoins = new int[][]{
                {1, 2, 5},
                {2},
                {1},
                {1},
                {1}
        };
        int[] testAmount = new int[]{
                11, 3, 0, 1, 2
        };
        int[] testAns = new int[]{
                3, -1, 0, 1, 2
        };
        for (int i = 0; i < testCoins.length; i++) {
            System.out.println("================================================================");
            System.out.println("i: " + i);
            System.out.println("testCoins: " + Arrays.toString(testCoins[i]));
            System.out.println("testAmount: " + testAmount[i]);
            System.out.println("testAns: " + testAns[i]);
            int act = coinChange(testCoins[i], testAmount[i]);
            System.out.println("act: " + act);
        }

    }

    public static int coinChange(int[] coins, int amount) {
        int[] ansArray = new int[amount + 1];
        Arrays.fill(ansArray, amount + 1);
        ansArray[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    ansArray[i] = Math.min(ansArray[i], ansArray[i - coin] + 1);
                }
            }
        }
        return ansArray[amount] > amount ? -1 : ansArray[amount];
    }

}
