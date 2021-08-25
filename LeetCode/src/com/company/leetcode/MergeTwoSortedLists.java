package com.company.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        mergeTwoLists(new ListNode(), new ListNode());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;
        return res.next;
    }

    //    Definition for singly-linked list.
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
