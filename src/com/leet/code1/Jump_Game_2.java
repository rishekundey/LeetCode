package com.leet.code1;

public class Jump_Game_2 {

	public static int jump(int[] nums) {
		int jumps = 0;
		int currentEnd = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == currentEnd) {
				jumps++;
				currentEnd = farthest;
			}
		}
		return jumps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jump(new int[] {2,3,1,1,4})); // Output: 2
		System.out.println(jump(new int[] {2,3,0,1,4})); // Output: 2
		System.out.println(jump(new int[] {0})); // Output: 0
		System.out.println(jump(new int[] {1,2,1,1,1})); // Output: 3
		

	}

}
