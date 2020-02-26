package com.htoyama.leetcode.`020`

import java.util.Stack

fun main() {
  Solution().apply {
    println(isValid("()"))
    println(isValid("()[]{}"))

    println(isValid("(]"))
    println(isValid("([)]"))

    println(isValid("{[]}"))
  }
}

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
class Solution {

  fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    s.forEach {
      when (it) {
        '(', '{', '[' -> stack.push(it)
        ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
        '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
        ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
      }
    }

    return stack.isEmpty()
  }
}
