package com.leet.dsa30days2;

public class FindTheDuplicateNumber {
	
	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		boolean[] seen = new boolean[n];
		for (int num : nums) {
			if (seen[num]) {
				return num;
			}
			seen[num] = true;
		}
		return -1; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 })); // Output: 2
	}

}
