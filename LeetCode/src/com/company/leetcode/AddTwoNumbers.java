package com.company.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        addTwoNumbers(new ListNode(), new ListNode());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int a = 0;

        ListNode cur = res;
        while (l1 != null || l2 != null || a != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int resVal = l1Val + l2Val + a;
            a = resVal / 10;

            cur.next = new ListNode(resVal % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

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
