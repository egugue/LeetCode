package com.htoyama.leetcode._007

fun main() {
  Solution().apply {
    //println(reverse(123))
    //println(reverse(-123))
    println(reverse(1534236469))
  }
}

class Solution {

  fun reverse(x: Int): Int {
    var sum: Long = 0
    var rest = x

    while (rest != 0) {
      val value = rest % 10
      sum = value + sum * 10
      if (sum !in Int.MIN_VALUE..Int.MAX_VALUE) {
        return 0
      }
      rest /= 10
    }

    return sum.toInt()
  }
}