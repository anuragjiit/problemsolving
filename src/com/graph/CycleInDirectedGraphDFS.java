/*
Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

    The cycle must contain atleast two nodes.
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.



Problem Constraints

2 <= A <= 10^5

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return 1 if cycle is present else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]

Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1

Explanation 2:

 The given graph doesn't contain any cycle.

 */
package com.graph;

import java.util.ArrayList;
import java.util.Stack;

public class CycleInDirectedGraphDFS {

    public static void main(String[] args) {
        int A = 5;
        int[][] B = new int[][] { {1,2}, {4,1}, {2,4}, {3,4}, {5,2}, {1,3} };
  //      int[][] B = new int[][] { {1,2}, {2,3}, {3,4}, {4,5}};
        int n = B.length;
        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<n; i++) {
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }

        for(int i = 1 ; i <= A ; i++){
            if(dfs(i, graph, visited, path)) {
                System.out.println(1);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    static boolean dfs(int current, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path) {

        // Check if node exists in path stack.
        if (path[current]==true) {
                return true;
          }

        // Check if node is already visited.
        if(visited[current]==true) {
            return false;
        }

        visited[current] = true;
        path[current] = true;

        for (int child : graph.get(current)) {
            if(dfs(child, graph, visited, path)) {
                return true;
            }
//            else if (path[child]==true) {
//                ans = 1;
//            }
        }
        path[current] = false;
        return false;
    }
}
