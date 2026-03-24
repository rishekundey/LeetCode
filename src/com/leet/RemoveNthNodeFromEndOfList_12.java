package com.leet;

public class RemoveNthNodeFromEndOfList_12 {
	
	public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
	
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;

		// Move first n+1 steps ahead
		for (int i = 0; i <= n; i++) {
			if (first == null) {
				return head; // n is larger than the length of the list
			}
			first = first.next;
		}

		// Move both pointers until first reaches the end
		while (first != null) {
			first = first.next;
			second = second.next;
		}

		// Remove the nth node from the end
		if (second.next != null) {
			second.next = second.next.next;
		}

		return dummy.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int n = 2;
		ListNode modifiedHead = removeNthFromEnd(head, n);

		System.out.print("[");
		while (modifiedHead != null) {
			System.out.print(modifiedHead.val);
			modifiedHead = modifiedHead.next;
			if (modifiedHead != null)
				System.out.print(", ");
		}
		System.out.print("]");

	}

}
