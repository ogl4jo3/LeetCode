package com.company.leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        ListNode reversedListNode = reverseList2(l1);
    }

    //iteratively
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    //recursively
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tmp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return tmp;
    }

    public static class ListNode {
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
}
