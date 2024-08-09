/*
Problem Description

Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.

Return the maximum possible sum.

Note: You are allowed to choose more than 2 numbers from the grid.



Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000



Input Format

The first and the only argument of input contains a 2d matrix, A.



Output Format

Return an integer, representing the maximum possible sum.



Example Input

Input 1:

 A = [
        [1]
        [2]
     ]

Input 2:

 A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
     ]



Example Output

Output 1:

 2

Output 2:

 8

Example Explanation

Explanation 1:

 We will choose 2 (From 2nd row 1st column).

Explanation 2:

 We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
 */
package com.dynamicprograming;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {74, 37, 82, 1},
                {66, 38, 16, 1}
        };


        int n = arr[0].length;
        int[] dp = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = Math.max(arr[0][i], arr[1][i]);
        }

        if (n == 1 ) {
            System.out.println(dp[0]);
            System.exit(0);
        }
        else if (n == 2 ) {
            System.out.println(Math.max(dp[0],dp[1]));
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            if(i==0){
                ans[0]=dp[0];
            } else if (i==1) {
                ans[1] = Math.max(dp[0],dp[1]);
            }
            else {
                ans[i] = Math.max(ans[i-1],dp[i]+ans[i-2]);
            }
        }

        System.out.println(ans[n-1]);

    }
}
