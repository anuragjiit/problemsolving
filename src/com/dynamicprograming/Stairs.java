/*
Problem Description

You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007



Problem Constraints

1 <= A <= 10^5



Input Format

The first and the only argument contains an integer A, the number of steps.



Output Format

Return an integer, representing the number of ways to reach the top.



Example Input

Input 1:

 A = 2

Input 2:

 A = 3



Example Output

Output 1:

 2

Output 2:

 3



Example Explanation

Explanation 1:

 Distinct ways to reach top: [1, 1], [2].

Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
package com.dynamicprograming;

public class Stairs {
    public static void main(String[] args) {
        int mod = 1000000007;
        int input = 1000;
        //since Each time you can either climb 1 or 2 steps, we can use finonacci concept to store the data i.e n-1 + n-2
        // min step to climb 0 or 1 step will be 1, that would be base case

        if ( input == 0 || input == 1) {
            System.out.println(1);
            System.exit(0);
        }
        long ans = 0L;
        long zero = 1L;
        long first = 1L;

        for (int i=2; i<=input; i++) {
            ans = zero+first;
            ans %= mod;
            zero = first;
            first = ans;
        }
        System.out.println(ans);
    }
}
