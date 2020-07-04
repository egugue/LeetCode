package com.htoyama.leetcode._227;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.calculate("3+2*2")).isEqualTo(7);
    assertThat(s.calculate(" 3/2 ")).isEqualTo(1);
    assertThat(s.calculate(" 3+5 / 2 ")).isEqualTo(5);
    assertThat(s.calculate(" 3+5 / 2 + 20 + 3")).isEqualTo(28);
    assertThat(s.calculate(" 1-1+1")).isEqualTo(1);
  }

  /**
   * 19 ms	43 MB
   */
  public int calculate(String s) {
    if (s.length() == 0) return 0;

    int i = 0;
    Stack<Integer> stack = new Stack<>();
    char operator = '+';

    while (i < s.length()) {
      while (i < s.length() && s.charAt(i) == ' ') i++;
      if (i >= s.length()) break;

      switch (s.charAt(i)) {
        case '+':
        case '-':
        case '*':
        case '/':
          operator = s.charAt(i);
          i++;
          break;
        default:
          int operand = 0;
          while(i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
            operand = operand * 10 + (s.charAt(i++) - '0');
          }

          if (operator == '+') {
            stack.push(operand);
          } else if (operator == '-') {
            stack.push(-operand);
          } else if (operator == '*') {
            stack.push(stack.pop() * operand);
          } else if (operator == '/') {
            stack.push(stack.pop() / operand);
          }
          break;
      }
    }

    int result = 0;
    for (int operand : stack) result += operand;
    return result;
  }
}