package com.leet;

import java.util.*;

public class AddTwoNumbers_2 {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                current.next = new ListNode(sum % 10);
                carry = sum / 10;
                current = current.next;
            }
            return dummy.next;
        }
    }

    // Helper: parse "[9,9,9,9]" into int[]
    public static int[] parseArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1); // remove [ ]
        if (input.isEmpty()) return new int[0];
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    // Helper: create ListNode from int[]
    public static ListNode createList(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int digit : digits) {
            current.next = new ListNode(digit);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: print ListNode as array-style
    public static void printListAsArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        System.out.println(result.toString());
    }


    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr1 = parseArray("[9,9,9,9,9,9,9]");
        int[] arr2 = parseArray("[9,9,9,9]");

        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        ListNode result = sol.addTwoNumbers(l1, l2);

        printListAsArray(result);
    }
}
