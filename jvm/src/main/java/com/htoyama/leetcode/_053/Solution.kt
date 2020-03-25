package com.htoyama.leetcode._053

fun main() {
  Solution().apply {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(-2, 4, 1, -9, 3, 1)))
    println(maxSubArray(intArrayOf(-2, -4, -10, -9, -3, -9)))
  }
}

class Solution {
  fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var j = 0
    var max = Int.MIN_VALUE
    var curr = 0
    while (j < nums.size) {
      curr += nums[j]
      max = Math.max(max, curr)
      j++

      if (curr < 0) curr = 0
    }

    return max
  }
}