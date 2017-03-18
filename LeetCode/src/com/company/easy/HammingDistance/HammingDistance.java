package com.company.easy.HammingDistance;

import java.util.Scanner;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Created by ogl4jo3 on 2017/2/25.
 */
public class HammingDistance {
    public static void main(String[] argv) {
        // write your code here
        int x , y ;
        int distance = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("輸入x(x>=0):");
        do {
            x = sc.nextInt();
        } while (x < 0);
        System.out.println("輸入y(y<2^31):");
        y = sc.nextInt();
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        while (x > 0 || y > 0) {
            if (x % 2 != y % 2) {
                distance++;
            }
            x = x / 2;
            y = y / 2;
        }
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("distance:" + distance);
    }
}
