package com.htoyama.leetcode.utils.data

class ListNode(@JvmField var `val`: Int) {
  @JvmField
  var next: ListNode? = null

  fun printAll() {
    var curr: ListNode? = this
    while(curr != null) {
      print("${curr.`val`} -> ")
      curr = curr.next
    }
    println()
  }

  companion object {
    @JvmStatic
    fun of(first: Int, vararg others: Int): ListNode {
      val root = ListNode(first)
      var curr = root
      for (value in others) {
        val node = ListNode(value)
        curr.next = node
        curr = node
      }

      return root
    }
  }
}

