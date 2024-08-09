/*
Count no of ways to go from n-1,m-1 to 0,0 cell
Allowed directions left & up .. 0 blocked, 1 unblocked
 */
package com.dynamicprograming;

public class CountWaysBlocking {
    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1,1,1,1},
                {1,0,1,0},   // ans = 3 ways
                {0,1,1,1},
                {1,0,1,1},
                {1,1,1,1}
             };
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        if (mat.length==0) {
            System.out.println(0);
            System.exit(0);
        } else if (mat[0][0] ==0 || mat[n-1][m-1]==0) {
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j]==0){
                    dp[i][j] = 0;
                }
                else if( i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else if(i == 0){
                    dp[i][j] = dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(dp[i][j]);
            }
            System.out.println("----------------");
        }

      System.out.println(dp[n-1][m-1]);
    }
}
