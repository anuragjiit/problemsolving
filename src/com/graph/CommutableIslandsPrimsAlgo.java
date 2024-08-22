/*
Problem Description

There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints

1 <= A, M <= 6*10^4

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 10^3



Input Format

The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format

Return an integer representing the minimal cost required.



Example Input

Input 1:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]

Input 2:

 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]



Example Output

Output 1:

 6

Output 2:

 6



Example Explanation

Explanation 1:

 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

Explanation 2:

 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.

 */
package com.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int v;
    int wt;

    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class SortWeight implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return p1.wt-p2.wt;
    }
}

public class CommutableIslandsPrimsAlgo {
    public static void main(String[] args) {
//        int A = 4;
//        int[][] B = { { 1, 2, 1 }, { 2, 3, 4 }, { 1, 4, 3 }, { 4, 3, 2 }, { 1, 3, 10 } };
    //   int[][] B = { { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 4 }, { 1, 4, 3 } };

        int A = 3;
        int[][] B = { {1, 2, 14}, {2, 3, 7}, {3, 1, 2}};
     //   int[][] B = { {1, 2, 20}, {2, 3, 17}};

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
