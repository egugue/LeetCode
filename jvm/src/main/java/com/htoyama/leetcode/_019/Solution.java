package com.htoyama.leetcode._019;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.LinkedList_;
import com.htoyama.leetcode.utils.data.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
@Level.Medium
@LinkedList_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.removeNthFromEnd(ListNode.of("1"), 1));

    s.removeNthFromEnd(ListNode.of("1->2"), 1).printAll();
    s.removeNthFromEnd(ListNode.of("1->2"), 2).printAll();

    s.removeNthFromEnd(ListNode.of("1->2->3->4->5"), 1).printAll();
    s.removeNthFromEnd(ListNode.of("1->2->3->4->5"), 2).printAll();
    s.removeNthFromEnd(ListNode.of("1->2->3->4->5"), 5).printAll();
  }

  /**
   * 0 ms	37.8 MB
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;

    ListNode cur = head;
    while (n-- > 0 && cur != null) {
      cur = cur.next;
    }
    if (cur == null) return head.next;

    cur = cur.next;
    ListNode beforeN_th = head;
    while (cur != null && beforeN_th != null) {
      cur = cur.next;
      beforeN_th = beforeN_th.next;
    }

    if (beforeN_th != null && beforeN_th.next != null) {
      beforeN_th.next = beforeN_th.next.next;
    }

    return head;
  }
}