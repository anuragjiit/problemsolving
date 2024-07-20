/*
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in less than equal to B swaps.



Problem Constraints

1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format

The first argument is an integer array A.

The second argument is integer B.



Output Format

Return the Bth smallest element in given array.



Example Input

Input 1:

A = [2, 1, 4, 3, 2]
B = 3

Input 2:

A = [1, 2]
B = 2



Example Output

Output 1:

 2

Output 2:

 2



Example Explanation

Explanation 1:

 3rd element after sorting is 2.

Explanation 2:

 2nd element after sorting is 2.

 */
package com.array;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3, 2};
        int B = 3;
        int n = A.length;
        int min_index = 0;

        for (int i=0; i < B; i++){
            min_index = i;
            for (int j = i+1; j<n; j++){
                if (A[j]<A[min_index]){
                    min_index=j;
                }
            }
            int temp = A[i];
            A[i] = A[min_index];
            A[min_index] = temp;
        }
        System.out.println(A[B-1]);


    }
}
