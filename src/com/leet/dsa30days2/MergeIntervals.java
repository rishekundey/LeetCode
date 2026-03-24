package com.leet.dsa30days2;

import java.util.Arrays;

public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {
		int[][] res = new int[intervals.length][2];
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		int index = -1;
		for (int[] interval : intervals) {

			if (index == -1 || res[index][1] < interval[0]) {
				res[++index] = interval;
			} else {
				res[index][1] = Math.max(res[index][1], interval[1]);
			}
		}

		return Arrays.copyOf(res, index + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mergedIntervals = merge(new int[][] { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } });
		for (int[] interval : mergedIntervals) {
			System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
		}
		System.out.println(); 
		mergedIntervals = merge(new int[][] { {4, 7}, {1, 4} }); 
		for (int[] interval : mergedIntervals) { 
			System.out.print("[" +interval[0] + ", " + interval[1] + "] ");
		}
	}

}
