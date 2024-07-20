/*
Problem Description

Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

Note: A linear time complexity is expected and you should avoid use of any library function.



Problem Constraints

-2×10^9 <= A[i], B[i] <= 2×10^9
1 <= |A|, |B| <= 5×10^4



Input Format

First Argument is a 1-D array representing  A.
Second Argument is also a 1-D array representing B.



Output Format

Return a 1-D vector which you got after merging A and B.



Example Input

Input 1:

A = [4, 7, 9]
B = [2, 11, 19]

Input 2:

A = [1]
B = [2]

 */
package com.sort;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[]A = {4, 7, 9};
        int[]B ={2, 11, 19};

        int n1 = A.length;
        int n2 = B.length;
        int[] ans = new int[n1+n2];
        int index = 0;
        int i = 0, j=0;


        while (i<n1 && j<n2){
            if(A[i]<=B[j]){
                ans[index] = A[i];
                i++;
            } else {
                ans[index]=B[j];
                j++;
            }
            index++;
        }

        while(i<n1){
            ans[index]=A[i];
            i++;
            index++;
        }
        while(j<n2){
            ans[index]=B[j];
            j++;
            index++;
        }

        System.out.println(Arrays.toString(ans));
    }
}
