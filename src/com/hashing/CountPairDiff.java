/*
Problem Description
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.



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
B = 4

Input 2:

A = [1, 2, 1, 2]
B = 1



Example Output

Output 1:

1

Output 2:

4



Example Explanation

Example 1:

The only pair is (2, 3) which gives difference as 4

Example 2:

The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).

 */
package com.hashing;
import java.util.HashMap;

public class CountPairDiff {
    public static void main(String[] args) {
        int[] A = {2,1,2,1,2,1,2,1,2};
        int B = 1;

        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i=0; i<n; i++){
            int target1 = A[i]+B;
            int target2 = A[i]-B;

            if(map.containsKey(target1)) count+=map.get(target1);
            if(map.containsKey(target2)) count+=map.get(target2);

            if(map.containsKey(A[i])){
                map.put( A[i], map.get(A[i])+1 );
            } else {
                map.put(A[i],1);
            }
        }

        System.out.println(count);

    }
}
