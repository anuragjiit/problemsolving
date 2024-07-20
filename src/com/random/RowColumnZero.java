/*
Problem Description

You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.



Problem Constraints

1 <= A.size() <= 103

1 <= A[i].size() <= 103

0 <= A[i][j] <= 103



Input Format

First argument is a 2D integer matrix A.



Output Format

Return a 2D matrix after doing required operations.



Example Input

Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]



Example Output

Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]



Example Explanation

Explanation 1:

A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 */
package com.random;

public class RowColumnZero {
    public static void main(String[] args){
        int[][] A = {{1,2,3,4},{5,6,7,0},{9,2,0,4}};
        int n = A.length;

        int m = A[0].length;
        //    int[][] B = new int[n][m];
        int[] row = new int[n];
        int[] column = new int[m];

        for (int i =0; i<n; i++){
            for (int j=0; j<m;j++){
                if (A[i][j]==0){
                    row[i] = -1;
                    column[j] = -1;
                }
            }
        }

        for (int j=0; j<m;j++){
            for (int i =0; i<n; i++){
                if(column[j]==-1){
                    A[i][j] = 0;
                }
                if(row[i]==-1){
                    A[i][j] = 0;
                }
            }
        }

        for (int i = 0; i<n; i++){
            for (int j=0; j<m;j++){
                System.out.println(A[i][j]);
//                if(row[i]==-1){
//                    A[i][j] = 0;
//                }
            }
        }
    }
}
