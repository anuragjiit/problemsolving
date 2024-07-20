/*
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input

Input 1:

A = [1, 1, 1]
B = 2

Input 2:

A = [1, 5, 7, 10]
B = 8



Example Output

Output 1:

 3

Output 2:

 1



Example Explanation

Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.

Explanation 2:

 There is only one pair, such that i = 0, and j = 2 sums up to 8.

 */
package com.twopointers;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10};
        int checkSum = 11;
//        int[] inputArray = new int[]{1,1,1};
//        int checkSum = 2;
//        int[] inputArray = new int[]{1,2,6,6,7,9,9};
//        int checkSum = 13;
//        int[] inputArray = new int[]{1,6,7,8};
//        int checkSum = 7;
        int left = 0;
        int right = inputArray.length-1;
        long count = 0;
        long mod = 1000000007;

        while(left<right){
            long sum = inputArray[left]+inputArray[right];
            if(sum<checkSum){
                left++;
            } else if(sum>checkSum){
                right--;
            } else {
                int countLeftDup = 0;
                int leftArr = inputArray[left];

                while(left<right && inputArray[left]==leftArr){
                    countLeftDup++;
                    left++;
                }

                left--;

                int countRightDup = 0;
                int rightArr = inputArray[right];
                while(left<right && inputArray[right]==rightArr){
                    countRightDup++;
                    right--;
                }

                if(leftArr==rightArr){
                    int temp = countLeftDup+countRightDup;
                    count+= temp*(temp-1)/2;
                    count%=mod;
                }
                else {
                    count+=countRightDup*countLeftDup;
                    count%=mod;
                }
//                left++;
//                right--;
            }
        }

        System.out.println((int)count);
    }
}
