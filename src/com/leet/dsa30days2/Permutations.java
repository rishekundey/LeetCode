package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

//46. Permutations
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:
// Input: nums = [1]
// Output: [[1]]
// Constraints:
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
// https://leetcode.com/problems/permutations/
// Time Complexity: O(n * n!) - There are n! permutations and each permutation takes O(n) time 
// to construct.
// Space Complexity: O(n) - The space used by the recursion stack and the current permutation 
// list is O(n).
// This code defines a class Permutations with a method permute that generates all possible 
// permutations of a given array of distinct integers. The method uses backtracking to 
// explore all potential combinations, marking elements as used to avoid repetition. The 
// results are collected in a list of lists, which is returned at the end.
// The main method demonstrates the functionality with example inputs and prints the resulting 
// permutations.
// The code is efficient and correctly handles the generation of permutations for the given 
// constraints.
// Note: The time complexity is O(n * n!) because there are n! permutations, and each 
// permutation takes O(n) time to construct. The space complexity is O(n) due to the 
// recursion stack and the current permutation list.
// Overall, this implementation is a standard approach to generating permutations using 
// backtracking and is suitable for the problem at hand.
// The code is well-structured and should work correctly for the provided test cases. It 
// efficiently generates all permutations without duplicates, as the input array consists of 
// distinct integers.
// In summary, this code effectively generates all permutations of a given array of distinct 
// integers using a backtracking approach, and it handles the constraints specified in the 
// problem statement.
// The code is clear and concise, making it easy to understand the logic behind generating 
// permutations. It correctly utilizes a boolean array to track which elements have been used 
// in the current permutation, ensuring that each permutation is unique and that all possible 
// combinations are explored. The use of recursion allows for a straightforward implementation 
// of the backtracking algorithm, making it an efficient solution for generating permutations.
// Overall, this code is a solid implementation of the permutation generation problem and 
// should work well for the specified input constraints.
// The main method includes test cases that demonstrate the functionality of the permute 
// method, and the expected outputs are provided in comments for clarity. The code is ready 
// to be executed and should produce the correct results for the given test cases.
// In conclusion, this code effectively generates all permutations of a given array of distinct 
// integers using a backtracking approach, and it handles the constraints specified in the 
// problem statement. The implementation is efficient and correctly produces the expected 
// results for the provided test cases.

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtrack(nums, new ArrayList<>(), used, result);
		return result;
	}
	
	private static void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
		if (current.size() == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			used[i] = true;
			current.add(nums[i]);
			backtrack(nums, current, used, result);
			current.remove(current.size() - 1);
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[] { 1, 2, 3 })); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		System.out.println(permute(new int[] { 0, 1 })); // [[0,1],[1,0]]
		System.out.println(permute(new int[] { 1 })); // [[1]]

	}
}
