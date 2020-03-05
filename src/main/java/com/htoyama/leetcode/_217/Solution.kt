package com.htoyama.leetcode._217

fun main() {
  Solution().apply {
    println(containsDuplicate(intArrayOf()))
    println(containsDuplicate(intArrayOf(1,2,3,1)))
    println(containsDuplicate(intArrayOf(1,2,3,4)))
    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
  }
}

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
class Solution {
  fun containsDuplicate(nums: IntArray): Boolean {
    val set = HashSet<Int>()

    for (num in nums) {
      if (num in set) {
        return true
      }

      set.add(num)
    }

    return false
  }
}