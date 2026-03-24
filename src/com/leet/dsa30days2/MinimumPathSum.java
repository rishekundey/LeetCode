package com.leet.dsa30days2;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;

		// Create a 2D array to store the minimum path sums
		int[][] dp = new int[rows][cols];

		// Initialize the starting point
		dp[0][0] = grid[0][0];

		// Fill the first row
		for (int j = 1; j < cols; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		// Fill the first column
		for (int i = 1; i < rows; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		// Fill the rest of the dp array
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		// The bottom-right cell contains the minimum path sum
		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } })); // Output: 7
		System.out.println(minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } })); // Output: 12
		System.out.println(minPathSum(new int[][] { { 5 } })); // Output: 5
	}

}
