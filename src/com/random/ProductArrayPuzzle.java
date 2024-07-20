/*
Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.

Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.


Input Format

The only argument given is the integer array A.

Output Format

Return the product array.

Constraints

2 <= length of the array <= 1000
1 <= A[i] <= 10

For Example

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]

 */
package com.random;

public class ProductArrayPuzzle {
    public static void  main(String[] args){
        int[] A = {1,2,3,4,5};
        int n = A.length;
        int[] pf = new int[n];
        int[] sf = new int[n];
        int[] ans = new int[n];
        pf[0] = A[0];
        sf[n-1] = A[n-1];

        for (int i=1; i<n; i++){
            pf[i] = pf[i-1]*A[i];
        }

        for (int i = n-2 ; i>=0; i--){
            sf[i] = sf[i+1]*A[i];
        }

        for (int i=0; i<n; i++){
            System.out.println(pf[i]);
        }

        for (int i=0; i<n; i++){
            System.out.println(sf[i]);
        }

        for (int i = 0 ; i<n; i++){
            if(i==0){
                ans[i]=sf[i+1];
            }else if(i==n-1){
                ans[i]=pf[i-1];

            } else {
                ans[i]=pf[i-1]*sf[i+1];
            }
        }

        for (int i=0; i<n; i++){
            System.out.println(ans[i]);
        }
    }
}
