/*
Problem Description

Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.



Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108



Input Format

First and only argument is an integer array A.



Output Format

Return 1 if any such integer p is present else, return -1.



Example Input

Input 1:

 A = [3, 2, 1, 3]

Input 2:

 A = [1, 1, 3, 3]



Example Output

Output 1:

 1

Output 2:

 -1



Example Explanation

Explanation 1:

 For integer 2, there are 2 greater elements in the array..

Explanation 2:

 There exist no integer satisfying the required conditions.
 */
package com.array;

import java.util.Arrays;

public class NobleInteger {

    public static void main(String[] args){
   //     int[] A = {3, 2, 1, 3};
        int[] A = {1, 1, 3, 3};
        int n = A.length, count = 0;
        Arrays.sort(A);

        for (int i=0; i<n/2; i++){
            int temp = A[i];
            A[i] = A[n-1-i];
            A[n-1-i] = temp;
        }
        if (A[0]==0){
            System.out.println("1");
            System.exit(0);
        }

        for (int i=1; i<n; i++){
            if (A[i]!=A[i-1]){
                count = i;
            }
            if (A[i]==count){
                System.out.println("1");
                System.exit(0);
            }
        }
        System.out.println("-1");
    }
}
