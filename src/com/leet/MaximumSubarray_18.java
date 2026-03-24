package com.leet;

public class MaximumSubarray_18 {

	public static int maxSubArray(int[] nums) {
		int sum = 0;
		int max = nums[0];
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(maxSubArray(new int[] {1}));
		System.out.println(maxSubArray(new int[] {5,4,-1,7,8}));

	}

}
