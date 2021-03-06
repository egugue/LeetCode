package com.htoyama.leetcode.utils.data

class ListNode(@JvmField var `val`: Int) {
  @JvmField
  var next: ListNode? = null

  val tail: ListNode
    get() {
      var t = this
      while (true) {
        t.next?.let { t = it } ?: return t
      }
    }

  override fun toString(): String {
    val sb = StringBuilder()
    var curr: ListNode? = this
    while (curr != null) {
      sb.append(curr.`val`)
        .append("->")
      curr = curr.next
    }
    sb.setLength(sb.length - 2)
    return sb.toString()
  }

  fun printAll() {
    var curr: ListNode? = this
    while (curr != null) {
      print("${curr.`val`} -> ")
      curr = curr.next
    }
    println()
  }

  companion object {

    /**
     * 1->2->3->3->4->4->5
     */
    @JvmStatic
    fun of(str: String): ListNode {
      val sp = str.split("->").map { it.toInt() }

      return if (sp.size == 1) {
        ListNode(sp.first())
      } else {
        of(sp.first(), *sp.takeLast(sp.lastIndex).toIntArray())
      }
    }

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

