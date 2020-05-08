package com.htoyama.leetcode._148;

import com.htoyama.leetcode.utils.data.ListNode;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode l;
    l = ListNode.of(-1, 5, 3, 5, 0);
    //l = ListNode.of(-1, 5, 3);
    s.sortList(l).printAll();
  }

  /**
   * 3 ms	42.3 MB
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    int length = 0;
    ListNode cur = head;
    while (cur != null) {
      length++;
      cur = cur.next;
    }

    return mergeSort(head, length);
  }

  public ListNode mergeSort(ListNode head, int length) {
    assert head != null;
    if (head.next == null || length == 1) {
      head.next = null;
      return head;
    }

    ListNode leftStart = head;
    ListNode leftEnd = leftStart;
    int mid = length / 2;
    for (int i = 1; i < mid; i++) {
      leftEnd = leftEnd.next;
    }
    ListNode rightStart = leftEnd.next;
    leftEnd.next = null;

    leftStart = mergeSort(leftStart, length / 2);
    rightStart = mergeSort(rightStart, length - mid);

    return merge(leftStart, rightStart);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode newHead;
    if (left.val <= right.val) {
      newHead = left;
      left = left.next;
    } else {
      newHead = right;
      right = right.next;
    }

    ListNode cur = newHead;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }

    ListNode rest = left != null ? left : right;
    while (rest != null) {
      cur.next = rest;
      rest = rest.next;
      cur = cur.next;
    }

    return newHead;
  }
}