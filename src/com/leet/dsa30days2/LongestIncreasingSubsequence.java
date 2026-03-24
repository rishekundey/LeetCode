package com.leet.dsa30days2;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] dp = new int[n];
		int maxLength = 1;

		for (int i = 0; i < n; i++) {
			dp[i] = 1; // Each element is an increasing subsequence of length 1
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}

		return maxLength;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // Output: 4
		System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 })); // Output: 4
		System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 })); // Output: 1
	}

}
