package com.company.easy.SingleNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Created by ogl4jo3 on 2017/2/25.
 */
public class SingleNumber {


    public static void main(String[] args) {
        // write your code here
        System.out.println("輸入多個整數(以,隔開)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] number = str.split(",");
        int[] nums = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            nums[i] = Integer.parseInt(number[i]);
        }

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        System.out.print(ans);
    }
}