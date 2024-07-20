/*
Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints

    -10^8 <= B <= 10^8
    1 <= N <= 10^4
    -10^8 <= A[i] <= 10^8



Input Format

First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format

Return a single integer denoting the sum of three integers which is closest to B.



Example Input

Input 1:

A = [-1, 2, 1, -4]
B = 1

Input 2:


A = [1, 2, 3]
B = 6



Example Output

Output 1:

2

Output 2:

6



Example Explanation

Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

Explanation 2:

 Take all elements to get exactly 6.

 */
package com.twopointers;

import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{-1, 2, 1, -4};
        int checkSum = 1;

        long target = Integer.MAX_VALUE;

        Arrays.sort(inputArray);   // -10, -2, -1, 5, 10

        for (int i=0; i<inputArray.length-2; i++) {

            int j = i+1;
            int end = inputArray.length-1;

            while (j<end) {
                int first = inputArray[i];
                int second = inputArray[j];
                int third = inputArray[end];
                long sum = first + second + third;

                if (sum == checkSum) {
                    System.out.println(checkSum);
                    System.exit(0);
                }
                else if (Math.abs(sum - checkSum) < Math.abs(target - checkSum)) {
                    //
                    target = sum;
                }
                else if (sum > checkSum) {
                    end--;
                }
                else {
                    j++;
                }
            }
        }

       System.out.println(target);
    }
}
