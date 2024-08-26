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
package com.treetravesal;

public class MinimizeHeight {

    static int h = 0;
    static int sum = 0;

    static int counter(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = counter(root.left);
        int right = counter(root.right);
        return left+right+1;
    }

    static void helper(TreeNode root, int height) {

        if(root==null) {
            return;
        }

        helper(root.left, height+1);
        helper(root.right, height+1);

        if(height>h) {
            sum+=root.val;
        }
    }


    public static void main(String[] args) {
        TreeNode A = new TreeNode(4); // not initialised -> this is just to make other prog run .. value is wrong .. need to take from prob statement
        int count = counter(A);
        h = (int) Math.ceil(Math.log(count+1)/Math.log(2));
        helper(A,1);
        System.out.println(sum);
    }
}
