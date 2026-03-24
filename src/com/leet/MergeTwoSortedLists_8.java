package com.leet;

public class MergeTwoSortedLists_8 {
	
	class ListNode {
		     int val;
		     ListNode next;
		     ListNode() {}
		     ListNode(int val) { this.val = val; }
		     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	
			public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
				if (list1 == null)
					return list2;
				if (list2 == null)
					return list1;

				if (list1.val < list2.val) {
					list1.next = mergeTwoLists(list1.next, list2);
					return list1;
				} else {
					list2.next = mergeTwoLists(list1, list2.next);
					return list2;
				}
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new MergeTwoSortedLists_8().new ListNode(1);
		l1.next = new MergeTwoSortedLists_8().new ListNode(2);
	    l1.next.next = new MergeTwoSortedLists_8().new ListNode(4);
	    ListNode l2 = new MergeTwoSortedLists_8().new ListNode(1);
	    l2.next = new MergeTwoSortedLists_8().new ListNode(3);
	    l2.next.next = new MergeTwoSortedLists_8().new ListNode(4);
        ListNode merged = new MergeTwoSortedLists_8().mergeTwoLists(l1, l2);
        
        System.out.print("[");
        while(merged != null) {
			System.out.print(merged.val);
			merged = merged.next;
			if(merged != null) System.out.print(", ");
        }
        System.out.print("]");
        
	}

}
