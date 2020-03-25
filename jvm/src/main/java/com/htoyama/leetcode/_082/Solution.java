package com.htoyama.leetcode._082;

import com.htoyama.leetcode.utils.data.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    s.deleteDuplicates(ListNode.of("1->2->3->3->4->4->5")).printAll();
    s.deleteDuplicates(ListNode.of("1->1->2->3->3->4->4->5")).printAll();
  }

  /**
   * 0 ms	39 MB
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    ListNode curr = head;
    while (curr != null && curr.next != null) {
      if (curr.val != curr.next.val) {
        prev = curr;
        curr = curr.next;
        continue;
      }

      ListNode lastSameNode = curr.next;
      while (lastSameNode.next != null && lastSameNode.val == lastSameNode.next.val) {
        lastSameNode = lastSameNode.next;
      }
      prev.next = lastSameNode.next;
      curr = prev.next;
    }

    return dummyHead.next;
  }
}
