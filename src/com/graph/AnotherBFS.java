/*
Problem Description

Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 10^5

0 <= B[i][0], B[i][1] < A

1 <= B[i][2] <= 2

0 <= C < A

0 <= D < A



Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.



Output Format

Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.


Example Input

Input 1:


A = 6
B = [   [2, 5, 1]
        [1, 3, 1]
        [0, 5, 2]
        [0, 2, 2]
        [1, 4, 1]
        [0, 1, 1] ]
C = 3
D = 2

Input 2:

A = 2
B = [   [0, 1, 1]
    ]
C = 0
D = 1



Example Output

Output 1:

 4

Output 2:

 1



Example Explanation

Explanation 1:

The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.

Explanation 2:

 Path will be 0-> 1.

 */
package com.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AnotherBFS {
    public static void main(String[] args) {
        int A = 2;
        int[][] B = { {0,1,1}};
        int C = 0;
        int D = 1;

//        int A = 6; //weighted undirected graph having A nodes
//        int[][] B = { {2, 5, 1}, {1, 3, 1}, {0, 5, 2}, {0, 2, 2}, {1, 4, 1}, {0, 1, 1}};
//        int C = 3; // source
//        int D = 2; // destination .. find shortest distance from C to D
        boolean[] visited = new boolean[A];
        int n = B.length;
        ArrayList<Pair>[] graph = new ArrayList[A];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortWeight());

        for (int i=0; i<A; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int wt = B[i][2];
            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }

        pq.add(new Pair(C,0));
        visited[C] = true;
        int distance = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int v = current.v;
            int wt = current.wt;

            if (v==D) {
                break;
            }

            if (visited[v]==true ) {
                continue;
            }

            distance += wt;
            visited[v] = true;

            ArrayList<Pair> children1 = graph[v];

            for (Pair child : children1) {
                if(!visited[child.v]) {
                    pq.add(child);
                }
            }
        }

        System.out.println(distance);
    }
}
