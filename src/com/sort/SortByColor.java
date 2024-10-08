/*
Problem Description

Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will represent the colors as,

red -> 0
white -> 1
blue -> 2

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2



Input Format
First and only argument of input contains an integer array A.



Output Format
Return an integer array in asked order



Example Input
Input 1 :

    A = [0, 1, 2, 0, 1, 2]

Input 2:

    A = [0]



Example Output
Output 1:

    [0, 0, 1, 1, 2, 2]

Output 2:

    [0]



Example Explanation
Explanation 1:

    [0, 0, 1, 1, 2, 2] is the required order.

Explanation 2:

    [0] is the required order
 */

// as array ha only 0,1,2.. count sort can be used

package com.sort;

import java.util.Arrays;

public class SortByColor {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 2, 0, 1, 2};

        int max = A[0];
        int n = A.length;

        for(int i=1; i<n; i++){
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
