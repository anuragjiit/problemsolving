package com.treetravesal;

public class BinaryTreeInorderPreOrder {
      int val;
      BinaryTreeInorderPreOrder left;
      BinaryTreeInorderPreOrder right;
      BinaryTreeInorderPreOrder(int x) {
          val = x;
          left = null;
          right = null;
      }

    public static void main(String[] args) {
        int[] pre = new int[] {8,6,2,11,16,10,12,4,14,18,9,15};   // first element in preOrder array is root element as travesal is : root -> left-> right
        int[] in = new int[] {11,2,16,6,10,12,8,14,18,4,9,15};    // inOrder tree travesal is left-> root -> right
        // postOrder : Left -> right -> Root

        if(pre.length!=in.length){
            System.out.println("Invalid array");
            System.exit(0);
        }
        int n = pre.length;

        BinaryTreeInorderPreOrder ans = helper(pre,in,0,n-1,0,n-1);

        System.out.println("In Order Travasal : Left -> Root -> right");
        inOrderTravasal(ans);

        System.out.println("Pre Order Travasal : Root-> Left -> right");
        PreOrderTravasal(ans);

    }

    public static BinaryTreeInorderPreOrder helper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        int rootData = preOrder[preStart];

        BinaryTreeInorderPreOrder root = new BinaryTreeInorderPreOrder(rootData);
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

        int temp = rootIdx - inStart;

        root.left = helper(preOrder, inOrder, preStart+1, preStart+temp, inStart, rootIdx-1);
        root.right = helper(preOrder, inOrder, preStart+temp+1, preEnd, rootIdx+1, inEnd);

        return root;
    }

    public static void inOrderTravasal(BinaryTreeInorderPreOrder root) {  // L , Root, R
          if(root == null){
              return;
          }
          inOrderTravasal(root.left);
          System.out.println(root.val);
          inOrderTravasal(root.right);
    }

    public static void PreOrderTravasal(BinaryTreeInorderPreOrder root) {  // Root , L , R
        if(root == null){
            return;
        }
        System.out.println(root.val);
        PreOrderTravasal(root.left);
        PreOrderTravasal(root.right);
    }
}
