/*
roblem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints

1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109



Input Format
First argument contains an array A of integers of size N



Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input
Input 1:

A = [2, 1, 6, 4]

Input 2:

A = [1, 1, 1]



Example Output
Output 1:

1

Output 2:

3

 */
package com.random;

public class SpecialIndexEvenOdd {
    public static void main(String[] args){
        int[] A = {2, 1, 6, 4};
        int n = A.length;
        int sumOdd=0, sumEven =0;
        int currOdd = 0;
        int currEven = A[0];
        int res = 0;
        int newEvenSum = 0;
        int newOddSum = 0;

//        if (n == 1) {
//            return 1;
//        }
//
//        if (n == 2)
//            return 0;

        for(int i=0; i<n;i++){
            if(i%2==0){
                sumEven+=A[i];
            } else sumOdd+=A[i];
        }
//        System.out.println(evenSum);
//        System.out.println(oddSum);


        for (int i = 1; i < n-1; i++) {
            if (i % 2 == 1) {
                currOdd += A[i];
                newEvenSum = currEven + sumOdd - currOdd;
                newOddSum = currOdd + sumEven - currEven - A[i];
            }
            else {
                currEven += A[i];
                newOddSum = currOdd + sumEven - currEven;
                newEvenSum = currEven + sumOdd - currOdd - A[i];
            }
            if (newEvenSum == newOddSum) {
                res++;
            }
        }

        if (sumOdd == sumEven - A[0]) {
            res++;
        }
        if (n-1 % 2 == 0) {
            if (sumOdd == sumEven - A[n - 1]) {
                res++;
            }
        }
        else {
            if (sumEven == sumOdd - A[n - 1]) {
                res++;
            }
        }

        System.out.println(res);
    }
}
