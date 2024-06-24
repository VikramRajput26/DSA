package com.app.unique;

import java.util.ArrayList;
import java.util.List;

class TreeNodeH {
	int val;
	TreeNodeH left;
	TreeNodeH right;

	TreeNodeH(int x) {
		val = x;
	}
}

public class UniqueBSTs {
	public List<TreeNodeH> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		return generateTrees(1, n);
	}

	private List<TreeNodeH> generateTrees(int start, int end) {
		List<TreeNodeH> trees = new ArrayList<>();
		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int i = start; i <= end; i++) {
			// Generate all left and right subtrees
			List<TreeNodeH> leftTrees = generateTrees(start, i - 1);
			List<TreeNodeH> rightTrees = generateTrees(i + 1, end);

			// Combine left and right subtrees with root i
			for (TreeNodeH left : leftTrees) {
				for (TreeNodeH right : rightTrees) {
					TreeNodeH currentTree = new TreeNodeH(i);
					currentTree.left = left;
					currentTree.right = right;
					trees.add(currentTree);
				}
			}
		}
		return trees;
	}

	// Helper method to print the tree in level order
	private void printTree(TreeNodeH root) {
		if (root == null) {
			System.out.print("null ");
			return;
		}
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		UniqueBSTs solution = new UniqueBSTs();
		List<TreeNodeH> result = solution.generateTrees(3);

		// Print all unique BSTs
		for (TreeNodeH tree : result) {
			solution.printTree(tree);
			System.out.println();
		}
	}
}
