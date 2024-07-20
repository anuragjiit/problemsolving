/*
Problem Description

Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.



Problem Constraints

2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format

The first argument is an array of integers of size N.



Output Format

Return an array of two integers that appear only once.



Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]

Input 2:

A = [1, 2]



Example Output
Output 1:

[3, 4]

Output 2:

[1, 2]



Example Explanation
Explanation 1:

3 and 4 appear only once.

Explanation 2:

1 and 2 appear only once.

 */
package com.bitmanipulation;

public class SingleNumer1 {



    public static void main(String[] args){

        int[] A = {1, 2, 3, 1, 2, 4};
        int first = 0, second = 0;
        int xor = 0;

        for (int ele : A) xor = xor ^ ele;  // xor of 3 & 4

        int rsb = xor & (~xor+1);  // rsb -> right significant bit -- 2s compliment of xor element

        for (int elem : A){
            if ((rsb & elem) == 0){
                first = first ^ elem;
            } else second = second ^ elem;
        }

        if (first < second)
            System.out.println(new int[]{first, second});

        System.out.println(first);
        System.out.println(second);

    }
}
