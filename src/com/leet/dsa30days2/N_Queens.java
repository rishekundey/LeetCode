package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/description/
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:
// Input: n = 1
// Output: [["Q"]]
// Constraints:
// 1 <= n <= 9
// Follow up: Could you solve the problem without recursion?
// Related Topics Array Backtracking
// similar questions
// https://leetcode.com/problems/n-queens-ii/description/
// https://leetcode.com/problems/n-queens-iii/description/
// 
// Explanation: https://www.youtube.com/watch?v=Q9tH2c2n1Yw&t=109s
// Time Complexity: O(N!)
// Space Complexity: O(N^2)


public class N_Queens {

	public static List<List<String>> solveNQueens(int n) {

		List<List<String>> arr = new ArrayList<>();
		char[][] ans = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans[i][j] = '.';
			}
		}
		helperQueen(n, ans, arr, 0);
		return arr;

	}

	public static void helperQueen(int totalNofQueen, char[][] arr, List<List<String>> ans, int row) {
		if (totalNofQueen == row) {
			List<String> smallans = new ArrayList<>();
			for (char[] a : arr) {
				smallans.add(new String(a));
			}
			ans.add(smallans);
			return;
		}
		for (int col = 0; col < totalNofQueen; col++) {
			if (isPossible(totalNofQueen, arr, row, col)) {
				arr[row][col] = 'Q';
				helperQueen(totalNofQueen, arr, ans, row + 1);
				arr[row][col] = '.';
			}
		}
	}

	public static boolean isPossible(int totalNofQueen, char[][] arr, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (arr[i][col] == 'Q')
				return false;
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == 'Q')
				return false;
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
			if (arr[i][j] == 'Q')
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveNQueens(4));
		System.out.println(solveNQueens(1));
		System.out.println(solveNQueens(9));
	}

}
