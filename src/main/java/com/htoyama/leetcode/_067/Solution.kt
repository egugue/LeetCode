package com.htoyama.leetcode._067

import java.lang.StringBuilder

fun main() {
  Solution().apply {
    println(addBinary("11", "1"))
    println(addBinary("1010", "1011"))
    println(
      addBinary(
        "10100",
        "1011"
      )
    )
  }
}

/**
 * https://leetcode.com/problems/add-binary/
 */
class Solution {

  fun addBinary(a: String, b: String): String {
    val sb = StringBuilder()
    var aIndex = a.lastIndex
    var bIndex = b.lastIndex
    var curry = 0
    while (aIndex >= 0 || bIndex >= 0) {
      var sum = curry
      sum += if (aIndex >= 0) a[aIndex] - '0' else 0
      sum += if (bIndex >= 0) b[bIndex] - '0' else 0
      sb.insert(0, sum % 2)

      curry = sum / 2
      aIndex--
      bIndex--
    }

    if (curry == 1) {
      sb.insert(0, curry)
    }

    return sb.toString()
  }
}