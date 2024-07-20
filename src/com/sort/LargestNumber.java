/*
Problem Description

Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints

1 <= len(A) <= 100000
0 <= A[i] <= 2*10^9



Input Format

The first argument is an array of integers.



Output Format

Return a string representing the largest number.



Example Input

Input 1:

 A = [3, 30, 34, 5, 9]

Input 2:

 A = [2, 3, 9, 0]



Example Output

Output 1:

 "9534330"

Output 2:

 "9320"



Example Explanation

Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber implements Comparator<Integer> {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));
  //      ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0,0,0));
        Collections.sort(A, new LargestNumber());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <A.size(); i++) {
            sb.append((A.get(i)));
        }

       System.out.println(A.get(0)==0?"0":sb.toString());   // return type is String in problem

    }

    @Override
    public int compare(Integer o1, Integer o2) {
        String a = String.valueOf(o1);
        String b = String.valueOf(o2);
        String fir = a+b;
        String sec = b+a;
        int comp = fir.compareTo(sec);
        if(comp<0) return 1;
        if(comp>0) return -1;
        return 0;
    }
}
