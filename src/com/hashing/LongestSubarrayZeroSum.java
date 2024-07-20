/*
Problem Description

Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.



Problem Constraints
1 <= N <= 10^5
-109 <= A[i] <= 10^9



Input Format
Single argument which is an integer array A.



Output Format
Return an integer.



Example Input

Input 1:

 A = [1, -2, 1, 2]

Input 2:

 A = [3, 2, -1]



Example Output

Output 1:

3

Output 2:

0



Example Explanation

Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.

Explanation 2:

 No subarray sums up to 0.

 */
package com.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) {

        int[] A = {9,-20,-11,-8,-4,2,-12,14,1};    //-4,2,-12,14 = 0

        int n = A.length;

        int ans = 0;
        long sum=0;
        HashMap<Long,Integer> hm = new HashMap<>();


        for (int i=0; i<n; i++){
            sum+=A[i];
            if(sum==0){
                ans=Math.max(ans,i+1);
            } else if (!hm.containsKey(sum)){
                hm.put(sum,i);

            } else {
                ans=Math.max(ans,i-hm.get(sum));
            }
        }

        System.out.println(ans);
    }
}
