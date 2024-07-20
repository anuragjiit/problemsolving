/*
Problem Description

Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.

NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints

0 <= number of nodes <= 105



Input Format

First and only arument is a pointer to the root node of binary tree, A.



Output Format

Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input

Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9

Input 2:

      1
    /   \
   3     7
  /       \
 2         9



Example Output

Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]

Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]



Example Explanation

Explanation 1:

 First row represent the verical line 1 and so on.
 */
package com.treetravesal;
import java.util.*;

/**
 * Definition for binary tree

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
} */

class Pair {
    TreeNode node;
    int column;
    Pair(TreeNode n, int c){
        node = n;
        column = c;
    }
    }

public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        if (A==null) {
            return null;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A,0));

        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        int minColumn = 0;
        int maxColulmn = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i=0; i<size; i++) {
                Pair current = queue.remove();
                minColumn = Math.min(minColumn, current.column);
                maxColulmn = Math.max(maxColulmn, current.column);

                // ArrayList<Integer> list = new ArrayList<>();

                // if (map.containsKey(current.column)) {
                //     list = map.get(current.column);
                // }
                ArrayList<Integer> list = map.containsKey(current.column) ? map.get(current.column) : new ArrayList<>();

                list.add(current.node.val);
                map.put(current.column, list);

                if (current.node.left!=null){
                    queue.add(new Pair(current.node.left, current.column-1));
                }
                if (current.node.right!=null){
                    queue.add(new Pair(current.node.right, current.column+1));
                }
            }
        }

        for (int i=minColumn; i<=maxColulmn; i++) {
            output.add(map.get(i));
        }

        return output;
    }
}
