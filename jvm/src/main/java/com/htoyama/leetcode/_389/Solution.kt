package com.htoyama.leetcode._389

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    findTheDifference("abcd", "abcde") shouldEqual 'e'
    findTheDifference("abcd", "abcdd") shouldEqual 'd'

    findTheDifference2("abcd", "abcde") shouldEqual 'e'
    findTheDifference2("abcd", "abcdd") shouldEqual 'd'

    findTheDifference_Discuss1("abcd", "abcde") shouldEqual 'e'
    findTheDifference_Discuss1("abcd", "abcdd") shouldEqual 'd'
  }
}

class Solution {

  /**
   * Case of Using hash table
   *
   * 172 ms	33.7 MB
   */
  fun findTheDifference(s: String, t: String): Char {
    val table = IntArray(26)
    for (c in s) {
      table[c - 'a']++
    }
    for (c in t) {
      if (table[c - 'a']-- == 0) {
        return c
      }
    }

    throw IllegalArgumentException()
  }

  /**
   * Case of applying sort
   *
   * 184 ms	36.2 MB
   */
  fun findTheDifference2(s: String, t: String): Char {
    val sChars = s.toCharArray()
    sChars.sort()
    val tChars = t.toCharArray()
    tChars.sort()

    for (i in 0..sChars.lastIndex) {
      val tChar = tChars[i]
      if (sChars[i] != tChar) {
        return tChar
      }
    }

    return tChars.last()
  }

  /**
   * TODO: Must review later
   *
   * 168 ms	33.9 MB	kotlin
   */
  fun findTheDifference_Discuss1(s: String, t: String): Char {
    var charCode = t.last().toInt()
    for (i in 0..s.lastIndex) {
      charCode -= s[i].toInt()
      charCode += t[i].toInt()
    }
    return charCode.toChar()
  }
}