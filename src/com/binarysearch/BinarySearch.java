/*
Problem Description
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

    If the target value is present, return its index.
    If the target value is not found, return the index of least element greater than equal to B.
    If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)

Your solution should have a time complexity of O(log(N)).



Problem Constraints

1 <= N <= 105
1 <= A[i] <= 105
1 <= B <= 105



Input Format

The first argument is an integer array A of size N.
The second argument is an integer B.



Output Format

Return an integer denoting the index of target value.



Example Input

Input 1:

A = [1, 3, 5, 6]
B = 5

Input 2:

A = [1, 4, 9]
B = 3



Example Output

Output 1:

2

Output 2:

1


 */
package com.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {

        int[] A= new int[]{5,4,7,9,1,3,2};
        int B = 4;

        int e = A.length-1;
        int s = 0;

        while (s<=e) {
            int mid = (e-s)/2+s;

            if(A[mid]==B) {
                System.out.println(mid);
                System.exit(0);
            }

            if (B < A[mid]) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        System.out.println(s<A.length-1 ? s : A.length);

    }
}
