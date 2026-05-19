package com.leet.dsa30days2;

// 73. Set Matrix Zeroes
// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.
// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//  Constraints:
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
// Follow up:
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
// https://leetcode.com/problems/set-matrix-zeroes/description/
// Approach:
// 1. First, we check if the first row and first column contain any zeros and store that 
// information in two boolean variables, `firstRowZero` and `firstColZero`.
// 2. Next, we iterate through the matrix starting from the second row and second column. 
// If we find a zero, we mark the corresponding first row and first column elements as zero 
// to indicate that the entire row and column should be set to zero later.
// 3. After marking, we iterate through the matrix again and set the elements to zero based 
// on the markers in the first row and first column.
// 4. Finally, we check the boolean variables to determine if we need to set the first row 
// and first column to zero as well.
// This approach allows us to achieve the desired result in place with O(1) additional space, 
// as we are using the first row and first column of the matrix itself to store the markers.
// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in 
// the matrix.
// Space Complexity: O(1) since we are using the matrix itself for marking and only a 
// constant amount of additional space for the boolean variables.
// https://www.youtube.com/watch?v=1uB9qM0D8sQ&t=1s&ab_channel=NeetCode


public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean firstRowZero = false;
		boolean firstColZero = false;

		// Check if first row has a zero
		for (int j = 0; j < cols; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// Check if first column has a zero
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		// Use first row and column as markers
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Set zeros based on markers
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// Set first row to zero if needed
		if (firstRowZero) {
			for (int j = 0; j < cols; j++) {
				matrix[0][j] = 0;
			}
		}

		// Set first column to zero if needed
		if (firstColZero) {
			for (int i = 0; i < rows; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Set Matrix Zeroes Test");
		SetMatrixZeroes smz = new SetMatrixZeroes();
		int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		smz.setZeroes(matrix1);
		// Output: [[1,0,1],[0,0,0],[1,0,1]]
		for (int[] row : matrix1) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
