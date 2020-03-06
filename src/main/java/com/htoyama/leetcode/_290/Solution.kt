package com.htoyama.leetcode._290

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    wordPattern("abba", "dog cat cat dog") shouldEqual true
    wordPattern("abba", "dog cat cat fish") shouldEqual false
    wordPattern("aaaa", "dog cat cat dog") shouldEqual false
    wordPattern("aaaa", "dog dog dog dog") shouldEqual true
    wordPattern("abba", "dog dog dog dog") shouldEqual false
  }
}

/**
 * https://leetcode.com/problems/word-pattern/
 */
class Solution {

  /**
   * TODO: Must review later to check if containsValue can be removed
   */
  fun wordPattern(pattern: String, str: String): Boolean {
    val split = str.split(" ")
    if (split.size != pattern.length) return false

    val map = HashMap<Char, String>()
    split.forEachIndexed { index, word ->
      val char = pattern[index]
      val stored = map[char]
      if (stored == null) {
        if (map.containsValue(word)) return false
        map[char] = word
      } else {
        if (word != stored) return false
      }
    }

    return true
  }
}
