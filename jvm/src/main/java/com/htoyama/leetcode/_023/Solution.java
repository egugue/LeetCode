package com.htoyama.leetcode._023;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.LinkedList_;
import com.htoyama.leetcode.utils.data.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
@Level.Hard
@LinkedList_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.mergeKLists(new ListNode[]{
      ListNode.of("1->4->5"),
      ListNode.of("1->3->4"),
      ListNode.of("2->6")
    }).printAll();
  }

  private static final Comparator<ListNode> minValueComparator = (o1, o2) -> o1.val - o2.val;

  /**
   * 4 ms	41.1 MB
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, minValueComparator);
    for (ListNode node : lists) {
      if (node != null) minHeap.add(node);
    }
    if (minHeap.isEmpty()) return null;

    ListNode head = minHeap.poll();
    if (head.next != null) minHeap.add(head.next);

    ListNode cur = head;
    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();
      if (node.next != null) minHeap.add(node.next);
      cur.next = node;
      cur = node;
    }

    return head;
  }
}