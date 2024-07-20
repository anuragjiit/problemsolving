/*
Problem Description
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.



Problem Constraints
1 <= len(A) <= 5 x 103
1 <= A[i] <= 103
1 <= B <= 107



Input Format
The first argument given is the integer array A.
The second argument given is an integer B.



Output Format
Return the count of good subarrays in A.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 4

Input 2:

A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65



Example Output
Output 1:

6

Output 2:

36



Example Explanation
Explanation 1:

Even length good subarrays = {1, 2}
Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}

Explanation 1:

There are 36 good subarrays
 */
package com.array;

public class GoodSubArrayEvenOdd {

    public static void main(String[] args){
        int[] A = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int B = 65;
   //     int[] A = {1, 2, 3, 4, 5};
   //     int B = 4;
        int count = 0;
        int n = A.length; // sub array length from 1 tp n i..e index 0 to n-1

        //   ----------------------- TC: O(n^2) , SC : O(1)

        for (int k=0; k<n; k++){     // k is size of sub array .. size = K+1;

            int sum = 0;
   //         boolean flag = true;
            for (int i=k; i<n; i++) {
                sum += A[i];
                int size = i+1-k;
                if ( (size%2==0 && sum < B) || (size%2!=0 && sum > B) ){
                    count++; }

//                if (flag){
//                    if (sum > B) count++;
//                        flag = false;
//                } else {
//                    if (sum < B) count++;
//                        flag = true;
//                    }
                }

            }


     //   ----------------------- TC: O(n^2) , SC : O(n)
   /*     int[] prefixSum = new int[n];
        prefixSum[0]=A[0];

        for (int i =1; i<n; i++){
            prefixSum[i]=prefixSum[i-1]+A[i];
        }

        for (int k=0; k<n; k++){     // k is size of sub array .. size = K+1;
           int size = k+1;
           int s = 0;
           int e = size-1;

           while ( e < n){
               int sum = 0;
               if (s==0){
                   sum = prefixSum[e];
               } else {
                   sum = prefixSum[e]-prefixSum[s-1];
               }
               if (size%2==0 && sum < B){
                   count++;
               }
               if (size%2!=0 && sum > B){
                   count++;
               }

               s++;
               e++;

           }
        } */
        System.out.println(count);
    }
}
