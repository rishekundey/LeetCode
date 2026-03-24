package com.leet;

public class MaximumDepthOfBinaryTree_28 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new MaximumDepthOfBinaryTree_28().new TreeNode(3);
		root.left = new MaximumDepthOfBinaryTree_28().new TreeNode(9);
		root.right = new MaximumDepthOfBinaryTree_28().new TreeNode(20);
		root.right.left = new MaximumDepthOfBinaryTree_28().new TreeNode(15);
		root.right.right = new MaximumDepthOfBinaryTree_28().new TreeNode(7);
		System.out.println(maxDepth(root)); // 3
		
		TreeNode root2 = new MaximumDepthOfBinaryTree_28().new TreeNode(1);
		root2.right = new MaximumDepthOfBinaryTree_28().new TreeNode(2);
		System.out.println(maxDepth(root2)); // 2
		

	}

}
