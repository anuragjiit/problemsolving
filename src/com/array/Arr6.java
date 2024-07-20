/*
Given an array A, check if it is sorted in non-decreasing order or not.
Non-decreasing order means that the numbers in a sequence can stay the same or increase, but they cannot decrease.
Problem Constraints
1 <= Ai <= 109
1 <= |A| <= 105

Output Format
Return 1 if array is sorted else return 0.
A = [1, 2, 2]
 A = [1, 2, 1]
 */
package com.array;

public class Arr6 {
    public static void main(String[] args){
        int[] A = {1, 2, 2};
        int a = 0;
        for (int i=0; i< A.length; i++){
            if (A[i] <= A[A.length-1]){
                a = 1;
            }
            else if (A[i] > A[A.length-1]) {
                a = 0;
                break;
            }
        }
        System.out.println(a);
    }
}
