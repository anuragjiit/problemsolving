package com.treetravesal;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class BalancedBinaryTree {

    boolean isCheck = true;

    public int isBalanced(TreeNode A) {
        int h = height(A);
        if(isCheck==true) {
            return 1;
        }
        return 0;
    }

    public int height(TreeNode A) {
        if(A==null) {
            return 0;
        }
        int leftHeight = height(A.left);
        int rightHeight = height(A.right);

        if (Math.abs(leftHeight-rightHeight)>1){
            isCheck = false;
        }
        return (Math.max(leftHeight,rightHeight)+1);
    }
}
