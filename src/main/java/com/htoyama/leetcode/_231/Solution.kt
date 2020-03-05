package com.htoyama.leetcode._231

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    isPowerOfTwo(1) shouldEqual true
    isPowerOfTwo(16) shouldEqual true
    isPowerOfTwo(218) shouldEqual false
    isPowerOfTwo(0) shouldEqual false
    isPowerOfTwo(-4) shouldEqual false
    isPowerOfTwo(-2147483648) shouldEqual false
  }
}

/**
 * https://leetcode.com/problems/power-of-two/
 */
class Solution {

  fun isPowerOfTwo(n: Int): Boolean {
    if (n <= 0) return false
    return Integer.highestOneBit(n) == n
  }
}