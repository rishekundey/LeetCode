package com.leet.dsa30days2;

/*
 * 206. Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * Input: head = []
 * Output: []
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you 
 * implement both?
 * 
 * Solution: Iterative approach
 * Time Complexity: O(n), where n is the number of nodes in the linked list.
 * Space Complexity: O(1), as we are using only a constant amount of extra space.
 * 
 * Solution: Recursive approach
 * Time Complexity: O(n), where n is the number of nodes in the linked list.
 * Space Complexity: O(n), due to the recursive call stack.
 * 
 * Explanation Video: https://www.youtube.com/watch?v=G0_I-ZF0Ssw
 * 
 */

public class ReverseLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode head = rll.new ListNode(1);
		head.next = rll.new ListNode(2);
		head.next.next = rll.new ListNode(3);
		head.next.next.next = rll.new ListNode(4);
		head.next.next.next.next = rll.new ListNode(5);
		ListNode reversedHead = reverseList(head);
		ListNode curr = reversedHead;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}

}
