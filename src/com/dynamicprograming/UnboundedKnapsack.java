/*
Problem Description

Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints

1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000



Input Format

First argument is the Weight of knapsack A

Second argument is the vector of values B

Third argument is the vector of weights C



Output Format

Return the maximum value that fills the knapsack completely



Example Input

Input 1:

A = 10
B = [5]
C = [10]

Input 2:

A = 10
B = [6, 7]
C = [5, 5]



Example Output

Output 1:

 5

Output 2:

14



Example Explanation

Explanation 1:

Only valid possibility is to take the given item.

Explanation 2:

Take the second item twice.

 */
package com.dynamicprograming;

public class UnboundedKnapsack {
    public static void main(String[] args) {

        int A = 10;
        int[] B = {6, 7};
        int[] C = {5, 5};
        int[] dp = new int[A+1];
        int n = B.length;
        // C > weight , B -> val, A -> capacity
        for (int i=1; i<=A; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=0; j<n; j++) {
                if(i-C[j]>=0){
                    max = Math.max(max, B[j]+dp[i-C[j]]);
                }
            }
            dp[i] = max;
        }
        System.out.println(dp[A]);
    }
}
