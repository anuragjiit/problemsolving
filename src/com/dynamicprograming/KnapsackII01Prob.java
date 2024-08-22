/*
Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints

1 <= N <= 500

1 <= C, B[i] <= 10^6

1 <= A[i] <= 50



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50

Input 2:

 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10



Example Output

Output 1:

 22

Output 2:

 0



Example Explanation

Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22

Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.

 */
package com.dynamicprograming;

public class KnapsackII01Prob {
    static int helper(int[] A, int[] B, int C, int end, int[][] dp) {

        if (end==0) {
            if (B[end]<=C) {
                return A[end];
            }
            return 0;
        }

        if (C<=0) {
            return 0;
        }

        if (dp[end][C]!=-1) {
            return dp[end][C];
        }

        int include = A[end] + helper(A, B, C-B[end], end-1, dp);
        int exclude = helper(A, B, C, end-1, dp);

        if (B[end] <=C) {
            return dp[end][C] = Math.max( include, exclude );
        }
        else {
            dp[end][C] = exclude;
        }

        return dp[end][C];
    }

    public static void main(String[] args) {

        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;
        int n = A.length;
        int end = n-1;
        int[][] dp = new int[n+1][C+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=C; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(helper(A, B, C, end, dp));

        //---Approach 1 ---
   /*     for (int i=1; i<=n; i++) {
            for (int j=1; j<=C; j++) {
                int include =0;
                int exclude = dp[i-1][j];
                if (j-B[i-1] >=0) {
                    include = A[i-1]+dp[i-1][j-B[i-1]];
                }
                dp[i][j] = Math.max(include,exclude);
            }
        }

        System.out.println(dp[n][C]);  */

        //---Approach 2 ---
/*       int[] A = {6, 10, 12};
        int[] B = {10, 20, 30};
        int C = 50;
        int N = B.length;
        int[] dp = new int[C+1];

        for(int i = 1; i < N+1; i++){
            for(int j = C; j >= 0; j--){
                if(B[i-1] <= j){
                    dp[j] = Math.max(dp[j], A[i-1] + dp[j - B[i-1]]);
                }
            }
        }
        System.out.println(dp[C]); */
    }
}
