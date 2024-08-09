/*
Count no of ways to go from 0,0 cell to n-1, m-1
Allowed directions right & down
ex- take n = 2, n = 3

 */
package com.dynamicprograming;

public class CountWaysNoblocking {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int[][] dp = new int[n][m]; // ex taken ows = 2, column = 3

        for (int i=0; i<n; i++) {
            for (int j =0; j<m; j++) {
                if(i==0 || j==0) {
                    dp[i][j] =1;
                }
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);  // 3 number of ways to reach to n-1.m-1 from 0,0
    }
}
