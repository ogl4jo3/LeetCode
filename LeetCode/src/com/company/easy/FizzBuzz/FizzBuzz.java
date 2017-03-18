package com.company.easy.FizzBuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * Created by ogl4jo3 on 2017/2/25.
 */
public class FizzBuzz {
    public static void main(String[] argv) {
        // write your code here
        int n ;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<String> s = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                s.add("FizzBuzz");
            else if (i % 5 == 0)
                s.add("Buzz");
            else if (i % 3 == 0)
                s.add("Fizz");
            else
                s.add(Integer.toString(i));
        }
        System.out.println(s);
    }
}
