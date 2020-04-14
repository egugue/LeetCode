package com.htoyama.leetcode._142;

import com.htoyama.leetcode.utils.data.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head;

    head = ListNode.of(1, 2, 3, 4);
    head.getTail().next = head.next;
    assertThat(s.detectCycle(head)).isEqualTo(head.next);

    head = ListNode.of(1, 2);
    head.next = head;
    assertThat(s.detectCycle(head)).isEqualTo(head);

    head = ListNode.of(1);
    assertThat(s.detectCycle(head)).isNull();
  }

  /**
   * 0 ms	39.5 MB
   */
  public ListNode detectCycle(ListNode head) {
    ListNode collision = findCollisionNode(head);
    if (collision == null) return null;

    ListNode fromHead = head;
    ListNode fromCollision = collision;
    int count = 0;
    while (fromHead != fromCollision) {
      if (fromHead == collision) {
        fromHead = head;

        fromCollision = collision;
        count++;
        for (int i = 0; i < count; i++) fromCollision = fromCollision.next;
      } else {
        fromHead = fromHead.next;
        fromCollision = fromCollision.next;
      }
    }

    return fromHead;
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