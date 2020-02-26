package com.htoyama.leetcode.utils

object Utils {

  fun reverse(value: Int): Long {
    var rest = value
    var sum: Long = 0 // might occur overflow
    while (rest != 0) {
      val next = rest % 10
      sum = sum * 10 + next
      rest /= 10
    }

    return sum
  }
}