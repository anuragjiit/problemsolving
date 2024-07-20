/*
Problem Description

Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.



Problem Constraints

0 <= A <= 10^9



Input Format

The first and only argument given is the integer A.



Output Format

Return floor(sqrt(A))



Example Input

Input 1:

 11

Input 2:

 9



Example Output

Output 1:

 3

Output 2:

 3



Example Explanation
Explanation 1:

When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.

Explanatino 2:

When A = 9 which is a perfect square of 3, so we return 3.
 */
package com.binarysearch;

public class SquareRootNumber {
    public static void main(String[] args) {
        int A = 50;
        if(A==0||A==1) System.out.println(A);

        long s=1;
        long e=A/2;
        long ans =0;

        while(s<=e){
            long mid = (e-s)/2+s;

            if(mid*mid==A){
                System.out.println((int)mid);
                System.exit(0);
            }

            else if(mid*mid>A){
                e = mid-1;
            } else {
                s = mid+1;
                ans = mid;
            }
        }

        System.out.println((int)ans);
    }
}
