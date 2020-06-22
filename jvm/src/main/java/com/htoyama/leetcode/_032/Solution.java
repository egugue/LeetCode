package com.htoyama.leetcode._032;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
//    assertThat(s.longestValidParentheses("(()")).isEqualTo(2);
    assertThat(s.longestValidParentheses(")()())")).isEqualTo(4);
    assertThat(s.longestValidParentheses("())")).isEqualTo(4);
  }

  /**
   * 1 ms	39.4 MB
   */
  public int longestValidParentheses(String s) {
    if (s.length() <= 1) return 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        continue;
      }

      if (s.charAt(i - 1) == '(') {
        dp[i] = (i < 2 ? 0 : dp[i - 2]) + 2;
        continue;
      }
      int prevParenthesis = i - 1 - dp[i - 1];
      if (prevParenthesis >= 0 && s.charAt(prevParenthesis) == '(') {
        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
      }
    }

    int max = 0;
    for (int value : dp) {
      max = Math.max(max, value);
    }
    return max;
  }
}