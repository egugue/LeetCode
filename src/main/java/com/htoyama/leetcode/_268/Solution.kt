package com.htoyama.leetcode._268

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    missingNumber(intArrayOf(3, 0, 1)) shouldEqual 2
    missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)) shouldEqual 8

    missingNumber_approach3(intArrayOf(0, 1, 3, 4)) shouldEqual 2
    //missingNumber_approach3(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)) shouldEqual 8
  }
}

/**
 * https://leetcode.com/problems/missing-number/submissions/
 */
class Solution {

  /**
   * 208 ms	38.6 MB
   */
  fun missingNumber(nums: IntArray): Int {
    val flags = BooleanArray(nums.size + 1)

    for (num in nums) {
      flags[num] = true
    }

    return flags.indexOfFirst { !it }
  }

  /**
   * 204 ms	38.8 MB
   *
   * TODO: Must review later
   */
  fun missingNumber_approach3(nums: IntArray): Int {
    var missing = nums.size
    for (i in 0 until nums.size) {
      missing = missing xor (i xor nums[i])
    }
    return missing
  }

  /**
   * 228 ms	37.7 MB
   */
  fun missingNumber_approach4(nums: IntArray): Int {
    val expectedSum = nums.size * (1 + nums.size) / 2
    val actualSum = nums.sum()

    return expectedSum - actualSum
  }
}
