package com.htoyama.leetcode.`204`

fun main() {
  Solution().apply {
    println(countPrimes(10))
    println(countPrimes(3))
  }
}

/**
 * https://leetcode.com/problems/count-primes
 */
class Solution {
  // TODO: Have to Review later and implement more efficient
  fun countPrimes(n: Int): Int {
    if (n <= 2) return 0

    var sum = 1
    for (i in 3 until n step 2) {
      if (isPrime(i)) {
        //println(i)
        sum++
      }
    }

    return sum
  }

  private fun isPrime(num: Int): Boolean {
    if (num < 2) return false

    val sqrt = Math.sqrt(num.toDouble()).toInt()
    for (i in 2..sqrt) {
      if (num % i == 0) return false
    }

    return true
  }
}