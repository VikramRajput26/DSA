package com.app.queue;

import java.util.HashMap;
import java.util.Map;

class TreeNodeA {
	int val;
	TreeNodeA left;
	TreeNodeA right;

	TreeNodeA(int x) {
		val = x;
	}
}

public class ConstructTreeFromInorderPostorder {

	public TreeNodeA buildTree(int[] inorder, int[] postorder) {
		// Create a map to store indices of inorder elements for quick lookup
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			indexMap.put(inorder[i], i);
		}

		// Call recursive function to build tree
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
	}

	private TreeNodeA buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
			Map<Integer, Integer> indexMap) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		// Root value is the last element in postorder array
		int rootValue = postorder[postEnd];
		TreeNodeA root = new TreeNodeA(rootValue);

		// Find index of rootValue in inorder array
		int rootIndexInorder = indexMap.get(rootValue);

		// Calculate sizes of left and right subtrees
		int leftSubtreeSize = rootIndexInorder - inStart;

		// Recursive calls to build left and right subtrees
		root.left = buildTree(inorder, inStart, rootIndexInorder - 1, postorder, postStart,
				postStart + leftSubtreeSize - 1, indexMap);
		root.right = buildTree(inorder, rootIndexInorder + 1, inEnd, postorder, postStart + leftSubtreeSize,
				postEnd - 1, indexMap);

		return root;
	}

	// Utility function to print the inorder traversal of the tree
	private void inorderTraversal(TreeNodeA root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };

		ConstructTreeFromInorderPostorder solution = new ConstructTreeFromInorderPostorder();
		TreeNodeA root = solution.buildTree(inorder, postorder);

		System.out.println("Inorder traversal of constructed tree:");
		solution.inorderTraversal(root);
	}
}
