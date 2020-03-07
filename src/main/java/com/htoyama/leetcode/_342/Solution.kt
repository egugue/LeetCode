package com.htoyama.leetcode._342

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    isPowerOfFour(Int.MIN_VALUE) shouldEqual false
    isPowerOfFour(-1) shouldEqual false

    isPowerOfFour(0) shouldEqual false
    isPowerOfFour(1) shouldEqual true
    isPowerOfFour(2) shouldEqual false
    isPowerOfFour(3) shouldEqual false

    isPowerOfFour(4) shouldEqual true

    isPowerOfFour(15) shouldEqual false
    isPowerOfFour(16) shouldEqual true
    isPowerOfFour(17) shouldEqual false

    isPowerOfFour(Int.MAX_VALUE) shouldEqual false
  }
}

/**
 * https://leetcode.com/problems/power-of-four/
 */
class Solution {
  /*
       000000001 - 2
       000000010 - 4
       000000100 - 8
       000001000 - 8
   */
  /**
   * 136 ms	31.7 MB
   */
  fun isPowerOfFour(num: Int): Boolean {
    if (num <= 0) return false
    if (num == 1) return true

    return Integer.bitCount(num) == 1
      && (Integer.numberOfTrailingZeros(num) % 2) == 0
  }

  /**
   * Tried to solve the problem like toHex approach.
   *
   * 128 ms	32 MB
   *
   * @see com.htoyama.leetcode._405.Solution
   */
  fun isPowerOfFour_likeToHex(num: Int): Boolean {
    var curr = num

    while(curr != 0) {
      if (curr == 1) return true
      if (curr and 3 != 0) return false
      curr = curr ushr 2
    }

    return false
  }
}