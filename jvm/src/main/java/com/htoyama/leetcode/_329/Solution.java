package com.htoyama.leetcode._329;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.longestIncreasingPath(new int[][]{
      new int[]{9, 9, 4},
      new int[]{6, 6, 8},
      new int[]{2, 1, 1},
    })).isEqualTo(4);

    assertThat(s.longestIncreasingPath(new int[][]{
      new int[]{3, 4, 5},
      new int[]{3, 2, 6},
      new int[]{2, 2, 1},
    })).isEqualTo(4);
  }

  /**
   * 10 ms	52.5 MB
   */
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return 0;
    int[][] dp = new int[matrix.length][matrix[0].length];

    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (dp[i][j] == 0) traverse(matrix, i, j, dp);
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }

  private static void traverse(int[][] matrix, int i, int j, int[][] dp) {
    if (dp[i][j] != 0) return;

    int value = matrix[i][j];
    int maxPath = 0;

    if (i >= 1 && value < matrix[i - 1][j]) {
      if (dp[i - 1][j] == 0) traverse(matrix, i - 1, j, dp);
      maxPath = Math.max(maxPath, dp[i - 1][j]);
    }

    if (i <= matrix.length - 2 && value < matrix[i + 1][j]) {
      if (dp[i + 1][j] == 0) traverse(matrix, i + 1, j, dp);
      maxPath = Math.max(maxPath, dp[i + 1][j]);
    }

    if (j >= 1 && value < matrix[i][j - 1]) {
      if (dp[i][j - 1] == 0) traverse(matrix, i, j - 1, dp);
      maxPath = Math.max(maxPath, dp[i][j - 1]);
    }

    if (j <= matrix[0].length - 2 && value < matrix[i][j + 1]) {
      if (dp[i][j + 1] == 0) traverse(matrix, i, j + 1, dp);
      maxPath = Math.max(maxPath, dp[i][j + 1]);
    }

    dp[i][j] = maxPath + 1;
  }
}