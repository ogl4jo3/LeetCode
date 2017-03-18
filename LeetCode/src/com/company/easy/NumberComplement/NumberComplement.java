package com.company.easy.NumberComplement;

/**
 * Created by ogl4jo3 on 2017/2/27.
 */
public class NumberComplement {
    public static void main(String[] args) {
        // write your code here
        int num = 5;
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        System.out.println(mask);
        System.out.println(mask-num);


    }
}
