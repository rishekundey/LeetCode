package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(candidates, target, 0, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] candidates, int target, int start, List<Integer> current,
			List<List<Integer>> result) {

		System.out.println("Target: " + target + ", Current: " + current);
		
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			System.out.println("  Trying candidate: " + candidates[i]);
			current.add(candidates[i]);
			System.out.println("  Current after adding: " + current);
			System.out.println("  New target: " + (target - candidates[i]));
			
			backtrack(candidates, target - candidates[i], i, current, result);
			System.out.println("  Backtracking from candidate: " + candidates[i]);
			current.remove(current.size() - 1);
			System.out.println("  Current after removing: " + current);
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7)); // [[2,2,3],[7]]
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8)); // [[2,2,2,2],[2,3,3],[3,5]]
		//System.out.println(combinationSum(new int[] { 2 }, 1)); // []
		
	}

}
