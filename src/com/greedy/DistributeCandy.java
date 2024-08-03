/*
Problem Description

N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum number of candies you must give?



Problem Constraints

1 <= N <= 10^5
-10^9 <= A[i] <= 10^9



Input Format

The first and only argument is an integer array A representing the rating of children.



Output Format

Return an integer representing the minimum candies to be given.



Example Input

Input 1:

 A = [1, 2]

Input 2:

 A = [1, 5, 2, 1]



Example Output

Output 1:

 3

Output 2:

 7



Example Explanation

Explanation 1:

 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Explanation 2:

 Candies given = [1, 3, 2, 1]
 */
package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 5, 2, 1));
        int n = arr.size();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i =0; i<n; i++) {
            result.add(1);
        }

        for (int i=1; i<n; i++) {
            if (arr.get(i) > arr.get(i-1)) {
                result.set(i, result.get(i-1)+1);
            }
        }

        for (int i=n-2; i>=0; i--) {
            if (arr.get(i) > arr.get(i+1)) {
                if (result.get(i) <= result.get(i+1)) {
                    result.set(i, result.get(i+1)+1);
                }
            }
        }

        int ans = 0;
        for (int ele : result) {
            ans+=ele;
        }

        System.out.println(ans);
    }
}
