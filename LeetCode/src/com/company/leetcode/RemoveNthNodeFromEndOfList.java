package com.company.leetcode;

public class RemoveNthNodeFromEndOfList {

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
        ListNode res = removeNthFromEnd(l1, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < n + 1; i++) {
            if (fastNode == null) {
                return head.next;
            }
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;

        return head;
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
