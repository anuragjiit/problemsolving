/*
Problem Description

Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

    There are no self-loops in the graph.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.



Problem Constraints

2 <= A <= 10^4

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.



Example Input

Input 1:

 A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]

Input 2:

 A = 3
 B = [  [1, 2]
        [2, 3]
        [3, 1] ]



Example Output

Output 1:

 [5, 6, 1, 3, 4, 2]

Output 2:

 []



Example Explanation

Explanation 1:

 The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]

Explanation 2:

 The given graph contain cycle so topological ordering not possible we will return empty array.

 */
package com.graph;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
//        int A = 3;
//        int[][] B = { {1,2}, {2,3}, {3,1}};
//        int A = 6;
//        int[][] B = { {6, 3 }, {6,1}, {5,1}, {5,2} , {3,4}, {4,2}};
        int A = 8;
        int[][] B = { {1,4 }, {1,2}, {4,2}, {4,3} , {3,2}, {5,2}, {3,5}, {8,2}, {8,6}}; // ans = 1 4 3 5 7 8 2 6
        int n = B.length;

        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for (int i=0; i<=A; i++) {
           graph[i] = new ArrayList<>();
        }

        int[] inDegreeArr = new int[A+1];
        int[] ans = new int[A];

        for (int i=0; i<n; i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph[u].add(v);
            inDegreeArr[v]++;
        }

   //     Queue<Integer> q = new LinkedList<>();
        /// Initialize a priority queue to hold the indegree with 0  incoming edges..
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=1; i<=A; i++) {
            if(inDegreeArr[i]==0) {
                q.add(i);
            }
        }

        int idx =0;
        while( !q.isEmpty() ) {
            int current = q.poll();
            ans[idx] = current;
            List<Integer> neighbour = graph[current];
     //       Collections.sort(neighbour);

            for (int v : neighbour) {
                inDegreeArr[v]--;
                if(inDegreeArr[v]==0) {
                    q.add(v);
                }
            }
            idx++;
        }

        for (int i=1; i<=A; i++) {
            if(inDegreeArr[i]!=0){
                System.out.println(-1);
                System.exit(0);
            }
        }

        System.out.println(Arrays.toString(ans));

    }
}
