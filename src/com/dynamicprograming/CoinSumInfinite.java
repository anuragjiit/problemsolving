/*
Problem Description

You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

    Coins in set A will be unique. Expected space complexity of this problem is O(B).
    The answer can overflow. So, return the answer % (10^6 + 7).



Problem Constraints

1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format

First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format

Return an integer denoting the number of ways.



Example Input

Input 1:

 A = [1, 2, 3]
 B = 4

Input 2:

 A = [10]
 B = 10



Example Output

Output 1:

 4

Output 2:

 1



Example Explanation

Explanation 1:

 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}

Explanation 2:

 There is only 1 way to make sum 10.
 */
package com.dynamicprograming;

public class CoinSumInfinite {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        int B = 4;
        int n = A.length;
        int[] dp = new int[B+1];
        int mod = 1000007;
        dp[0] = 1;

        for (int i=0; i<n; i++) {
            for (int j=1; j<=B; j++) {
                if (j-A[i] >=0 ) {
                    dp[j] += dp[j-A[i]];
                    dp[j] %= mod;
                }
            }
        }

        System.out.println(dp[B]);

//        for (int i=1; i<=B; i++) {
//            int sum = 0;
//            for (int j=0; j<n; j++) {
//                if (i-A[j] >= 0 ) {
//                    sum+= dp[i-A[j]];
//                    sum %= mod;
//                }
//            }
//            dp[i] = sum;
//        }
//        System.out.println(dp[B]);
    }
}
