package com.htoyama.leetcode._142;

import com.htoyama.leetcode.utils.data.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head;

    head = ListNode.of(1, 2, 3, 4, 5);
    head.getTail().next = head.next;
    assertThat(s.detectCycle(head)).isEqualTo(head.next);

    head = ListNode.of(1, 2);
    head.next = head;
    assertThat(s.detectCycle(head)).isEqualTo(head);

    head = ListNode.of(1);
    assertThat(s.detectCycle(head)).isNull();
  }

  /**
   * 0 ms	39.6 MB
   */
  public ListNode detectCycle(ListNode head) {
    ListNode collision = findCollisionNode(head);
    if (collision == null) return null;

    ListNode start = head;
    while(start != collision) {
      start = start.next;
      collision = collision.next;
    }
    return start;
  }

  private ListNode findCollisionNode(ListNode head) {
    if (head== null || head.next == null) return null;

    ListNode slow = head.next;
    ListNode fast = head.next.next;
    while (slow != null && fast != null) {
      if (slow == fast) return slow;
      if (fast.next == null) return null;

      slow = slow.next;
      fast = fast.next.next;
    }
    return null;
  }
}