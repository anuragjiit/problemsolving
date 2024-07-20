/*
Problem Description

You are given an integer A. You have to tell whether it is a perfect number or not.

Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

A proper divisor of a natural number is the divisor that is strictly less than the number.

Example Explanation

Explanation 1:

For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.

Explanation 2:

For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.

Example Input

Input 1:

A = 4

Input 2:

A = 6



Example Output

Output 1:

0

Output 2:

1
 */
package com.array;

public class PerfectNumber {
    public static void main(String[] args){
        int sum =0, A = 6;

        // here its A/2 Iteration

//        for (int i=1; 2*i<=A; i++){
//            if (A%i == 0){
//                sum = sum+i;
//            }
//        }

// More optimised .. Iteration of square root of A .. 1 is not perfect number .. minimum is 6

        for (int i=1; i*i<=A; i++){
            if (A!= 1 && A%i == 0){
                if (A/i==A){
                    sum += i;
                } else {
                    sum+= i+A/i;
                }
           }
        }

        if (sum == A){
            System.out.println("Perfect Number");
        } else {
            System.out.println("Not a Perfect Number");
        }
    }

}
