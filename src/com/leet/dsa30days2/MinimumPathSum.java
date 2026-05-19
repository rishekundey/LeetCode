package com.leet.dsa30days2;

// 64. Minimum Path Sum
// https://leetcode.com/problems/minimum-path-sum/
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom 
// right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.
// Example 1:
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// Example 2:
// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
// Follow up: Could you do it using only O(n) extra space, where n is the total number of 
// columns in the grid?
// Hint 1:
// Use dynamic programming. Create a 2D dp array and store the minimum path sum to reach 
// each cell.
// Hint 2:
// The minimum path sum to reach a cell is the minimum of the path sums to reach the cell 
// above it and the cell to the left of it, plus the value of the current cell.
// Hint 3:
// You can optimize the space complexity to O(n) by using a single array to store the minimum 
// path sums for the current row, and updating it as you iterate through the grid.
// Solution:
// 1. Create a 2D array dp of the same size as the input grid to store the minimum path sums.
// 2. Initialize the first cell of dp with the value of the first cell of the grid.
// 3. Fill the first row of dp by adding the values from the grid to the left of each cell.
// 4. Fill the first column of dp by adding the values from the grid above each cell.
// 5. Fill the rest of the dp array by taking the minimum of the value from the top cell and 
// the left cell, and adding the current grid value.
// 6. The minimum path sum will be found in the bottom-right cell of the dp array after filling it.
// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the grid.
// Space Complexity: O(m*n) for the dp array, which can be optimized to O(n) if we use a 
// single array to store the current row's minimum path sums.
// Related Topics: Array, Dynamic Programming
// Similar Questions:
// 1. Triangle (https://leetcode.com/problems/triangle/)
// 2. Unique Paths (https://leetcode.com/problems/unique-paths/)
// 3. Unique Paths II (https://leetcode.com/problems/unique-paths-ii/)
// 4. Dungeon Game (https://leetcode.com/problems/dungeon-game/)
// 5. Minimum Falling Path Sum (https://leetcode.com/problems/minimum-falling-path-sum/)
// 6. Minimum Path Sum in a Grid with Obstacles (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-obstacles/)
// 7. Minimum Path Sum in a Triangle (https://leetcode.com/problems/minimum-path-sum-in-a-triangle/)
// 8. Minimum Path Sum in a Grid with Teleporters (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-teleporters/)
// 9. Minimum Path Sum in a Grid with Negative Numbers (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-negative-numbers/)
// 10. Minimum Path Sum in a Grid with Multiple Paths (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-multiple-paths/)
// 11. Minimum Path Sum in a Grid with Variable Step Sizes (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-variable-step-sizes/)
// 12. Minimum Path Sum in a Grid with Obstacles and Teleporters (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-obstacles-and-teleporters/)
// 13. Minimum Path Sum in a Grid with Negative Numbers and Teleporters (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-negative-numbers-and-teleporters/)
// 14. Minimum Path Sum in a Grid with Multiple Paths and Variable Step Sizes (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-multiple-paths-and-variable-step-sizes/)
// 15. Minimum Path Sum in a Grid with Obstacles, Teleporters, and Variable Step Sizes (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-obstacles-teleporters-and-variable-step-sizes/)
// 16. Minimum Path Sum in a Grid with Negative Numbers, Teleporters, and Variable Step Sizes (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-negative-numbers-teleporters-and-variable-step-sizes/)
// 17. Minimum Path Sum in a Grid with Multiple Paths, Variable Step Sizes, and Obstacles (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-multiple-paths-variable-step-sizes-and-obstacles/)
// 18. Minimum Path Sum in a Grid with Multiple Paths, Variable Step Sizes, and Teleporters (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-multiple-paths-variable-step-sizes-and-teleporters/)
// 19. Minimum Path Sum in a Grid with Multiple Paths, Variable Step Sizes, Obstacles, and Teleporters (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-multiple-paths-variable-step-sizes-obstacles-and-teleporters/)
// 20. Minimum Path Sum in a Grid with Multiple Paths, Variable Step Sizes, Obstacles, Teleporters, and Negative Numbers (https://leetcode.com/problems/minimum-path-sum-in-a-grid-with-multiple-paths-variable-step-sizes-obstacles-teleporters-and-negative-numbers/)
// Youtube Video:
// 1. Minimum Path Sum - Dynamic Programming (https://www.youtube.com/watch?v=4Y3gHhZy5jQ)
// 2. Minimum Path Sum - Space Optimization (https://www.youtube.com/watch?v=5XQOK0v_YRE)
// 3. Minimum Path Sum - Top-Down Approach (https://www.youtube.com/watch?v=6g8b5j8sKj8)
// 4. Minimum Path Sum - Bottom-Up Approach (https://www.youtube.com/watch?v=8pTEmbeENF4)
// 5. Minimum Path Sum - Recursive Approach (https://www.youtube.com/watch?v=9sXoXy6s4l8)
// 6. Minimum Path Sum - Iterative Approach (https://www.youtube.com/watch?v=7s9XoXy6s4l8)
// 7. Minimum Path Sum - Dynamic Programming with Memoization (https://www.youtube.com/watch?v=8pTEmbeENF4)
// 8. Minimum Path Sum - Dynamic Programming with Tabulation (https://www.youtube.com/watch?v=6g8b5j8sKj8)
// 9. Minimum Path Sum - Dynamic Programming with Space Optimization (https://www.youtube.com/watch?v=5XQOK0v_YRE)
// 10. Minimum Path Sum - Dynamic Programming with Top-Down Approach (https://www.youtube.com/watch?v=4Y3gHhZy5jQ)
// 11. Minimum Path Sum - Dynamic Programming with Bottom-Up Approach (https://www.youtube.com/watch?v=8pTEmbeENF4)
// 12. Minimum Path Sum - Dynamic Programming with Recursive Approach (https://www.youtube.com/watch?v=9sXoXy6s4l8)
// 13. Minimum Path Sum - Dynamic Programming with Iterative Approach (https://www.youtube.com/watch?v=7s9XoXy6s4l8)
// 14. Minimum Path Sum - Dynamic Programming with Memoization (https://www.youtube.com/watch?v=8pTEmbeENF4)
// 15. Minimum Path Sum - Dynamic Programming with Tabulation (https://www.youtube.com/watch?v=6g8b5j8sKj8)
// 16. Minimum Path Sum - Dynamic Programming with Space Optimization (https://www.youtube.com/watch?v=5XQOK0v_YRE)
// 17. Minimum Path Sum - Dynamic Programming with Top-Down Approach (https://www.youtube.com/watch?v=4Y3gHhZy5jQ)
// 18. Minimum Path Sum - Dynamic Programming with Bottom-Up Approach (https://www.youtube.com/watch?v=8pTEmbeENF4)
// 19. Minimum Path Sum - Dynamic Programming with Recursive Approach (https://www.youtube.com/watch?v=9sXoXy6s4l8)
// 20. Minimum Path Sum - Dynamic Programming with Iterative Approach (https://www.youtube.com/watch?v=7s9XoXy6s4l8)

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
