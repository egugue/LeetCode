package com.htoyama.leetcode._003

fun main() {
  Solution().apply {
    //println(lengthOfLongestSubstring("abcabcbb"))
    //println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
  }
}

class Solution {
  /**
   * https://leetcode.com/problems/longest-substring-without-repeating-characters/
   */
  /*
     a b c a b c b b
     a
     a b
     a b c
     a b c a x
       b c a
       b c a b x
       ...
   */
  fun lengthOfLongestSubstring(s: String): Int {
    var i = 0
    var j = 0
    var max = 0
    val stored = HashSet<Char>()

    val length = s.length
    while (j < length) {
      val char = s[j]
      if (char in stored) {
        stored.remove(s[i])
        i++
        continue
      }

      stored.add(char)
      max = Math.max(max, stored.size)
      j++
    }

    return max
  }
}