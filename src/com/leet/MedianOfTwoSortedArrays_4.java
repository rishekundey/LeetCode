package com.leet;

import java.util.Arrays;

public class MedianOfTwoSortedArrays_4 {

	// Brute Force Approach - Merge and Sort
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Get the sizes of both input arrays.
		int n = nums1.length;
		int m = nums2.length;

		// Merge the arrays into a single sorted array.
		int[] merged = new int[n + m];
		int k = 0;
		for (int i = 0; i < n; i++) {
			merged[k++] = nums1[i];
		}
		for (int i = 0; i < m; i++) {
			merged[k++] = nums2[i];
		}

		// Sort the merged array.
		Arrays.sort(merged);

		// Calculate the total number of elements in the merged array.
		int total = merged.length;

		if (total % 2 == 1) {
			// If the total number of elements is odd, return the middle element as the
			// median.
			return (double) merged[total / 2];
		} else {
			// If the total number of elements is even, calculate the average of the two
			// middle elements as the median.
			int middle1 = merged[total / 2 - 1];
			int middle2 = merged[total / 2];
			return ((double) middle1 + (double) middle2) / 2.0;
		}
	}

	// Code for Two-Pointer Method
	public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int i = 0, j = 0, m1 = 0, m2 = 0;

		// Find median.
		for (int count = 0; count <= (n + m) / 2; count++) {
			m2 = m1;
			if (i != n && j != m) {
				if (nums1[i] > nums2[j]) {
					m1 = nums2[j++];
				} else {
					m1 = nums1[i++];
				}
			} else if (i < n) {
				m1 = nums1[i++];
			} else {
				m1 = nums2[j++];
			}
		}

		// Check if the sum of n and m is odd.
		if ((n + m) % 2 == 1) {
			return (double) m1;
		} else {
			double ans = (double) m1 + (double) m2;
			return ans / 2.0;
		}
	}

	// Code for Binary Search
	public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;

		// Ensure nums1 is the smaller array for simplicity
		if (n1 > n2)
			return findMedianSortedArrays(nums2, nums1);

		int n = n1 + n2;
		int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
		int low = 0, high = n1;

		while (low <= high) {
			int mid1 = (low + high) >> 1; // Calculate mid index for nums1
			int mid2 = left - mid1; // Calculate mid index for nums2

			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

			// Determine values of l1, l2, r1, and r2
			if (mid1 < n1)
				r1 = nums1[mid1];
			if (mid2 < n2)
				r2 = nums2[mid2];
			if (mid1 - 1 >= 0)
				l1 = nums1[mid1 - 1];
			if (mid2 - 1 >= 0)
				l2 = nums2[mid2 - 1];

			if (l1 <= r2 && l2 <= r1) {
				// The partition is correct, we found the median
				if (n % 2 == 1)
					return Math.max(l1, l2);
				else
					return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
			} else if (l1 > r2) {
				// Move towards the left side of nums1
				high = mid1 - 1;
			} else {
				// Move towards the right side of nums1
				low = mid1 + 1;
			}
		}

		return 0; // If the code reaches here, the input arrays were not sorted.
	}

	public static void main(String[] args) {
		int num1[] = { 1, 3 };
		int num2[] = { 2 };

		int num3[] = { 1, 2 };
		int num4[] = { 3, 4 };

		System.out.println(findMedianSortedArrays(num1, num2));
		System.out.println(findMedianSortedArrays(num3, num4));

	}

}
