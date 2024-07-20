/*
Problem Description

Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).



Problem Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.



Output Format

Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].



Example Input

Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8

Input 2:

 A = [5, 17, 100, 111]
 B = 3



Example Output

Output 1:

 [3, 4]

Output 2:

 [-1, -1]



Example Explanation

Explanation 1:

 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]

Explanation 2:

 There is no occurrence of 3 in the array.
 */

package com.binarysearch;

import java.util.Arrays;

public class BinarySearchForRange {
    public static void main(String[] args) {

//        int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
//                3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7,
//                7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10,
//                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}; //118,133
//        int B = 10;

//        int[]A = {1, 2, 6, 9, 9};
//        int B  = 2;

        int[] A = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10};
        int B = 1;
        int[] ans = new int[] {-1,-1};
        if(A.length==1 && A[0]==B){
            System.out.println(Arrays.toString(new int[]{0,0}));
        }

        int e = A.length-1;
        int s = 0;
        int mid = 0;


        while (s<=e) {
            mid = (e-s)/2+s;
            if (mid<0 || mid>=A.length-1) break;
            else if(A[mid]==B && A[mid+1]>B) {
                break;
            }

            if (B < A[mid]) {
                e = mid-1;
            } else {
                s = mid+1;
            }


        }


        ans[1] = A[mid]==B ? mid : -1;

        mid =0;
        s=0;
        e = A.length-1;

        while (s<=e) {
            mid = (e-s)/2+s;

            if (mid<0 || mid>A.length-1) break;
            else if(A[mid]==B && mid-1>0  && A[mid-1]<B) {
                break;
            }

            if (B <= A[mid]) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        System.out.println(mid);

       ans[0] = A[mid]==B ? mid : -1;


        System.out.println(Arrays.toString(ans));

    }
}
