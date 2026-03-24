package com.leet;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }

public class MergeKSortedLists_11 {

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return mergeKListsHelper(lists, 0, lists.length - 1);

	}

	private static ListNode mergeKListsHelper(ListNode[] lists, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j) {
			return lists[i];
		}
		if (i < j) {
			int mid = i + (j - i) / 2;
			ListNode left = mergeKListsHelper(lists, i, mid);
			ListNode right = mergeKListsHelper(lists, mid + 1, j);
			return mergeTwoLists(left, right);
		}
		return null;
	}

	private static ListNode mergeTwoLists(ListNode left, ListNode right) {
		// TODO Auto-generated method stub
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		if (left.val < right.val) {
			left.next = mergeTwoLists(left.next, right);
			return left;
		} else {
			right.next = mergeTwoLists(left, right.next);
			return right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode[] lists = { l1, l2, l3 };
		ListNode result = mergeKLists(lists);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

}
