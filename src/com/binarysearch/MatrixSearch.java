/*
Problem Description

Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than or equal to the last integer of the previous row.

Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints

1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6



Input Format

The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format

Return 1 if B is present in A else, return 0.



Example Input

Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3

Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3



Example Output

Output 1:

1

Output 2:

0



Example Explanation

Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.

Explanation 2:

 3 is not present in the matrix so return 0.
 */
package com.binarysearch;

public class MatrixSearch {
    public static void main(String[] args) {

//        int[][] A = new int[][] {
//                {1, 2, 2, 3, 4, 4, 6, 7, 8},
//                {10, 18, 19, 22, 22, 24, 27, 27, 27},
//                {28, 28, 29, 29, 29, 32, 34, 35, 36},
//                {37, 37, 40, 40, 43, 46, 46, 47, 48},
//                {49, 51, 53, 53, 55, 55, 60, 62, 62},
//                {64, 68, 70, 70, 73, 77, 81, 82, 82},
//                {84, 86, 88, 90, 95, 96, 96, 99, 100}};
//
//        int B =1;

//        int[][] A = new int[][]{
//                {3},
//                {29},
//                {36},
//                {63},
//                {67},
//                {72},
//                {74},
//                {78},
//                {85}
//            };
//        int B = 41;

        int[][] A = new int[][]{
                {22,32,67}
        };
        int B = 93;



        int n = A.length;
        int m = A[0].length;


        int[] arr = new int[n*m];
        int idx = 0;

        for (int i=0; i<n; i++) {
            for(int j=0;j<m;j++){
                arr[idx] = A[i][j];
                idx++;
            }
        }

        int s = 0;
        int e = arr.length-1;
        int mid = 0;

        while(s<=e){
            mid = (e-s)/2+s;

            if(arr[mid]==B) {
                System.out.println("1");
                System.exit(0);
            }

            if (B < arr[mid]) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        System.out.println("0");

    }
}
