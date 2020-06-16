package com.htoyama.leetcode._138;

import java.util.HashMap;

class Solution {
  private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  /**
   * 0 ms	39.5 MB
   */
  public Node copyRandomList(Node head) {
    if (head == null) return null;

    HashMap<Node, Node> nodeMap = new HashMap<>();
    Node copiedHead = new Node(head.val);
    nodeMap.put(head, copiedHead);

    Node cur = head;
    Node copiedCur = copiedHead;
    while (cur.next != null) {
      copiedCur.next = new Node(cur.next.val);
      nodeMap.put(cur.next, copiedCur.next);
      copiedCur = copiedCur.next;
      cur = cur.next;
    }

    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        Node src = nodeMap.get(cur);
        src.random = nodeMap.get(cur.random);
      }
      cur = cur.next;
    }

    return copiedHead;
  }
}
