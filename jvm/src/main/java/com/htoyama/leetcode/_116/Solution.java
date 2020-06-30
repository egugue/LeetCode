package com.htoyama.leetcode._116;

import java.util.ArrayDeque;

// Definition for a Node.
class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

class Solution {

  public Node connect(Node root) {
    dfs(root);
    return root;
  }

  /**
   * 3 ms	44.9 MB
   */
  private static void dfs(Node root) {
    if (root == null) return;
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i ++) {
        Node node = queue.poll();
        node.next = i == size - 1 ? null : queue.peek();
        if (node.left == null && node.right == null) {
          continue;
        }
        queue.add(node.left);
        queue.add(node.right);
      }
    }
  }
}