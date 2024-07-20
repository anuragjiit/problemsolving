/*
Problem Description

Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 104

1 <= B <= N

1 <= C <= 109



Input Format

First argument A is an array of integers.

The remaining arguments B and C are integers



Output Format
Return 1 if such a subarray exist and 0 otherwise



Example Input
Input 1:

A = [4, 3, 2, 6, 1]
B = 3
C = 11

Input 2:

A = [4, 2, 2, 5, 1]
B = 4
C = 6



Example Output
Output 1:

1

Output 2:

0

 */
package com.array;

public class SubArrayGivenSumLength {

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6, 1};
        int B= 3;
        int C =11;
        int n = A.length;
        int sum =0;

        for (int i=0; i<B; i++){
            sum+=A[i];
        }

        if (sum==C){
            System.out.println("1");
            System.exit(0);
        }


        int s =1, e = B;
        while (e<n){
            sum = sum-A[s-1]+A[e];
            if (sum==C){
                System.out.println("1");
                break;
            }
            s++;
            e++;
        }

        System.out.println("0");

        /*
        O(n) & O(n)  => time complexity  and space complexity
        int[] preSum = new int[n];
        preSum[0]= A[0];
        for (int i=1; i<n; i++){
            preSum[i] = preSum[i-1]+ A[i];
        }

        int s =0, e = B-1;
        while (e<n){
            int sum =0;

            if (s==0){
                sum = preSum[e];
            }
            else {
                sum= preSum[e]-preSum[s-1];
            }
            if (sum==C){
                System.out.println("1");
                break;
            }
            s++;
            e++;
        }
        System.out.println("0"); */
    }
}
