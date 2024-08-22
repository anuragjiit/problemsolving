/*
Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]

Input 2:


A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]



Example Output

Output 1:

 4

Output 2:

 -1



Example Explanation

Explanation 1:

Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.

Explanation 2:

The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.

 */
package com.graph;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class Diamension {
    int x;
    int y;

    Diamension(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RottenOrangesBFS {
    public static void main(String[] args) {
        int[][] A = { {2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int n = A.length;
        int m = A[0].length;

        Queue<Diamension> q = new LinkedList<>();
        initialise(A, q, n, m);
        int time = 0;

        while( !q.isEmpty() ) {
            int size = q.size();
            while ( size > 0 ) {
                Diamension current = q.poll();
                int i = current.x;
                int j = current.y;
                int[] rows = {-1,0,1,0};
                int[] col = {0,1,0,-1};
                for (int k = 0; k < 4; k++) {
                    int newI = i+rows[k];
                    int newJ = j+col[k];
                    if (newI >=0  && newI < n && newJ >= 0 && newJ < m && A[newI][newJ] == 1) {
                        A[newI][newJ] = 2;
                        q.add(new Diamension(newI, newJ));
                    }
                }
                size--;
            }
            time++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(time-1);
    }

    private static void initialise(int[][] A, Queue<Diamension> q, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( A[i][j] == 2) {
                    q.add(new Diamension( i, j ));
                }
            }
        }
    }
}
