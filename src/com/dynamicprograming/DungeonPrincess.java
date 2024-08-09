/*
Problem Description

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.



Problem Constraints

1 <= M, N <= 500

-100 <= A[i] <= 100



Input Format

First and only argument is a 2D integer array A denoting the grid of size M x N.



Output Format

Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.



Example Input

Input 1:

 A = [
       [-2, -3, 3],
       [-5, -10, 1],
       [10, 30, -5]
     ]

Input 2:

 A = [
       [1, -1, 0],
       [-1, 1, -1],
       [1, 0, -1]
     ]



Example Output

Output 1:

 7

Output 2:

 1
 */
package com.dynamicprograming;

public class DungeonPrincess {
    public static void main(String[] args) {
        int[][] A = new int[][] {
                {1, -1, 0},
                {-1, 1, -1},
                {1, 0, -1}
//                {-2, -3, 3},
//                {-5, -10, 1},
//                {10, 30, -5}
              };
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        // TC : O(n*m) .. SC : O(n+m)
        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                if (i==n-1 && j==m-1) {
                    int num = 1-A[i][j];
                    dp[i][j] = num <=0 ? 1 : num;
                }
                else if (i==n-1) {
                    int num = dp[i][j+1]-A[i][j];
                    dp[i][j] = num <=0 ? 1 : num;
                }
                else if (j==m-1) {
                    int num = dp[i+1][j]-A[i][j];
                    dp[i][j] = num <=0 ? 1 : num;
                }
                else {
                    int right = dp[i][j+1]-A[i][j];
                    int down = dp[i+1][j]-A[i][j];
                    int num = Math.min(right,down);
                    dp[i][j] = num <=0 ? 1 : num;
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
