/*
Problem Description
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.



Problem Constraints
1 <= |A| <= 10^5
1 <= A[i] <= 10^5



Input Format
The first argument is an integer array A.



Output Format
Return an integer array that is the sorted array A.



Example Input
Input 1:

A = [1, 3, 1]

Input 2:

A = [4, 2, 1, 3]



Example Output
Output 1:

[1, 1, 3]

Output 2:

[1, 2, 3, 4]



Example Explanation
For Input 1:

The array in sorted order is [1, 1, 3].

For Input 2:

The array in sorted order is [1, 2, 3, 4].

 */
package com.sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3};
        int n = A.length;
        int max = A[0];

        for(int i=1; i<n;i++){
            if(A[i]>max) max = A[i];
        }

        int[] fre = new int[max+1];

        for(int i=0;i<n;i++){
            int num = A[i];
            fre[num]++;
        }
        int idx =0;

        for(int i=0; i<max+1; i++){
            int fr = fre[i];
            for(int j=0; j<fr; j++){
                A[idx]=i;
                idx++;
            }
        }
        System.out.println(Arrays.toString(A));
    }
}
