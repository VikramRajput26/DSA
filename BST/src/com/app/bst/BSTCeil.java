package com.app.bst;

//Definition for a binary tree node.
class TreeNode1 {
 int val;
 TreeNode1 left;
 TreeNode1 right;
 TreeNode1(int x) { val = x; }
}

public class BSTCeil {
 public static void main(String[] args) {
     // Construct the example tree:
     //       5
     //     /   \
     //    1     7
     //     \
     //      2 
     //       \
     //        3
     TreeNode1 root = new TreeNode1(5);
     root.left = new TreeNode1(1);
     root.right = new TreeNode1(7);
     root.left.right = new TreeNode1(2);
     root.left.right.right = new TreeNode1(3);

     int X = 3;
     System.out.println("The ceil of " + X + " in the BST is: " + findCeil(root, X));
 }

	public static int findCeil(TreeNode1 root, int X) {
     int ceil = -1;
     while (root != null) {
         if (root.val == X) {
             return root.val;
         } else if (root.val < X) {
             root = root.right;
         } else {
             ceil = root.val;
             root = root.left;
         }
     }
     return ceil;
 }
}
