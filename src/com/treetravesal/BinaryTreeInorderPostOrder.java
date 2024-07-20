/*
Problem Description

Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format

Return the root node of the binary tree.



Example Input

Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]

Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]



Example Output

Output 1:

   1
  / \
 2   3

Output 2:

   1
  / \
 6   2
    /
   3



Example Explanation

Explanation 1:

 Create the binary tree and return the root node of the tree.
 */
package com.treetravesal;

public class BinaryTreeInorderPostOrder {
    int val;
    BinaryTreeInorderPostOrder left;
    BinaryTreeInorderPostOrder right;
    BinaryTreeInorderPostOrder(int x) {
        val = x;
        left = null;
        right = null;
    }

    public static void main(String[] args) {
        int[] in = new int[] {6, 1, 3, 2};    // inOrder tree travesal is left-> root -> right
        int[] post = new int[] {6, 3, 2, 1};   // Last element in postOrder array is root element as travesal is :  left-> right->root

        if(post.length!=in.length){
            System.out.println("Invalid array");
            System.exit(0);
        }
        int n = post.length;

        BinaryTreeInorderPostOrder ans = helper(in, 0, n-1, post, 0, n-1);

        System.out.println("In Order Travasal : Left -> Root -> right");
        inOrderTravasal(ans);

        System.out.println("Post Order Travasal : Left -> right -> Root");
        postOrderTravasal(ans);
    }

    public static BinaryTreeInorderPostOrder helper(int[] inOrder,int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }
        int rootData = postOrder[postEnd];

        BinaryTreeInorderPostOrder root = new BinaryTreeInorderPostOrder(rootData);
        int rootIdx = -1;

        for (int i=inStart; i<=inEnd; i++) {
            if ( inOrder[i] == rootData) {
                rootIdx = i;
                break;
            }
        }

        if(rootIdx == -1) {
            return null;
        }

        int temp = rootIdx - inStart;  // in -> 6, 1, 3, 2 .. post -> 6, 3, 2, 1

        root.left = helper(inOrder, inStart, rootIdx-1, postOrder, postStart, postStart+temp-1);
        root.right = helper(inOrder,rootIdx+1, inEnd, postOrder, postStart+temp, postEnd-1);

        return root;
    }

    public static void inOrderTravasal(BinaryTreeInorderPostOrder root) {  // L , Root, R
        if(root == null){
            return;
        }
        inOrderTravasal(root.left);
        System.out.println(root.val);
        inOrderTravasal(root.right);
    }

    public static void postOrderTravasal(BinaryTreeInorderPostOrder root) {  // Root , L , R
        if(root == null){
            return;
        }
        postOrderTravasal(root.left);
        postOrderTravasal(root.right);
        System.out.println(root.val);
    }
}
