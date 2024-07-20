/*
Problem Description

Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.

    If a number has no tens digit, we can assume value to be 0.
    If 2 numbers have same tens digit, in that case number with max value will come first
    Solution should be based on comparator.



Problem Constraints

1 <= N <= 10^5

1 <= A[i] <= 10^9



Input Format

First argument A is an array of integers.



Output Format

Return the array after sorting



Example Input
Input 1:

A = [15, 11, 7, 19]

Input 2:

A = [2, 24, 22, 19]



Example Output
Output 1:

[7, 19, 15, 11]

Output 2:

[2, 19, 24, 22]



Example Explanation
For Input 1:

The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
and that of 19, 15 and 11 is 1.

For Input 2:

The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
that of 19 is 1 and that of 22 and 24 is 2.

 */
package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TensDigitSorting implements Comparator<Integer> {
    public static void main(String[] args) {


        ArrayList<Integer> A = new ArrayList<>();
        A.add(888);
        A.add(11);
        A.add(7);
        A.add(19);A.add(437);


        int n = A.size();

        Collections.sort(A, new TensDigitSorting());

        System.out.println(A);

    }


    @Override
    public int compare(Integer o1, Integer o2) {
        int a = (o1/10)%10;         // %10 is important to get the remainder to show 10th place for bigger number ..
        int b = (o2/10)%10;         // /10 is to get 0th tenth number ..

        if(a<b) return -1;
        else if(a>b) return 1;

        if(o1<o2) return 1;
        else if(o1>o2) return -1;

        return 0;
    }
}
