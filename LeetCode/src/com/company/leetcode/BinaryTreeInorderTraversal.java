package com.company.leetcode;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");
        TreeNode testNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> actRecursive = inorderTraversalRecursive(testNode);
        System.out.println(Arrays.toString(actRecursive.toArray()));
        List<Integer> actIterative = inorderTraversalIterative(testNode);
        System.out.println(Arrays.toString(actIterative.toArray()));
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);

            TreeNode curRight = cur.right;
            while (curRight != null) {
                stack.push(curRight);
                curRight = curRight.left;
            }
        }

        return res;
    }

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
