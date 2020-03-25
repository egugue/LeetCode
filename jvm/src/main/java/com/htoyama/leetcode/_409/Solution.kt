package com.htoyama.leetcode._409

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    longestPalindrome("abccccdd") shouldEqual 7
    longestPalindrome("ccc") shouldEqual 3
    longestPalindrome("cc") shouldEqual 2
  }
}

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
class Solution {

  /**
   * 136 ms	32.5 MB
   */
  fun longestPalindrome(s: String): Int {
    if (s.length <= 1) return s.length

    // https://en.wikipedia.org/wiki/List_of_Unicode_characters#Basic_Latin
    val table = IntArray(26 * 2 + 6)
    for (char in s) {
      table[char - 'A']++
    }

    var evenCharCount = 0
    var hasOddChar = false
    table.forEach { count ->
      if (count % 2 != 0) {
        hasOddChar = true
      }
      evenCharCount += (count / 2) * 2
    }

    return evenCharCount + if (hasOddChar) 1 else 0
  }
}