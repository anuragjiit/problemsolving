/*
Problem Description

Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.



Problem Constraints

1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 10^9



Input Format

First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]



Output Format

Return an integer denoting the minimum construction cost.



Example Input

Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]

Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]



Example Output

Output 1:

9

Output 2:

37



Example Explanation

Explanation 1:

We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of costruction is 9.

Explanation 2:

We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
 */
package com.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//class Pair {
//    int v;
//    int wt;
//
//    public Pair(int v, int wt) {
//        this.v = v;
//        this.wt = wt;
//    }
//}
//
//class SortWeight implements Comparator<Pair> {
//    @Override
//    public int compare(Pair p1, Pair p2) {
//        return p1.wt-p2.wt;
//    }
//}

// Pair and SortWeight classes used from com.graph.CommutableIslandsPrimsAlgo Java file

public class ConstructionCostPrimsAlgo {
    public static void main(String[] args) {
        int A = 3;
        //  int[][] B = { {1, 2, 14}, {2, 3, 7}, {3, 1, 2}};
        int[][] B = { {1, 2, 20}, {2, 3, 17}};

        ArrayList<Pair>[] graph = new ArrayList[A+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new SortWeight());
        boolean[] visited = new boolean[A+1];

        for (int i=0; i<=A; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int wt = B[i][2];
            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }
        int src = 1;
        ArrayList<Pair> children = graph[src];

        for (Pair child : children) {
            pq.add(child);
        }

        visited[src] = true;
        int cost = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int v = current.v;
            int wt = current.wt;

            if (visited[v]==true) {
                continue;
            }

            cost+=wt;
            cost%=1000000007;
            visited[v] = true;
            ArrayList<Pair> children1 = graph[v];

            for (Pair child : children1) {
                if(!visited[child.v]) {
                    pq.add(child);
                }
            }
        }

        System.out.println(cost);
    }
}
