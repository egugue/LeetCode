package com.htoyama.leetcode._328;

import com.htoyama.leetcode.utils.data.ListNode;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.oddEvenList(ListNode.of("2->1->3->5->6->4")));
  }

  /**
   * 0 ms	39 MB
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode prevOdd = head;
    ListNode prevEven = head.next;
    ListNode odd = head.next.next;
    while (odd != null) {
      ListNode even = odd.next;

      odd.next = prevOdd.next;
      prevOdd.next = odd;
      prevEven.next = even;

      prevOdd = odd;
      prevEven = even;
      if (even == null) return head;
      odd = even.next;
    }

    return head;
  }
}