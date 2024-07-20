/*Problem Description
        Given an array A of size N, Groot wants you to pick 2 indices i and j such that

        1 <= i, j <= N
        A[i] % A[j] is maximum among all possible pairs of (i, j).
        Help Groot in finding the maximum value of A[i] % A[j] for some i, j.



        Problem Constraints
        1 <= N <= 100000
        0 <= A[i] <= 100000



        Input Format
        First and only argument in an integer array A.
        */
package com.array;

import java.util.Arrays;

public class MaxMod {
    public static void main(String[] args){
        //    int[] A= {3, 3};
        int[] A = {6,4};
        Arrays.sort(A);
        int last = A[A.length-1];
        int previous = A[A.length-1];

        for (int i=A.length-1; i>0; i--) {

            previous = A[i-1];

            if (last!=previous){
                System.out.println(previous%last);
                System.exit(0);
            }
        }
        System.out.println(A[0] % A[A.length-1]);

    }
}
