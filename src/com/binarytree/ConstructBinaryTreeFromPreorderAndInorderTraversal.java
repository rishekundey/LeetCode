package com.binarytree;

import java.util.HashMap;
import java.util.Map;

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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	static int preIndex = 0;
    static Map<Integer, Integer> inMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int inIndex = inMap.get(root.val);

        root.left = helper(preorder, inorder, inStart, inIndex - 1);
        root.right = helper(preorder, inorder, inIndex + 1, inEnd);
        return root;
    }

	public static TreeNode buildTreeHelper_2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = buildTreeHelper_2(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k - 1);
        root.right = buildTreeHelper_2(preorder, preStart + k - inStart + 1, preEnd, inorder, k + 1, inEnd);

        return root;
    }
	
	public static TreeNode buildTree_2(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}
		return buildTreeHelper_2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println("Root: " + root.val); // Output: Root: 3
		
		
	}

}
