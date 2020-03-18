package com.htoyama.leetcode._063;

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
    int r;
    r = s.uniquePathsWithObstacles(new int[][]{
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}
    });
    assertThat(r).isEqualTo(2);

    r = s.uniquePathsWithObstacles(new int[][]{
      {0, 1, 0},
      {0, 0, 0},
      {0, 0, 0}
    });
    assertThat(r).isEqualTo(3);

    r = s.uniquePathsWithObstacles(new int[][]{
      {0},
    });
    assertThat(r).isEqualTo(1);
  }

  /**
   * 0 ms	38 MB
   */
  @DynamicProgramming
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length == 0) return 0;
    if (obstacleGrid[0][0] == 1) return 0;

    int height = obstacleGrid.length;
    int width = obstacleGrid[0].length;
    int[][] dp = new int[height][width];
    dp[0][0] = 1;
    for (int h = 1; h < height; h++) {
      dp[h][0] = obstacleGrid[h][0] == 0 && dp[h - 1][0] != 0 ? 1 : 0;
    }
    for (int w = 1; w < width; w++) {
      dp[0][w] = obstacleGrid[0][w] == 0 && dp[0][w - 1] != 0 ? 1 : 0;
    }

    for (int h = 1; h < height; h++) {
      for (int w = 1; w < width; w++) {
        dp[h][w] = obstacleGrid[h][w] == 0
          ? dp[h][w - 1] + dp[h - 1][w]
          : 0;
      }
    }

    return dp[height - 1][width - 1];
  }
}
