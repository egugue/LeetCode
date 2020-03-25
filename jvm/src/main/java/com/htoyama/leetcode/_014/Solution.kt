package com.htoyama.leetcode._014

fun main() {
  Solution().apply {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(longestCommonPrefix(arrayOf("babb", "caa")))
    println(longestCommonPrefix(arrayOf("abca", "abc")))
  }

  println("-----")

  Approach2().apply {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(longestCommonPrefix(arrayOf("babb", "caa")))
    println(longestCommonPrefix(arrayOf("abca", "abc")))
  }
}

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {
  /*
    "flower" "flow" "flight"
  j  --
  1 - f f f
  2 - l l l
  3 - o o i x
   */
  /**
   * 188 ms	37 MB
   */
  fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    val sb = StringBuilder()
    var j = 0
    while (true) {
      val match = isSameChar(strs, j)
      if (match) {
        sb.append(strs[0][j])
      } else {
        break
      }
      j++
    }

    return sb.toString()
  }

  private fun isSameChar(strs: Array<String>, j: Int): Boolean {
    val char: Char = strs[0].getOrNull(j) ?: return false

    for (i in 1..strs.lastIndex) {
      if (char != strs[i].getOrNull(j)) {
        return false
      }
    }

    return true
  }
}

class Approach2 {

  /**
   * 208 ms	37.2 MB
   */
  fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    for (j in 0..strs[0].lastIndex) {
      val char = strs[0][j]
      for (i in 1..strs.lastIndex) {
        if (char != strs[i].getOrNull(j)) {
          return strs[0].substring(0, j)
        }
      }
    }

    return strs[0]
  }
}