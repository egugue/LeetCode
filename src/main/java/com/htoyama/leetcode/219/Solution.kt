package com.htoyama.leetcode.`219`

import com.htoyama.leetcode.utils.shouldEqual
import org.assertj.core.api.Assertions.assertThat

fun main() {
  Solution().apply {
    containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3) shouldEqual true
    containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1) shouldEqual true
    containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2) shouldEqual false
    containsNearbyDuplicate(intArrayOf(99, 99), 2) shouldEqual true
  }
}

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
class Solution {
  fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val set = HashSet<Int>()

    for (i in 0..nums.lastIndex) {
      if (i > k) set.remove(nums[i - k - 1])
      if (!set.add(nums[i])) {
        return true
      }
    }

    return false
  }
}