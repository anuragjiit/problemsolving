/*
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.


Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the array A after rotating it B times to the right
 */
package com.array;

public class ReverseKtimes {


    public static void reverse(int[]A, int i, int j){
        while (i<j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args){
        int[] A = {1, 2, 3, 4};
 //       1,1,4,9,4,7,1
 //       1,1,1,4,9,4,7

        int B =2;
        int i=0;
        int n = A.length;
        reverse(A,i,n-1);
        if (B>n){
            B=B%n;
            if (B==0){
                System.out.println(A);
            }
        }
        reverse(A,0,B-1);
        reverse(A,B,n-1);
    System.out.println(A);
        }

}
