/*
Problem Description

Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints

1 <= length of the array <= 10^5

1 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.



Output Format

Return the number of inversions of A modulo (10^9 + 7).



Example Input

Input 1:

A = [1, 3, 2]

Input 2:

A = [3, 4, 1, 2]



Example Output

Output 1:

1

Output 2:

4



Example Explanation

Explanation 1:

The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]

Explanation 2:

The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]

 */
package com.sort;

import java.util.Arrays;
import java.util.Optional;


public class InversionCountMergeSort {
    public static int count =0;

    public static void mergeSort(int[] A, int l, int r){

        if(l==r) return;

        int mid = (l+r)/2;
        mergeSort(A, l, mid);
        mergeSort(A,mid+1, r);
        merge(A, l, r, mid);

    }

    public static void merge(int[] A, int l, int r, int mid){
        int n1= mid-l+1;
        int n2 = r-mid;


        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i =0; i<n1; i++){
            left[i]=A[l+i];
        }

        for (int i =0; i<n2; i++){
            right[i]=A[mid+1+i];
        }


        int i=0, j=0, index = l;

        while (i<n1 && j<n2){
            if(left[i]<=right[j]){
                A[index] = left[i];
                i++;
            } else {
                A[index] = right[j];
                j++;
                count+=n1-i;

            }
            index++;
        }

        while (i<n1){
            A[index]=left[i];
            i++;
            index++;

        }

        while (j<n2){
            A[index]=right[j];
            j++;
            index++;

        }


    }


    public static void main(String[] args) {
    //    int[] A = {45, 10, 15, 25, 50};
        int[] A = {1, 3, 2};
        int n  = A.length;
        mergeSort(A, 0, n-1);
        System.out.println(count);
        System.out.println(Arrays.toString(A));
    }
}
