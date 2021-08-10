package com.company.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

    }

    public static ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode l : lists) {
            if (l != null) heap.offer(l);
        }
        ListNode res = new ListNode();
        ListNode cur = res;
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            cur.next = tmp;
            cur = cur.next;
            if (tmp.next != null) {
                heap.offer(tmp.next);
            }
        }

        return res.next;
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
