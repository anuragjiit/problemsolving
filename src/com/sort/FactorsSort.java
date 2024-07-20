/*
Problem Description
You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.

Note: You cannot use any extra space



Problem Constraints
1 <= N <= 10^4
1 <= A[i] <= 10^4



Input Format
First argument A is an array of integers.



Output Format
Return an array of integers.



Example Input
Input 1:

A = [6, 8, 9]

Input 2:

A = [2, 4, 7]



Example Output
Output 1:

[9, 6, 8]

Output 2:

[2, 7, 4]



Example Explanation
For Input 1:

The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.

For Input 2:

The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.

 */
package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FactorsSort implements Comparator<Integer> {

    public static int factor(int num) {

        int count = 0;

        for(int i=2; i*i<=num;i++) {
            if (num%i==0) {
                if(num/i==i) count++;
                else count+=2;
            }
        }
        return count;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        int fac1 = factor(o1);
        int fac2 = factor(o2);
        if(fac1<fac2) return -1;
        else if (fac1>fac2) return 1;
        else if (o1<o2) return -1;
        else if (o1>o2) return 1;

        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 4, 7));
        Collections.sort(A, new FactorsSort());
        System.out.println(A.toString());

    }

}
