/*
Problem Description
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].

Return the number of important reverse pairs in the given array A.



Problem Constraints

1 <= length of the array <= 10^5

-2 * 10^9 <= A[i] <= 2 * 10^9



Input Format

The only argument given is the integer array A.



Output Format

Return the number of important reverse pairs in the given array A.



Example Input

Input 1:

 A = [1, 3, 2, 3, 1]

Input 2:

 A = [4, 1, 2]



Example Output

Output 1:

 2

Output 2:

 1



Example Explanation

Explanation 1:

 There are two pairs which are important reverse pair
 i.e  (1, 4) => A[1] > 2 * A[4] => 3 > 2 * 1 => 3 > 2 and
      (3, 4) => A[3] > 2 * A[4] => 3 > 2 * 1 => 3 > 2.

Explanation 2:

 There is only one pair
 i.e (0, 1) => A[0] > 2 * A[1] => 4 > 2 * 1 => 4 > 1
 */
package com.sort;

import java.util.Arrays;

public class ReversePairMergeSort {

    public static int count =0;
    private static final int MOD = 1000000007;

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
            if((long)left[i]>(long)2*right[j]){
                j++;
                count=(count+n1-i)%MOD;

            } else i++;
        }


        i=0; j=0; index = l;

        while (i<n1 && j<n2){
            if(left[i]<=right[j]){
                A[index] = left[i];
                i++;
            } else {
                A[index] = right[j];
                j++;
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
        int[] A = {2000000000,2000000000,-2000000000};
        int n  = A.length;
        mergeSort(A, 0, n-1);
        System.out.println(count);
        System.out.println(Arrays.toString(A));
    }
}
