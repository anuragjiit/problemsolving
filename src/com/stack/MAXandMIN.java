/*
Problem Description

Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format

The first and only argument given is the integer array A.



Output Format

Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input

Input 1:

 A = [1]

Input 2:

 A = [4, 7, 3, 8]



Example Output

Output 1:

 0

Output 2:

 26



Example Explanation

Explanation 1:

Only 1 subarray exists. Its value is 0.

Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26

 */
package com.stack;

import java.util.Stack;

public class MAXandMIN {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 3, 8}; // outopt -> 26
        int len = arr.length;
        long mod = 1000000007L;
        long result = 0;
        int[] nearSmallLeft = nearestSmallLeft(arr);
        int[] nearSmallRight = nearestSmallRight(arr);
        int[] nearGreaterLeft = nearestGreaterLeft(arr);
        int[] nearGreaterRight = nearestGreaterRight(arr);

        for (int i=0; i<len; i++){
            long max = (long) (i-nearGreaterLeft[i]) * (nearGreaterRight[i]-i);  // without 1L multiplication, hard test cases were failing. or type cast to long
            long min = (long) (i-nearSmallLeft[i]) * (nearSmallRight[i]-i);
            result += arr[i] * (max-min);
        }
        result%=mod;

        System.out.println((int)result);
    }

    public static int[] nearestGreaterLeft(int[] arr) {
        int len = arr.length;
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<len; i++) {
            while( !stack.isEmpty() && arr[i] >= arr[stack.peek()] ) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(i);
        }


        return result;
    }

    public static int[] nearestGreaterRight(int[] arr) {
        int len = arr.length;
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=len-1; i>=0; i--) {
            while( !stack.isEmpty() && arr[i] >= arr[stack.peek()] ) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            } else {
                result[i] = len;
            }

            stack.push(i);
        }
        return result;
    }

    public static int[] nearestSmallLeft(int[] arr) {
        int len = arr.length;
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<len; i++) {
            while( !stack.isEmpty() && arr[i] <= arr[stack.peek()] ) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(i);
        }
        return result;
    }

    public static int[] nearestSmallRight(int[] arr) {
        int len = arr.length;
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=len-1; i>=0; i--) {
            while( !stack.isEmpty() && arr[i] <= arr[stack.peek()] ) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            } else {
                result[i] = len;
            }

            stack.push(i);
        }
        return result;
    }
}
