package com.htoyama.leetcode._258

import com.htoyama.leetcode.utils.shouldEqual

fun main() {
  Solution().apply {
    addDigits(38) shouldEqual 2
    addDigits(9349) shouldEqual 7

    addDigits(0) shouldEqual 0
    addDigits(9) shouldEqual 9
    addDigits(10) shouldEqual 1
  }
}

/**
 * https://leetcode.com/problems/add-digits/
 */
class Solution {

  /*
    Input: 38
    Output: 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                 Since 2 has only one digit, return it.
   */
  fun addDigits(num: Int): Int {
    var digitsSum = num

    while(digitsSum > 9) {
      var curr = digitsSum
      digitsSum = 0
      while(curr != 0) {
        digitsSum += curr % 10
        //print("${curr % 10} + ")
        curr /= 10
      }
      //println("= $digitsSum")
    }

    return digitsSum
  }
}
