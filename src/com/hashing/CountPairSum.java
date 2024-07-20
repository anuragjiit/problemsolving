/*
Problem Description
You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.



Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
1 <= B <= 10^9



Input Format
First argument A is an array of integers and second argument B is an integer.



Output Format
Return an integer.



Example Input

Input 1:

A = [3, 5, 1, 2]
B = 8

Input 2:

A = [1, 2, 1, 2]
B = 3



Example Output

Output 1:

1

Output 2:

4



Example Explanation

Example 1:

The only pair is (1, 2) which gives sum 8

Example 2:

The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4).

 */
package com.hashing;

import java.util.HashMap;

public class CountPairSum {
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        int B = 3;

        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        int count = 0;

        for (int i=0; i<n; i++){
            int target = B-A[i];

            if(hm.containsKey(target)) {
                count+=hm.get(target);
            }
            if(hm.containsKey(A[i])) {
                hm.put(A[i], hm.get(A[i])+1);
            } else {
                hm.put(A[i],1);
            }

        }
        System.out.println(count);
    }
}
