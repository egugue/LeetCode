package com.htoyama.leetcode.`021`

import com.htoyama.leetcode.utils.data.ListNode

fun main() {
  Solution().apply {
    mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4))?.printAll()
  }
}

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
class Solution {
  fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    var cl1: ListNode? = l1
    var cl2: ListNode? = l2
    var curr: ListNode? = null
    var head: ListNode? = null
    while (cl1 != null && cl2 != null) {
      val next = if (cl1.`val` <= cl2.`val`) {
        cl1.also { cl1 = it.next }
      } else {
        cl2.also { cl2 = it.next }
      }

      if (curr == null) {
        curr = next
        head = next
      } else {
        curr.next = next
        curr = next
      }
    }

    if (cl1 != null) {
      curr?.next = cl1
    } else if (cl2 != null) {
      curr?.next = cl2
    }

    return head
  }
}
