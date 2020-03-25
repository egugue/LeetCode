package com.htoyama.leetcode._062;

import com.htoyama.leetcode.utils.DynamicProgramming;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
@Level.Medium
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.uniquePaths(3, 2)).isEqualTo(3);
  }

  /**
   * 0 ms	36.4 MB
   */
  @DynamicProgramming
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int w = 0; w < m; w++) {
      dp[w][0] = 1;
    }
    for (int h = 0; h < n; h++) {
      dp[0][h] = 1;
    }

    for (int w = 1; w < m; w++) {
      for (int h = 1; h < n; h++) {
        dp[w][h] = dp[w][h - 1] + dp[w - 1][h];
      }
    }

    return dp[m - 1][n - 1];
  }
}
