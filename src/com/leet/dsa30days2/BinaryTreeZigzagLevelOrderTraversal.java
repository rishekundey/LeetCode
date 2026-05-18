package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeZigzagLevelOrderTraversal {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queue.poll();
				if (leftToRight) {
					currentLevel.add(currentNode.val);
				} else {
					currentLevel.add(0, currentNode.val);
				}
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentLevel);
			leftToRight = !leftToRight;
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = zigzagLevelOrder(root);
		for (List<Integer> level : result) {
			for (Integer val : level) {
				System.out.print(val + " ");
			}
		}
	}
}
