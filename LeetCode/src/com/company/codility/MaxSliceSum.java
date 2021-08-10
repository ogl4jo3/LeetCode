package com.company.codility;

public class MaxSliceSum {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

    }

    public int solution(int[] A) {
        //TODO:

        // initial setting A[0]
        int maxEndingPrevious = A[0];
        int maxEndingHere = A[0];
        int maxSoFar = A[0];

        // note: for i=0, it will return A[0] (also for "one element" cases)

        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], maxEndingPrevious + A[i]); // <--- key point~!!
            maxEndingPrevious = maxEndingHere;
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // update the max (be careful)
        }

        return maxSoFar; // can be used for "all negative" cases
    }

}
