package com.leet.dsa30days2;

public class SubarraySumEqualsK {

	//Time Complexity: O(n)
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int n = nums.length;
		java.util.Map<Integer, Integer> preSumCount = new java.util.HashMap<>();
		preSumCount.put(0, 1); // To handle the case when subarray starts from index 0
		int preSum = 0;

		for (int i = 0; i < n; i++) {
			preSum += nums[i];
			if (preSumCount.containsKey(preSum - k)) {
				count += preSumCount.get(preSum - k);
			}
			preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
		}

		return count;
	}
	
	//Time Complexity: O(n^2)
	public static int subarraySum_2(int[] nums, int k) {
		int count = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				if (sum == k) {
					count++;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
	}

}
