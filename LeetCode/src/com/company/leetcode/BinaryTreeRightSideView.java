package com.company.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        // write your code here
        System.out.println("main:");

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans.add(queue.peek().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.right != null) queue.offer(tmp.right);
                if (tmp.left != null) queue.offer(tmp.left);
            }
        }
        return ans;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 1, ans);
        return ans;
    }

    public void dfs(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;
        if (level > ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, level + 1, ans);
        dfs(root.left, level + 1, ans);
    }

    public class TreeNode {
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
