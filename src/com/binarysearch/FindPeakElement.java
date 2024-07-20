/*
Problem Description

Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

    It is guaranteed that the array contains only a single peak element.
    Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.



Output Format

Return the peak element.



Example Input

Input 1:

A = [1, 2, 3, 4, 5]

Input 2:

A = [5, 17, 100, 11]



Example Output

Output 1:

 5

Output 2:

 100



Example Explanation

Explanation 1:

 5 is the peak.

Explanation 2:

 100 is the peak.
 */
package com.binarysearch;

public class FindPeakElement {
    public static void main(String[] args) {

     //   int[] A = {18,33,100,135,203,270,292,310,356,392,400,429,436,461,427,403,399,375,251,245,173,130,43};
        int[] A = {1,1000000000,1000000000};
        int e = A.length-1;
        int s = 0;
        int mid = 0;
        if(A[s]>=A[s+1]){
            System.out.println(A[s]);
            System.exit(0);
        } else if (A[e]>=A[e-1]) {
            System.out.println(A[e]);
            System.exit(0);
        }

        while(s<=e) {
            mid = (e-s)/2+s;

            if(mid > 0 && mid < A.length-1 && A[mid]>A[mid-1] && A[mid]>A[mid+1]) {
                System.out.println(A[mid]);
                System.exit(0);
            }

            if(A[mid]<A[mid+1]) s = mid+1;
            else e = mid-1;
        }


        System.out.println(A[mid]);
    }
}
