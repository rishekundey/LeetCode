package com.leet.code1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * 
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * 
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * 
 * Explanation Video: https://www.youtube.com/watch?v=44H3cEC2fFM
 * 
 * Time Complexity: O(n log n) where n is the number of intervals. We are sorting the intervals based on 
 * their start index which takes O(n log n) time. After that, we are iterating through the intervals which 
 * takes O(n) time.
 * Space Complexity: O(n) where n is the number of intervals. We are using a list to store the merged intervals 
 * which can take up to O(n) space in the worst case.
 * 
 * Data Structures used: Array, List
 * Algorithm used: Sorting, Merging
 * 
 */

public class MergeIntervals {

	/*
	 * The function takes in a 2D array of intervals and merges all overlapping
	 * intervals, returning a new 2D array of non-overlapping intervals.
	 * 
	 * @param intervals A 2D array of intervals where each interval is represented
	 * as an array of two integers [start, end].
	 * 
	 * @return A 2D array of non-overlapping intervals that cover all the intervals
	 * in the input.
	 * 
	 */
	public static int[][] merge(int[][] intervals){
		if(intervals.length <=1)
			return intervals;
		
		//Sort the intervals by their start index
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		
		List<int[]> merged = new ArrayList<>();
		int[] currentInterval = intervals[0];
		merged.add(currentInterval);
		
		for(int[] interval : intervals) {
			int currentStart = currentInterval[0];
			int currentEnd = currentInterval[1];
			int nextStart = interval[0];
			int nextEnd = interval[1];
			
			if(currentEnd >= nextStart)
				currentInterval[1] = Math.max(currentEnd, nextEnd);
			else {
				currentInterval = interval;
				merged.add(currentInterval);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] mergedIntervals = merge(intervals);
		for (int[] interval : mergedIntervals) {
			System.out.println(Arrays.toString(interval));
		}
	}

}
