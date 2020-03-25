package com.htoyama.leetcode._344

import com.htoyama.leetcode.utils.shouldEqual

private fun c(vararg elements: Char) = charArrayOf(*elements)

fun main() {
  Solution().apply {
    c('h', 'e', 'l', 'l', 'o').apply { reverseString(this) } shouldEqual c('o', 'l', 'l', 'e', 'h')
    c('a', 'b', 'c', 'd').apply { reverseString(this) } shouldEqual c('d', 'c', 'b', 'a')
  }
}

class Solution {

  fun reverseString(s: CharArray): Unit {
    if (s.size <= 1) return

    var i = 0
    var j = s.lastIndex
    while (i < j) {
      val tmp = s[i]
      s[i] = s[j]
      s[j] = tmp
      i++
      j--
    }
  }
}
