package com.company.leetcode.todo;

import java.util.HashMap;
import java.util.Map;

class LRUCacheTest {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        testCase1();
        testCase2();
    }

    public static void testCase1() {
        System.out.println("================================");
        System.out.println("testCase1:");
        int capacity = 2;
        int testValue;
        LRUCache lruCache = new LRUCache(capacity);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        testValue = lruCache.get(1);
        System.out.println("ans: 1, testValue: " + testValue);
        lruCache.put(3, 3);
        testValue = lruCache.get(2);
        System.out.println("ans: -1, testValue: " + testValue);
        lruCache.put(4, 4);
        testValue = lruCache.get(1);
        System.out.println("ans: -1, testValue: " + testValue);
        testValue = lruCache.get(3);
        System.out.println("ans: 3, testValue: " + testValue);
        testValue = lruCache.get(4);
        System.out.println("ans: 4, testValue: " + testValue);
    }

    public static void testCase2() {
        System.out.println("================================");
        System.out.println("testCase2:");
        int capacity = 2;
        int testValue;
        LRUCache lruCache = new LRUCache(capacity);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        testValue = lruCache.get(1);
        System.out.println("ans: 0, testValue: " + testValue);
        lruCache.put(3, 3);
        testValue = lruCache.get(2);
        System.out.println("ans: -1, testValue: " + testValue);
        lruCache.put(4, 4);
        testValue = lruCache.get(1);
        System.out.println("ans: -1, testValue: " + testValue);
        testValue = lruCache.get(3);
        System.out.println("ans: 3, testValue: " + testValue);
        testValue = lruCache.get(4);
        System.out.println("ans: 4, testValue: " + testValue);
    }

}

//TODO: optimize
public class LRUCache {
    int capacity;
    Map<Integer, Node> data;
    Node dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
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
//        System.out.println("key: " + key);
//        System.out.println("value: " + value);
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
                data.remove(last.key);
            }
            //put to first
            Node newNode = new Node(key, value);
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
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
