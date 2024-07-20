/*
Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.

Problem Constraints
1 <= A.size() <= 10^4

1 <= A[i] <= 10^9

1 <= B <= 10^9

Input Format
First argument is an integer array A.

Second argument is an integer B.
Input 1:

A = [1,2,3,4]
B = 7
Input 2:

A = [1,2,4]
B = 4
Input 3:

A = [1,2,2]
B = 4


Example Output
Output 1:

1
Output 2:

0
Output 3:

1
 */
package com.array;

import java.util.Arrays;

public class TestF {

    public static void main(String[] args) {
    //    int A[] = {1,2,2};
    //    int A[] = {633299,189622,811214,549111,864962,673215,526221,271580,78335,890164};
    //    int B =968499;
        int A[] = {510827,351151,96897,925335,299818,192489,456948,44720,510589,598577};
        int B= 808099;
        int j = A.length-1;

        Arrays.sort(A);
// B-A[i]
        for (int i = 0; i<j; i++) {
            if ((i!=j) && (B - A[i] == A[j])) {
                System.out.println("1");
                System.exit(0);
            }
        }
        System.out.println("0");
//        if (A.length == 1) {
//            System.out.println("0");
//        }
//        for (int i=0; i<A.length-1; i++) {
//            int j = A.length - 1;
//            while (i < j) {
//                if (A[i] + A[j] == B) {
//                    System.out.println("1");
//                }
//                //        i++;
//                j--;
//            }
//        }
//    //    System.out.println("0");
    }
}
