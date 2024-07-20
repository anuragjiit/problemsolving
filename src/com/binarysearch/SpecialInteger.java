/*
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9


Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the maximum value of K (sub array length).

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 10

Input 2:
A = [5, 17, 100, 11]
B = 130

Example Output
Output 1:
 2
Output 2:
 3

Example Explanation
Explanation 1:

For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
For K = 3, There is a subarray [3, 4, 5] which has a sum > B
For K = 2, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 2.

Explanation 2:

For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
For K = 3, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 3.

 */
package com.binarysearch;

public class SpecialInteger {

    public static boolean checkSubArray(long sum, int[] A, int B, int mid) {

        int n = A.length;
        int e = mid;
        int s = 0;

        while (e<n){
            sum = sum-A[s]+A[e];
            if(sum>B){
                return false;
            }
            s++;
            e++;
        }
       return true;
    }

    public static void main(String[] args) {

        int[] A = new int[]{1,2,3,4,5};
        int B = 10;
        int ans= 1;
        int low = 0;
        int high = A.length;

        while(low<=high){
            long sum =0;
            // => 7 (sub array of size 7 -> 0 - 6
            int mid = (high - low) / 2 + low;
            for (int i = 0; i<mid; i++){
                sum+=A[i];
            }
            if(sum>B) {
                high = mid-1;
            } else {

                // call function to chck all sum .... if true set ans = mid and low is mid+1;
            if(checkSubArray(sum, A, B, mid)){
                ans = mid;
                low = mid+1;
                 }
             else {
                 high=mid-1;
               }
            }

        }



        System.out.println(ans);

    }
}
