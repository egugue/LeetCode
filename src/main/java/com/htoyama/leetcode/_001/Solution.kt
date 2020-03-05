package com.htoyama.leetcode._001

class Solution {
  /**
   * https://leetcode.com/problems/two-sum
   */
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { index, value ->
      if (map.contains(target - value)) {
        return intArrayOf(map.getValue(target - value), index)
      }
      map[value] = index
    }
    return intArrayOf()
  }
}