/*
Problem Description

Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that

a1 >= a2 <= a3 >= a4 <= a5.....

NOTE: If multiple answers are possible, return the lexicographically smallest one.



Problem Constraints

1 <= len(A) <= 106
0 <= A[i] <= 106



Input Format

The first argument is an integer array A.



Output Format

Return an array arranged in the sequence as described.



Example Input

Input 1:

A = [1, 2, 3, 4]

Input 2:

A = [1, 2]



Example Output

Output 1:

[2, 1, 4, 3]

Output 2:

[2, 1]



Example Explanation

Explanation 1:

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].

Explanation 1:

Only possible answer is [2, 1].

 */
package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(4);A.add(3);A.add(5);

        Collections.sort(A);

        ArrayList<Integer> ans = new ArrayList<>();

        int start = 1;
        int end = A.size()-1;

        while(start<=end){
            int temp = A.get(start);
            ans.add(temp);
            ans.add(A.get(start-1));
            start+=2;
        }

        if(start==A.size()){
            ans.add(A.get(start-1));
        }

        System.out.println(ans);

//        int[] A = new int[] {1, 2, 3, 4};
//
//        Arrays.sort(A);
//
//        for(int i=1; i<A.length; i+=2) {
//            int temp = A[i-1];
//            A[i-1] = A[i];
//            A[i] = temp;
//        }
//
//        System.out.println(Arrays.toString(A));
    }
}
