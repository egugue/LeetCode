package com.htoyama.leetcode._204

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
    return hashmap(n)
    // if (n <= 2) return 0
    //
    // var sum = 1
    // for (i in 3 until n step 2) {
    //   if (isPrime(i)) {
    //     //println(i)
    //     sum++
    //   }
    // }
    //
    // return sum
  }

  /**
   * 212 ms	36.7 MB
   */
  private fun hashmap(nums: Int): Int{
    if (nums <= 2) return 0;

    val isNotPrimes = BooleanArray(nums)
    var count = 0
    for (i in 2 until nums) {
      if (isNotPrimes[i]) continue

      count++
      for (j in i * 2 until nums step i) {
        isNotPrimes[j] = true
      }
    }
    return count
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