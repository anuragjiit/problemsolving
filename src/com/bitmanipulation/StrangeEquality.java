/*
Problem Description

Given an integer A.
Two numbers, X and Y, are defined as follows:

    X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
    Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.

Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



Problem Constraints

1 <= A <= 109



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the XOR of X and Y.



Example Input

A = 5



Example Output

10

-------hint -----
A + B = (A ^ B) + 2 * (A & B)
Following the above equation, if xor sum and the sum of 2 numbers are equal, their bitwise AND should be zero.
Given a number N, how to find a number whose bitwise AND with N is 0?
Keeping in mind the truth table of AND, 1 & 1 = 1 while 1 & 0 = 0, 0 & 1 = 0 and 0 & 0 = 0.
Therefore, in the number X such that X & N is 0, all the set bits of number N must be unset in the number X since 1 & 0 = 0.
The unset bits of N can have any orientation in X, that is, they can either be 0 or be 1.
So to find the smallest number greater than N, the answer is the next power of 2 greater than N. Think why!!
And to find the greatest number smaller than N, set all the unset bits of N to 1.

 */
package com.bitmanipulation;

public class StrangeEquality {
    public static void main(String[] args){
        int A =5;
        int x =0;
        int y =0;


        for (int i=31; i>=0; i--){
            if ((A & 1<<i) != 0 ){
                y = 1 << i+1;
                for (int j=0; j<i;j++){
                    if ((A & 1<<j) == 0 ){
                        x+= 1<<j;
                    }
                }
                break;
            }
        }



        System.out.println(x ^ y);

    }
}
