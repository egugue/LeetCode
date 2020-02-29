package com.htoyama.leetcode.`028`

fun main() {
  Solution().apply {
    //println(strStr("heloo", "ll"))
    println(strStr("bbbb", "bba"))
  }
}

/**
 * https://leetcode.com/problems/implement-strstr/
 */
class Solution {
  fun strStr(haystack: String, needle: String): Int {
    if (haystack.isEmpty() && needle.isEmpty()) return 0
    if (haystack.isEmpty()) return -1
    if (needle.isEmpty()) return 0

    val nFirst = needle.first()
    val nLength = needle.length
    val end = haystack.length - nLength
    for (i in 0..end) {
      val char = haystack[i]
      if (char == nFirst && haystack.substring(i, i + nLength) == needle) {
        return i
      }
    }

    return -1
  }
}