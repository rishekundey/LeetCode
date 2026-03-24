package com.leet.dsa30days2;

public class RotateImage {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		// Transpose the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// Reverse each row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix1);
		// Output: [[7,4,1],[8,5,2],[9,6,3]]
		for (int[] row : matrix1) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
