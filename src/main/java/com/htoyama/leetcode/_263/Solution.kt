package com.htoyama.leetcode._263

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    (1..6).forEach {
      print("$it: ")
      isUgly2(it) shouldEqual true
    }
    isUgly2(7) shouldEqual false
    isUgly2(8) shouldEqual true
    isUgly2(9) shouldEqual true

    isUgly2(14) shouldEqual false
  }
}

/**
 * https://leetcode.com/problems/ugly-number/
 */
class Solution {

  /**
   * 144 ms	31.8 MB
   */
  fun isUgly(num: Int): Boolean {
    if (num <= 0) return false // Input is within the 32-bit signed integer
    if (num == 1) return true // 1 is typically treated as an ugly number.

    var curr = num
    while(curr > 2) {
      curr /= when {
        curr % 2 == 0 -> 2
        curr % 3 == 0 -> 3
        curr % 5 == 0 -> 5
        else -> return false
      }
    }

    return true
  }

  /**
   * https://leetcode.com/problems/ugly-number/discuss/69225/My-2ms-java-solution
   *
   * 148 ms	31.9 MB	kotlin
   */
  fun isUgly2(num: Int): Boolean {
    if (num <= 0) return false // Input is within the 32-bit signed integer
    if (num == 1) return true // 1 is typically treated as an ugly number.

    var curr = num
    while(curr % 2 ==0) curr /= 2
    while(curr % 3 ==0) curr /= 3
    while(curr % 5 ==0) curr /= 5
    return curr == 1
  }
}