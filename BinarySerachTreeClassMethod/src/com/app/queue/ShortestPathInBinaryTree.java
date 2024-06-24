package com.app.queue;

import java.util.ArrayList;
import java.util.List;

class TreeNodeT {
	int val;
	TreeNodeT left;
	TreeNodeT right;

	TreeNodeT(int x) {
		val = x;
	}
}

public class ShortestPathInBinaryTree {

	public String getDirections(TreeNodeT root, int startValue, int destValue) {
		// Find the path from root to startValue and root to destValue
		List<TreeNodeT> pathToStart = new ArrayList<>();
		List<TreeNodeT> pathToDest = new ArrayList<>();

		findPath(root, startValue, pathToStart);
		findPath(root, destValue, pathToDest);

		// Find the lowest common ancestor (LCA)
		int i = 0;
		while (i < pathToStart.size() && i < pathToDest.size() && pathToStart.get(i) == pathToDest.get(i)) {
			i++;
		}
		i--; // step back to the last common node

		// Build the directions
		StringBuilder directions = new StringBuilder();

		// Steps to move up from startValue to LCA
		for (int j = pathToStart.size() - 1; j > i; j--) {
			directions.append('U');
		}

		// Steps to move down from LCA to destValue
		for (int j = i + 1; j < pathToDest.size(); j++) {
			if (pathToDest.get(j) == pathToDest.get(j - 1).left) {
				directions.append('L');
			} else {
				directions.append('R');
			}
		}

		return directions.toString();
	}

	private boolean findPath(TreeNodeT root, int value, List<TreeNodeT> path) {
		if (root == null) {
			return false;
		}

		path.add(root);

		if (root.val == value) {
			return true;
		}

		if (findPath(root.left, value, path) || findPath(root.right, value, path)) {
			return true;
		}

		path.remove(path.size() - 1); // backtrack
		return false;
	}

	public static void main(String[] args) {
		// Example usage:
		// Constructing the binary tree: [5,1,2,3,null,6,4]
		TreeNodeT root = new TreeNodeT(5);
		root.left = new TreeNodeT(1);
		root.right = new TreeNodeT(2);
		root.left.left = new TreeNodeT(3);
		root.right.right = new TreeNodeT(6);
		root.right.left = new TreeNodeT(4);

		int startValue = 3;
		int destValue = 6;

		ShortestPathInBinaryTree solution = new ShortestPathInBinaryTree();
		String shortestPath = solution.getDirections(root, startValue, destValue);

		System.out.println("Shortest path from " + startValue + " to " + destValue + ": " + shortestPath);
	}
}
