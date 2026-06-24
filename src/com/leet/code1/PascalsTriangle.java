package com.leet.code1;

import java.util.ArrayList;
import java.util.List;

/*
 * Pascal's Triangle is a triangular array of numbers where each number is the sum of the two numbers directly above it. The triangle starts with a single 1 at the top, and each subsequent row contains one more number than the previous row.
 * 
 * For example, the first five rows of Pascal's Triangle are: 
 * 
 * 	 	 1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1
 *   
 *   1
 *   1 1
 *   1 2 1
 *   1 3 3 1
 *   1 4 6 4 1
 *   
 *   Constraints:
 *   1 <= numRows <= 30
 *   
 *   Explanation Video: https://www.youtube.com/watch?v=8jLOx1hD3_o
 *   
 *   Time Complexity: O(numRows^2), where numRows is the number of rows in the triangle. The algorithm iterates through each row and each element in the row, resulting in a quadratic time complexity.
 *   Space Complexity: O(numRows^2), as the algorithm constructs a list of lists to represent the triangle, which requires space proportional to the number of rows squared.
 *   
 *   Data Structures Used: The algorithm uses a list of lists to store the triangle, where each inner list represents a row in the triangle.
 *   
 *   Algorithm: The algorithm iterates through each row of the triangle, starting from the first row. For each row, it calculates the values of the elements based on the values of the elements in the previous row. The first and last elements of each row are always 1, while the other elements are calculated as the sum of the two elements directly above them in the previous row. The constructed rows are then added to the triangle list.
 *       
 */

public class PascalsTriangle {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
				}
			}
			triangle.add(row);
        }
		return triangle;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(5));
	}

}
