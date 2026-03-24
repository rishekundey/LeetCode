package com.leet;

public class BinarySearch_26 {

	public static int search(int[] nums, int target) {
		int s = 0, e = nums.length - 1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] < target) {
				s = mid + 1;
				} else {
				e = mid - 1;
			}
		}
		return -1;
	}
	
	public static int searchRecursive(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int target, int i, int j) {
		// TODO Auto-generated method stub
		if(i==j && nums[i] != target) 
			return -1;
		if (i <= j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				return binarySearch(nums, target, mid + 1, j);
			} else {
				return binarySearch(nums, target, i, mid - 1);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(new int[] { -1,0,3,5,9,12 }, 9)); // 4
		System.out.println(search(new int[] { -1,0,3,5,9,12 }, 2)); // -1
		System.out.println(searchRecursive(new int[] { 5 }, 5)); // 0
		System.out.println(searchRecursive(new int[] { 5 }, -5)); // -1
		System.out.println(search(new int[] { 5 }, -5)); // -1
		System.out.println(searchRecursive(new int[] { -1,0,3,5,9,12 }, 9)); // 4
	}

}
