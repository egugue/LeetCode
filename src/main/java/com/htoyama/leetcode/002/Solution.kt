package com.htoyama.leetcode.`002`

import com.htoyama.leetcode.utils.data.ListNode
import kotlin.math.pow

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun main() {
  Solution().apply {
    addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4))?.printAll()
    addTwoNumbers(ListNode.of(5), ListNode.of(5))?.printAll()
  }
}

class Solution {

  /**
   * https://leetcode.com/problems/add-two-numbers/
   */
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var curry = 0
    var cur1 = l1
    var cur2 = l2
    var root: ListNode? = null
    var currNode: ListNode? = null

    while (cur1 != null || cur2 != null) {
      val value1 = cur1?.`val` ?: 0
      val value2 = cur2?.`val` ?: 0

      val interSum = value1 + value2 + curry
      val value = (interSum % 10)
      curry = interSum / 10

      val node = ListNode(value)
      if (root == null) root = node
      currNode?.next = node

      currNode = node
      cur1 = cur1?.next
      cur2 = cur2?.next
    }

    if (curry != 0) {
      currNode?.next = ListNode(curry)
    }

    return root
  }
}
