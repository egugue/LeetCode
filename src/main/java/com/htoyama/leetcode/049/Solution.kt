package com.htoyama.leetcode.`049`

fun main() {
  Solution().apply {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
  }
}

class Solution {
  fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, ArrayList<String>>()
    strs.forEach { str ->
      val charArr = str.toCharArray()
      charArr.sort()
      val sorted = String(charArr)

      map[sorted] = map.getOrDefault(sorted, arrayListOf()).apply {
        add(str)
      }
    }

    return map.values.map { it.toList() }
  }
}
