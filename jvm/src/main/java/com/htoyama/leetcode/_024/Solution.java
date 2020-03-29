package com.htoyama.leetcode._024;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.LinkedList_;
import com.htoyama.leetcode.utils.data.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
@Level.Medium
@LinkedList_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.swapPairs(ListNode.of("1")).printAll();
    s.swapPairs(ListNode.of("1->2")).printAll();
    s.swapPairs(ListNode.of("1->2->3")).printAll();
    s.swapPairs(ListNode.of("1->2->3->4")).printAll();
    s.swapPairs(ListNode.of("1->2->3->4->5")).printAll();
  }

  /**
   * 0 ms	37 MB
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prevTail = dummy;
    ListNode first = prevTail.next;
    while(first != null && first.next != null) {
      prevTail.next = swap(first, first.next);
      prevTail = first;
      first = first.next;
    }

    return dummy.next;
  }

  private ListNode swap(ListNode first, ListNode second) {
    first.next = second.next;
    second.next = first;
    return second;
  }
}