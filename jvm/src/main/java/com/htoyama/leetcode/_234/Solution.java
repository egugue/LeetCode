package com.htoyama.leetcode._234;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.LinkedList_;
import com.htoyama.leetcode.utils.data.ListNode;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
@Level.Easy
@LinkedList_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isPalindrome(null)).isTrue();
    assertThat(s.isPalindrome(ListNode.of("1"))).isTrue();
    assertThat(s.isPalindrome(ListNode.of("1->2"))).isFalse();
    assertThat(s.isPalindrome(ListNode.of("1->2->2->1"))).isTrue();
    assertThat(s.isPalindrome(ListNode.of("1->2->3->2->1"))).isTrue();
  }

  /**
   * 1 ms	41.9 MB
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;

    int length = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      length++;
    }

    int mid = (length + 2 - 1) / 2;
    cur = head;
    while (cur != null && mid-- != 0) cur = cur.next;

    head = reverse(head, length / 2);

    while (head != null && cur != null) {
      if (head.val != cur.val) return false;
      head = head.next;
      cur = cur.next;
    }

    return head == null && cur == null;
  }

  private ListNode reverse(ListNode head, int to) {
    ListNode prev = null;
    ListNode curr = head;
    int count = 1;

    while (count <= to && curr != null) {
      ListNode tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
      count++;
    }

    return prev;
  }
}