package com.htoyama.leetcode._148;

import com.htoyama.leetcode.utils.data.ListNode;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode l;
    //l = ListNode.of(-1, 5, 3, 5, 0);
    l = ListNode.of(-1, 5, 3, 4);
    s.sortList(l).printAll();
  }

  /**
   * 3 ms	42.3 MB
   */
  public ListNode sortList(ListNode head) {
    return mergeSort(head);
  }

  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode leftEnd = null;
    ListNode rightStart = head;
    ListNode fast = head;
    while(fast != null && fast.next != null) {
      leftEnd = rightStart;
      rightStart = rightStart.next;
      fast = fast.next.next;
    }
    leftEnd.next = null;

    ListNode leftStart = mergeSort(head);
    rightStart = mergeSort(rightStart);

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