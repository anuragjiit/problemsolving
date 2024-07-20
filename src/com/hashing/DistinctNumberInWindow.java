/*
Problem Description

You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Problem Constraints
1 <= N <= 10^6

1 <= A[i] <= 10^9



Input Format

First argument is an integer array A
Second argument is an integer B.



Output Format

Return an integer array.



Example Input

Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3

Input 2:

 A = [1, 1, 2, 2]
 B = 1



Example Output

Output 1:

 [2, 3, 3, 2]

Output 2:

 [1, 1, 1, 1]



Example Explanation

Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].

Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
 */
package com.hashing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class DistinctNumberInWindow {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        int B = 3;


        int n = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<B; i++) {
            if(hm.containsKey(A.get(i))) hm.put(A.get(i), hm.get(A.get(i))+1);
            else hm.put(A.get(i),1);
        }
        ans.add(hm.size());


        int s = 1;
        int e = B;

        while (e<n){

            if(hm.containsKey(A.get(e))) hm.put(A.get(e), hm.get(A.get(e))+1);
            else hm.put(A.get(e),1);

            int pre = hm.get(A.get(s-1));
            pre = pre-1;
            if (pre==0) hm.remove(A.get(s-1));
            else hm.put(A.get(s-1), pre);

            ans.add(hm.size());
            s++;
            e++;
        }

        System.out.println(ans);

    }
}
