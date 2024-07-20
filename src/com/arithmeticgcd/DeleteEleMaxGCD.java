/*
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints

2 <= N <= 105
1 <= A[i] <= 109



Input Format

First argument is an integer array A.



Output Format

Return an integer denoting the maximum value of GCD.



Example Input

Input 1:

 A = [12, 15, 18]

Input 2:

 A = [5, 15, 30]



Example Output

Output 1:

 6

Output 2:

 15

 */
package com.arithmeticgcd;

public class DeleteEleMaxGCD {

    public static int gcd(int a, int b){

        if (a == 0 ) return b;

        if (a > b) {
            return gcd(a%b, b);
        }

        return gcd(b%a, a);
    }

    public static void main(String[] args) {
        int[] A = {12, 15, 24, 18, 30};
        int n = A.length;
        int[] preGCD = new int[n];
        int[] sufGCD = new int[n];
        preGCD[0] = A[0];
        sufGCD[n-1] = A[n-1];

        for (int i=1; i<n; i++){
            preGCD[i] = gcd(A[i],preGCD[i-1]);
        }
        for (int i=n-2; i>=0; i--){
            sufGCD[i] = gcd(sufGCD[i+1],A[i]);
        }

       int ans = 0;
        int gcd1 = 0;

        for (int i =0; i<n; i++){

            if (i == 0){
                gcd1 = sufGCD[i+1];
            } else if (i == n-1){
                gcd1 = preGCD[i-1];
            } else {
                gcd1 = gcd(preGCD[i-1], sufGCD[i+1]);
            }

            ans = Math.max(gcd1, ans);
        }


        System.out.println(ans);
    }
}
