package com.htoyama.leetcode._283

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    intArrayOf().apply { moveZeroesImproved(this) } shouldEqual intArrayOf()
    intArrayOf(0, 0, 0, 0).apply { moveZeroesImproved(this) } shouldEqual intArrayOf(0, 0, 0, 0)
    intArrayOf(0, 1, 0, 3, 12).apply { moveZeroesImproved(this) } shouldEqual intArrayOf(1, 3, 12, 0, 0)
    intArrayOf(0, 0, 0, 3, 12).apply { moveZeroesImproved(this) } shouldEqual intArrayOf(3, 12, 0, 0, 0)
  }
}

/**
 * https://leetcode.com/problems/move-zeroes/
 */
class Solution {

  /**
   * 212 ms	37.2 MB
   *
   * TODO: Needs to run more faster
   */
  fun moveZeroes(nums: IntArray): Unit {
    var zeroCount = 0
    for (i in 0..nums.lastIndex) {
      val num = nums[i]
      if (num == 0) {
        zeroCount++
      } else {
        nums[i - zeroCount] = num
      }
    }

    val last = nums.lastIndex
    for (i in last - zeroCount + 1..last) {
      nums[i] = 0
    }
  }

  /**
   * 200 ms	38 MB
   *
   * https://leetcode.com/problems/move-zeroes/discuss/72011/Simple-O(N)-Java-Solution-Using-Insert-Index
   */
  fun moveZeroesImproved(nums: IntArray) {
    var nextInsertPos = 0
    for (num in nums) {
      if (num != 0) nums[nextInsertPos++] = num
    }

    while(nextInsertPos < nums.size) {
      nums[nextInsertPos++] = 0
    }
  }
}
