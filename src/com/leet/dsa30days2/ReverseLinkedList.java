package com.leet.dsa30days2;

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
