package com.htoyama.leetcode._279;

import com.htoyama.leetcode.utils.DynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.numSquares(12)).isEqualTo(3);
    assertThat(s.numSquares(13)).isEqualTo(2);
  }

  /**
   * 32 ms	39 MB
   */
  @DynamicProgramming
  public int numSquares(int n) {
    if (n <= 3) return n;

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    return dp[n];
  }
}