/*
Problem Description

There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Problem Constraints

1 <= A <= 6*10^4

1 <= length(B) = length(C) <= 10^5

1 <= B[i], C[i] <= A



Input Format

The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.



Output Format

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Example Input

Input 1:

 A = 3
 B = [1, 2]
 C = [2, 3]

Input 2:

 A = 2
 B = [1, 2]
 C = [2, 1]



Example Output

Output 1:

 1

Output 2:

 0



Example Explanation

Explanation 1:

 It is possible to complete the courses in the following order:
    1 -> 2 -> 3

Explanation 2:

 It is not possible to complete all the courses.

 */
package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibilityFinishing {
    public static void main(String[] args) {
        int A = 3; // no of courses
        int[] B = {1, 2};  // B[i] is pre-requisite to C[i]
        int[] C = {2, 3};
        int n = B.length;

        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for (int i=0; i<=A; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegreeArr = new int[A+1];
        int[] ans = new int[A];

        for (int i=0; i<=A; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            int u = B[i];
            int v = C[i];
            graph[u].add(v);
            inDegreeArr[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

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
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(1);

    }
}
