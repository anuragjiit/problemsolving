/*
Problem Description
Given a 2D integer array A, return the transpose of A.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.



Problem Constraints

1 <= A.size() <= 1000

1 <= A[i].size() <= 1000

1 <= A[i][j] <= 1000



Input Format

First argument is a 2D matrix of integers.



Output Format

You have to return the Transpose of this 2D matrix.



Example Input

Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]

Input 2:

A = [[1, 2],[1, 2],[1, 2]]



Example Output

Output 1:

[[1, 4, 7], [2, 5, 8], [3, 6, 9]]

Output 2:

[[1, 1, 1], [2, 2, 2]]



Example Explanation

Explanation 1:

Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].

Explanation 2:

After transposing the matrix, A becomes [[1, 1, 1], [2, 2, 2]]
 */
package com.array;

public class MatrixTranspose {
    public static void main(String[] args) {

  //      int[][] A = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int[][] A = {{1,2},{1,2},{1,2}};
        int n = A.length;
        int m = A[0].length;

        int[][] B = new int[m][n];
        int temp=0, i=0, j=0;


        if (n==m) {
            for (i = 0; i < n; i++) {
                for (j = i + 1; j < m; j++) {
                    temp = A[i][j];
                    A[i][j] = A[j][i];
                    A[j][i] = temp;
                }
            }
        } else {   // m row & n column

            for (j = 0; j < m; j++) {
                for (i = 0; i < n; i++) {
                B[j][i] = A[i][j];
                }
            }


        }

//        for (j = 0; j < m; j++) {
//            for (i = 0; i < n; i++) {
//                System.out.println(B[j][i]);
//            }
//            System.out.println("--------------------------------");
//        }

//        for (int i=0; i<n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.println(A[i][j]);
//            }
//            System.out.println("--------------------------------");
//            }
        }
}
