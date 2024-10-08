/*
Problem Description

Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

    D[i]: Shortest distance from the C node to node i.
    If node i is not reachable from C then -1.

Note:

    There are no self-loops in the graph.
    There are no multiple edges between two pairs of vertices.
    The graph may or may not be connected.
    Nodes are numbered from 0 to A-1.
    Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A



Input Format

    The first argument is an integer A, representing the number of nodes in the graph.
    The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
    The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.



Output Format

Return the integer array D.



Example Input

Input 1:

A = 6
B = [   [0, 4, 9]
        [3, 4, 6]
        [1, 2, 1]
        [2, 5, 1]
        [2, 4, 5]
        [0, 3, 7]
        [0, 1, 1]
        [4, 5, 7]
        [0, 5, 1] ]
C = 4

Input 2:

A = 5
B = [   [0, 3, 4]
        [2, 3, 3]
        [0, 1, 9]
        [3, 4, 10]
        [1, 3, 8]  ]
C = 4



Example Output

Output 1:

D = [7, 6, 5, 6, 0, 6]

Output 2:

D = [14, 18, 13, 10, 0]



Example Explanation

Explanation 1:

 All Paths can be considered from the node C to get shortest path

Explanation 2:

 All Paths can be considered from the node C to get shortest path

 */
package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args) {
//        int A = 6;
//        int C = 4;
//        int[][] B = { {0, 4, 9} , {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1} };

        int A = 6; //weighted undirected graph having A nodes
        int[][] B = { {2, 5, 1}, {1, 3, 1}, {0, 5, 2}, {0, 2, 2}, {1, 4, 1}, {0, 1, 1}};
        int C = 3; // source
        int D = 2; // destination .. find shortest distance from C to D

        int n = B.length;
        int[] ans = new int[A];
        Arrays.fill(ans, Integer.MAX_VALUE);

        boolean[] visited = new boolean[A];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortWeight());
        ArrayList<Pair>[] graph = new ArrayList[A];

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

        ans[C] = 0; //source node
        pq.add(new Pair(C, 0)); // added source in priority queue with distance 0

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int v = current.v;

            if (v==D) {
                System.out.println(ans[D]);
                System.exit(0);
            }

            if (visited[v] == true) {
                continue;
            }

            visited[v] = true;
            ArrayList<Pair> children1 = graph[v];

            for (Pair child : children1) {
                int currentWt = ans[v] + child.wt;

                if (currentWt < ans[child.v]) {
                    ans[child.v] = currentWt;
                    pq.add(new Pair(child.v, currentWt));
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        System.out.println(Arrays.toString(ans));
    }
}
