/*
Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.



Problem Constraints

1 <= A <= 10^5



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the minimum count.



Example Input

Input 1:

 A = 6

Input 2:

 A = 5



Example Output

Output 1:

 3

Output 2:

 2



Example Explanation

Explanation 1:

 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3.

Explanation 2:

 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
package com.dynamicprograming;

public class MinNumSquares {
    public static void main(String[] args) {
        int input = 12;
        int[] arr = new int[input+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i=2; i<=input; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        for (int i=2; i<=input; i++) {
            for (int x=1; x*x<=i; x++) {
                arr[i] = Math.min(arr[i], arr[i-(x*x)]);
            }
            arr[i]+=1;
        }

       System.out.println(arr[input]);
    }
}
