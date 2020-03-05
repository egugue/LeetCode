package com.htoyama.leetcode._009

fun main() {
  Solution().apply {
    println(isPalindrome(11))
    println(isPalindrome(121))
    println(isPalindrome(-121))
    println(isPalindrome(10))
  }
}

class Solution {

  /**
   * https://leetcode.com/problems/palindrome-number/
   */
  fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    if (x == 0) return true

    var rest = x
    var sum: Long = 0 // might occur overflow
    while (rest != 0) {
      val value = rest % 10
      sum = sum * 10 + value
      rest /= 10
    }

    return sum == x.toLong()
  }
}