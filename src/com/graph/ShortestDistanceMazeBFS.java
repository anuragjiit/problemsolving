/*
Problem Description

Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints

2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M



Input Format

The first argument given is the integer matrix A.

The second argument given is an array of integer B.

The third argument if an array of integer C.



Output Format

Return a single integer, the minimum distance required to reach destination



Example Input

Input 1:

A = [ [0, 0],
      [0, 0] ]
B = [0, 0]
C = [0, 1]

Input 2:

A = [ [0, 1],
      [1, 0] ]
B = [0, 0]
C = [1, 1]



Example Output

Output 1:

 1

Output 2:

 -1



Example Explanation

Explanation 1:

 Go directly from start to destination in distance 1.

Explanation 2:

 It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
 */
package com.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Cell {
    int x;
    int y;
    int dis;
    Cell (int dis, int x, int y) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class SortDistance implements Comparator<Cell> {
    @Override
    public int compare(Cell o1, Cell o2) {
        return o1.dis-o2.dis;
    }
}

public class ShortestDistanceMazeBFS {

    public static void main(String[] args) {

        int[][] A = {{0, 0}, {0, 0}};  // matrix
        //1 represents a wall in a matrix and 0 represents an empty location in a wall.
        int[] B = {0, 1};    // start point, excluded
        int[] C = {1, 1};    // end point , included.. ball has to stop by wall after end point i.e there should be 1 (next to end point
        //) in the direction from where ball is coming.. if coming from right, 1 should be after end point in right..
        int n = A.length;
        int m = A[0].length;

        if ( A[B[0]][B[1]]==1 || A[C[0]][C[1]]==1 ) {
            System.out.println(-1);
            System.exit(0);
        }

        int[][] dp = new int[n][m]; // Store minimum distance

        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(new SortDistance());
        pq.add(new Cell(0, B[0],B[1]));
        dp[B[0]][B[1]] = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int d = cell.dis;
            int x = cell.x;
            int y = cell.y;

            if (d > dp[x][y]) {
                continue;
            }

            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int k=0; k<4; k++) {
                int childX = dx[k] + x;
                int childY = dy[k] + y;
                int d1 =0;

                while ( childX <n && childX >=0 && childY < m && childY >=0 && A[childX][childY]==0) {
                    childX+=dx[k];
                    childY+=dy[k];
                    d1++;
                }

                childX-=dx[k];  // to get the actual cell , above loop will increase the cell value by dx[x] .. so minus
                childY-=dy[k];  // to get the actual cell

                if ( dp[childX][childY] > dp[x][y] + d1 ) {
                    dp[childX][childY] = dp[x][y] + d1;
                    pq.add(new Cell(dp[childX][childY], childX, childY));
                }

            }
         }

        System.out.println( dp[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : dp[C[0]][C[1]]);
    }
}
