package com.htoyama.leetcode._150;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.evalRPN(new String[]{
      "2", "1", "+", "3", "*"
    })).isEqualTo(9);

    assertThat(s.evalRPN(new String[]{
      "4", "13", "5", "/", "+"
    })).isEqualTo(6);

    assertThat(s.evalRPN(new String[]{
      "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
    })).isEqualTo(22);
  }

  /**
   * 8 ms	41.6 MB
   */
  public int evalRPN(String[] tokens) {
    if (tokens.length == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      switch (token) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          continue;
        case "-":
          int right = stack.pop();
          int left = stack.pop();
          stack.push(left - right);
          continue;
        case "*":
          stack.push(stack.pop() * stack.pop());
          continue;
        case "/":
          right = stack.pop();
          left = stack.pop();
          stack.push(left / right);
          continue;
        default:
          stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }
}