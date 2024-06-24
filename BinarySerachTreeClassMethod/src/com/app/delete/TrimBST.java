package com.app.delete;

class TreeNodeG {
	int val;
	TreeNodeG left;
	TreeNodeG right;

	TreeNodeG(int x) {
		val = x;
	}
}

public class TrimBST {

	public TreeNodeG trimBST(TreeNodeG root, int low, int high) {
		if (root == null) {
			return null;
		}

		// If the current node's value is less than low, then we only need to consider
		// the right subtree
		if (root.val < low) {
			return trimBST(root.right, low, high);
		}

		// If the current node's value is greater than high, then we only need to
		// consider the left subtree
		if (root.val > high) {
			return trimBST(root.left, low, high);
		}

		// Otherwise, we need to consider both subtrees
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);

		return root;
	}

	// Helper method to print the tree in pre-order for validation
	public void printTree(TreeNodeG node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}

	public static void main(String[] args) {
		// Constructing the BST: [3,0,4,null,2,null,null,1]
		TreeNodeG root = new TreeNodeG(3);
		root.left = new TreeNodeG(0);
		root.right = new TreeNodeG(4);
		root.left.right = new TreeNodeG(2);
		root.left.right.left = new TreeNodeG(1);

		int low = 1;
		int high = 3;

		TrimBST solution = new TrimBST();
		TreeNodeG newRoot = solution.trimBST(root, low, high);

		// Print the trimmed BST
		solution.printTree(newRoot);
	}
}
