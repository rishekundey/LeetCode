package com.leet.dsa30days2;

import java.util.Collections;
import java.util.PriorityQueue;

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
