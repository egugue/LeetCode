package com.htoyama.leetcode._160;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.LinkedList_;
import com.htoyama.leetcode.utils.data.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
@Level.Easy
@LinkedList_
public class Solution {

  /**
   * 441 ms	42.8 MB
   *
   * a too slow solution..
   * TODO: Try to reduce runtime later
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode curA = headA;
    ListNode curB = headB;
    do {
      if (curA == curB) return curA;
      curA = curA.next == null ? headA : curA.next;
      curB = curB.next == null ? headB : curB.next;
    } while(curA != headA || curB != headB);

    return null;
  }
}