package com.app.preorder;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class AllTaversal {
	public static TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
	}

	private static TreeNode bstFromPreorder(int[] preorder, int bound, int[] index) {
		if (index[0] == preorder.length || preorder[index[0]] > bound) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[index[0]++]);
		root.left = bstFromPreorder(preorder, root.val, index);
		root.right = bstFromPreorder(preorder, bound, index);
		return root;
	}

	// Helper method to print the tree in preorder for verification
	public static void printPreOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	// Helper method to print the tree in inorder for verification
	public static void printInOrder(TreeNode node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.val + " ");
			printInOrder(node.right);
		}
	}

	// Helper method to print the tree in postorder for verification
	public static void printPostOrder(TreeNode node) {
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.val + " ");
		}
	}

	public static void main(String[] args) {
		AllTaversal sol = new AllTaversal();
		int[] preorder = { 8, 5, 1, 7, 10, 12 };
		TreeNode root = sol.bstFromPreorder(preorder);

		// Print the tree in preorder to verify the structure
		System.out.println("Preorder traversal of the constructed BST:");
		printPreOrder(root);
		System.out.println();

		// Print the tree in inorder to verify the structure
		System.out.println("Inorder traversal of the constructed BST:");
		printInOrder(root);
		System.out.println();

		// Print the tree in postorder to verify the structure
		System.out.println("Postorder traversal of the constructed BST:");
		printPostOrder(root);
		System.out.println();
	}
}
