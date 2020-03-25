package com.htoyama.leetcode._083;

import com.htoyama.leetcode.utils.data.ListNode;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    s.deleteDuplicates(ListNode.of(1)).printAll();
    s.deleteDuplicates(ListNode.of(1, 1)).printAll();
    s.deleteDuplicates(ListNode.of(1, 1, 1)).printAll();

    s.deleteDuplicates(ListNode.of(1, 2)).printAll();
    s.deleteDuplicates(ListNode.of(1, 1, 2)).printAll();
    s.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3)).printAll();
    s.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3, 4)).printAll();
    s.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3, 4)).printAll();
    s.deleteDuplicates(ListNode.of(1, 2, 3, 4, 5, 6)).printAll();
  }

  /**
   * Note: the given list node is sorted.
   *
   * 0 ms	40.8 MB
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;

    ListNode curr = head;
    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }

    return head;
  }
}
