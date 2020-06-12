package com.htoyama.leetcode._096;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.numTrees(3)).isEqualTo(5);
  }

  /**
   * 0 ms	36.1 MB
   */
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int range = 2; range <= n; range++) {
      for (int root = 1; root <= range; root++) {
        // dp[0 ~ range] = dp[left range] + dp[right range]
        dp[range] += dp[root - 1] * dp[range - root];
      }
    }

    return dp[n];
  }
}