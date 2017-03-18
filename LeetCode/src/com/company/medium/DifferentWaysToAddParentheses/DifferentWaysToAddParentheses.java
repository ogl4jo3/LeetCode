package com.company.medium.DifferentWaysToAddParentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * Created by ogl4jo3 on 2017/2/25.
 */
public class DifferentWaysToAddParentheses {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String input_part1 = input.substring(0, i);
                String input_part2 = input.substring(i + 1);
                List<Integer> res_part1 = diffWaysToCompute(input_part1);
                List<Integer> res_part2 = diffWaysToCompute(input_part2);
                //2 - 1 - 1
                //2 * 3 - 4 * 5
                for (int x : res_part1) {
                    for (int y : res_part2) {
                        int res = 0;
                        if (input.charAt(i) == '+') {
                            res = x + y;
                        } else if (input.charAt(i) == '-') {
                            res = x - y;
                        } else if (input.charAt(i) == '*') {
                            res = x * y;
                        }
                        results.add(res);
                    }
                }
            }
        }
        if (results.size() == 0) {
            results.add(Integer.parseInt(input));
        }
        return results;
    }

    public static void main(String[] args) {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> results = diffWaysToCompute(input);
        for (int res : results) {
            System.out.print(res + " ");
        }
    }
}
