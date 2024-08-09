/*
Problem Description

Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.



Problem Constraints

0 <= A <= 44



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the Ath Fibonacci number.



Example Input

Input 1:

 A = 4

Input 2:

 A = 6



Example Output

Output 1:

 3

Output 2:

 8



Example Explanation

Explanation 1:

 Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 0th term is 0 So, 4th term of Fibonacci series is 3.

Explanation 2:

 6th term of Fibonacci series is 8.
 */
package com.dynamicprograming;

import java.util.Scanner;

public class FibonacciNum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        if (num == 0 || num == 1) {
            System.out.println(num);
            System.exit(0);
        }

 /*       // option 1 : TC: O(n) ... SC : O(n)
        int[] arr = new int[num+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i=2; i<=num; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }

        System.out.println(arr[num]); */

    //option 2 - TC: O(n) ... SC : O(1)

        int first = 0;
        int second = 1;
        int sum = 0;

        for (int i=2; i<=num; i++) {
            sum = first+second;
            first = second;
            second = sum;
        }
        System.out.println(sum);
    }
}
