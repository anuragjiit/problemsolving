/*
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints

1 <= number of nodes <= 10^5



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return a 2D integer array denoting the level order traversal of the given binary tree.



Example Input

Input 1:

    3
   / \
  9  20
    /  \
   15   7

Input 2:

   1
  / \
 6   2
    /
   3



Example Output

Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]

Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]



Example Explanation

Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
 */
package com.treetravesal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) {
//       val = x;
//       left=null;
//       right=null;
//      }
//  }


public class LevelOrderTravesal {

    public static void main(String[] args) {
        int[] pre = new int[] {1, 6, 2, 3};   // first element in preOrder array is root element as travesal is : root -> left-> right
        int[] in = new int[] {6, 1, 3, 2};    // inOrder tree travesal is left-> root -> right
        int n = pre.length;

        BinaryTreeInorderPreOrder treeNode = BinaryTreeInorderPreOrder.helper(pre,in,0,n-1,0,n-1);

            if (treeNode==null) {
                System.out.println("null");
                System.exit(0);
            }

            Queue<BinaryTreeInorderPreOrder> queue = new LinkedList<>();
            ArrayList<ArrayList<Integer>> output = new ArrayList<>();
            queue.add(treeNode);

            while(!queue.isEmpty()){
                int size = queue.size();
                ArrayList<Integer> temp = new ArrayList<>();

                for (int i=0; i<size; i++) {
                    BinaryTreeInorderPreOrder node = queue.remove();
                    temp.add(node.val);

                    if (node.left!=null){
                        queue.add(node.left);
                    }
                    if (node.right!=null){
                        queue.add(node.right);
                    }
                }
                output.add(temp);
            }

            System.out.println(output);
    }
}
