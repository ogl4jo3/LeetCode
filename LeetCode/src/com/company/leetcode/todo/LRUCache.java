package com.company.leetcode.todo;

import java.util.HashMap;
import java.util.Map;

class LRUCacheTest {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        int capacity = 5;
        int key = 0;
        int value = 3;
        LRUCache obj = new LRUCache(capacity);
        int param_1 = obj.get(key);
        obj.put(key, value);
    }

}

public class LRUCache {

    int capacity;
    Map<Integer, Node> data;
    Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
        dummyHead = new Node(-1);
        dummyTail = new Node(-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            Node cur = data.get(key);
            //remove cur link
            Node prev = cur.prev;
            Node next = cur.next;
            prev.next = next;
            next.prev = prev;
            //move to first
            cur.next = dummyHead.next;
            cur.prev = dummyHead;
            dummyHead.next.prev = cur;
            dummyHead.next = cur;
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        System.out.println("key: " + key);
        System.out.println("value: " + value);
        if (data.containsKey(key)) {
            //update value
            Node cur = data.get(key);
            cur.val = value;
            //remove cur link
            Node prev = cur.prev;
            Node next = cur.next;
            prev.next = next;
            next.prev = prev;
            //move to first
            cur.next = dummyHead.next;
            cur.prev = dummyHead;
            dummyHead.next.prev = cur;
            dummyHead.next = cur;
            data.put(key, cur);
        } else {
            if (data.size() >= capacity) {
                //remove last
                Node last = dummyTail.prev;
                Node prev = last.prev;
                Node next = last.next;
                prev.next = next;
                next.prev = prev;
                //TODO:
                data.remove(last.val);
            }
            //put to first
            Node newNode = new Node(value);
            Node prev = dummyHead;
            Node next = dummyHead.next;
            newNode.next = next;
            newNode.prev = prev;
            next.prev = newNode;
            prev.next = newNode;
            data.put(key, newNode);
        }
    }
}

class Node {
    Node prev;
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

}
