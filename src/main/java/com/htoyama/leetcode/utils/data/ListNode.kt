package com.htoyama.leetcode.utils.data

class ListNode(var `val`: Int) {
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
    fun of(vararg values: Int): ListNode? {
      if (values.isEmpty()) return null

      val root = ListNode(values.first())
      var curr = root
      for (i in 1..values.lastIndex) {
        val node = ListNode(values[i])
        curr.next = node
        curr = node
      }

      return root
    }
  }
}

