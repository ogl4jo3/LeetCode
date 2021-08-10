package com.company.easy.FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by ogl4jo3 on 2017/3/12.
 */
public class findDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new ArrayList<>();
        boolean[] boolean_result = new boolean[nums.length];
        //Arrays.fill(boolean_result, false);
        for (int i = 0; i < nums.length; i++) {
            boolean_result[nums[i] - 1] = true;
        }
        for (int i = 0; i < boolean_result.length; i++) {
            if (!boolean_result[i]) result.add(i + 1);
        }
        System.out.println(result);
    }
}
