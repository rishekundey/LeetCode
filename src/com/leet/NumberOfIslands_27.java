package com.leet;

public class NumberOfIslands_27 {

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int numIslands = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					numIslands++;
					dfs(grid, i, j);
				}
			}
		}
		return numIslands;
	}

	private static void dfs(char[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		int rows = grid.length;
		int cols = grid[0].length;
		if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } })); // 1
		System.out.println(numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } })); // 3
		System.out.println(numIslands(new char[][] { { '1', '0', '1', '1', '0', '1', '1' },
				{ '1', '0', '0', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0', '0', '0' } })); // 3

	}

}
