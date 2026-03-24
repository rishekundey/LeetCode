package com.leet.dsa30days2;

public class BinaryTreeMaximumPathSum {

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

	public static int maxPathSum(TreeNode root) {
		int[] maxSum = new int[] { Integer.MIN_VALUE };
		helper(root, maxSum);
		return maxSum[0];

	}

	public static int helper(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(helper(node.left, maxSum), 0);
        int rightGain = Math.max(helper(node.right, maxSum), 0);

        int currentPathSum = node.val + leftGain + rightGain;

        maxSum[0] = Math.max(maxSum[0], currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum tree = new BinaryTreeMaximumPathSum();
		TreeNode root = tree.new TreeNode(-10);
		root.left = tree.new TreeNode(9);
		root.right = tree.new TreeNode(20);
		root.right.left = tree.new TreeNode(15);
		root.right.right = tree.new TreeNode(7);
		int result = maxPathSum(root);
		System.out.println("Maximum Path Sum: " + result); // Output: 42
		
		root = tree.new TreeNode(1);
		root.left = tree.new TreeNode(2);
		root.right = tree.new TreeNode(3);
		result = maxPathSum(root);
		System.out.println("Maximum Path Sum: " + result); // Output: 6

	}

}
