package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

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
