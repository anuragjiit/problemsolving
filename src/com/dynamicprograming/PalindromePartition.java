/*
Given a String, find minimum partition such that every subString is a palindrome
ex => ab -> 1 partition i.e a | b
aab => aa | b -> 1 partition
a | lgl | cdc | f | opo => 4 partition
 */
package com.dynamicprograming;

public class PalindromePartition {
    public static void main(String[] args) {
//        System.out.println(minCut("a"));
//        System.out.println(minCut("ab"));
//        System.out.println(minCut("aab"));
        System.out.println(minCut("alglcdcfopo"));
    }

    public static int minCut(String str) {
        int n = str.length();
        int[] dp = new int[n];
        boolean[][] isPalindrome = isPalindrome(str);

        for (int i=0; i<n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int k=i; k>=1; k--) {
                if (isPalindrome[k][i]) {
                    dp[i] = Math.min(dp[i], 1+dp[k-1]);
                }
            }
        }
        return dp[n-1];
    }

    public static boolean[][] isPalindrome(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
// Len = 2
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        int len = 3;
        while (len <= n) {
            int i = 0;
            int j = i + len - 1;
            while (i <= n - len) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                i++;
                j++;
            }
            len++;
        }
        return dp;
    }
}
