package com.htoyama.leetcode._206;


import com.htoyama.leetcode.utils.data.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    s.reverseList(ListNode.of("1->2")).printAll();
    s.reverseList(ListNode.of("1->2->3->4->5")).printAll();
  }

  /**
   * 0 ms	38.3 MB
   */
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
    }

    return prev;
  }
}
