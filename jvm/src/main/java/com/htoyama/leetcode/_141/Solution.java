package com.htoyama.leetcode._141;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.LinkedList_;
import com.htoyama.leetcode.utils.data.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
@Level.Easy
@LinkedList_
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head;

    head = ListNode.of(3, 2, 0, -4);
    head.getTail().next = head.next;
    assertThat(s.hasCycle(head)).isTrue();

    head = ListNode.of(1, 2);
    head.next = head;
    assertThat(s.hasCycle(head)).isTrue();

    head = ListNode.of(1);
    assertThat(s.hasCycle(head)).isFalse();
  }

  /**
   * 0 ms	39.8 MB
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head.next;
    ListNode fast = head.next.next;

    while (slow != null && fast != null) {
      if (slow.val == fast.val) return true;
      if (fast.next == null) return false;
      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }
}