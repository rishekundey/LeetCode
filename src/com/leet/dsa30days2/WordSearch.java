package com.leet.dsa30days2;

// 79. Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in 
// the grid.
// The word can be constructed from letters of sequentially adjacent cells, where adjacent 
// cells are horizontally or vertically neighboring. The same letter cell may not be used 
// more than once.
// Explanation: We can use Depth-First Search (DFS) to explore the grid. We start from each 
// cell and check if it matches the first character of the word. If it does, we recursively 
// check its neighbors for the next character in the word. We mark cells as visited to avoid 
// using the same cell more than once. If we find all characters of the word, we return true. 
// If we exhaust all possibilities without finding the word, we return false.
// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true


public class WordSearch {

	public static boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (dfs(board, word, r, c, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, String word, int r, int c, int index) {
		if (index == word.length()) {
			return true;
		}
		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
			return false;
		}

		char temp = board[r][c];
		board[r][c] = '#'; // Mark as visited

		boolean found = dfs(board, word, r + 1, c, index + 1) || 
						dfs(board, word, r - 1, c, index + 1) || 
						dfs(board, word, r, c + 1, index + 1) || 
						dfs(board, word, r, c - 1, index + 1);

		board[r][c] = temp; // Restore original value
		return found;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED")); // true
		System.out.println(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE")); // true
		System.out.println(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB")); // false
	}

}
