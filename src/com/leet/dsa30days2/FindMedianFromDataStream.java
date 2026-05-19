package com.leet.dsa30days2;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
// Time Complexity: O(log n) for addNum and O(1) for findMedian
// Space Complexity: O(n) for storing the numbers in the heaps
// Approach: We use two heaps to maintain the lower and upper halves of the numbers. The 
// leftMaxHeap is a max heap that stores the smaller half of the numbers, while the 
// rightMinHeap is a min heap that stores the larger half. When we add a number, we compare 
// it with the top of the leftMaxHeap to decide which heap to add it to. After adding, we 
// balance the heaps if necessary. To find the median, if both heaps have the same size, we 
// return the average of their top elements; otherwise, we return the top of the leftMaxHeap 
// as it will have one more element than the rightMinHeap.
// This implementation efficiently maintains the median as new numbers are added to the data 
// stream.
// Example:
// Input: ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//        [[], [1], [2], [], [3], []]
// Output: [null, null, null, 1.5, null, 2.0] 
// Explanation:
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0
// Constraints:
// -10^5 <= num <= 10^5
// There will be at least one element in the data structure before calling findMedian.
// At most 5 * 10^4 calls will be made to addNum and findMedian.
// Follow up:
// If all integer numbers from the stream are between 0 and 100, how would you optimize your 
// solution?
// If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize 
// your solution?
// In the first follow-up, we can use a counting array of size 101 to store the frequency of 
// each number. This allows us to find the median in O(1) time by iterating through the 
// counting array. In the second follow-up, we can still use a counting array for numbers 
//between 0 and 100, and for numbers outside this range, we can use two heaps as in the 
// original solution. This way, we can efficiently handle the majority of numbers while still 
// maintaining the ability to find the median for outliers.
// For the first follow-up, we can maintain a counting array of size 101 to store the 
// frequency of each number. We can also keep track of the total count of numbers added. To 
// find the median, we can iterate through the counting array and keep a cumulative count 
// until we reach the middle point (total count / 2). This approach allows us to find the 
// median in O(1) time after O(n) preprocessing time for adding numbers.
// For the second follow-up, we can maintain a counting array for numbers between 0 and 100, 
// and use two heaps for numbers outside this range. When adding a number, if it is between 
// 0 and 100, we update the counting array; otherwise, we add it to the appropriate heap. 
// To find the median, we first check the counting array to determine how many numbers are 
// in the range of 0 to 100. If the median falls within this range, we can find it directly 
// from the counting array. If it falls outside this range, we can use the heaps to find the 
// median as in the original solution. This approach optimizes for the majority of numbers 
// while still handling outliers effectively.
// The code below implements the original solution using two heaps to maintain the median of 
// a data stream.
// The follow-up solutions can be implemented separately based on the specific requirements.
// Note: The code below is for the original solution using two heaps. The follow-up solutions 
// would require a different implementation approach.
// The code below defines the MedianFinder class with methods to add numbers and find the 
// median. The main method demonstrates how to use the MedianFinder class.
// The MedianFinder class uses two priority queues (heaps) to maintain the lower and upper 
// halves of the numbers. The addNum method adds a number to the appropriate heap and 
// balances the heaps if necessary. The findMedian method calculates the median based on the 
// sizes of the heaps.
// The main method creates an instance of MedianFinder, adds numbers to it, and prints the 
// median after each addition to demonstrate the functionality of the class.
// The code is self-contained and can be run independently to test the functionality of the 
// MedianFinder class. It demonstrates how to add numbers to the data stream and find the 
// median at any point in time. The expected output is shown in the comments for clarity.
// Overall, this implementation efficiently maintains the median of a data stream using two 
// heaps, allowing for quick updates and retrieval of the median as new numbers are added.
// The code below is a complete implementation of the MedianFinder class along with a 
// demonstration in the main method. It efficiently maintains the median of a data stream 
// using two heaps, allowing for quick updates and retrieval of the median as new numbers 
// are added.

class MedianFinder {
	private PriorityQueue<Integer> leftMaxHeap; 
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }
        
        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }        
        return leftMaxHeap.peek();
    }
}

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian()); // Output: 1.5
		mf.addNum(3);
		System.out.println(mf.findMedian()); // Output: 2.0
		

	}

}
