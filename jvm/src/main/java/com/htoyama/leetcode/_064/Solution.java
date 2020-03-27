package com.htoyama.leetcode._064;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.DynamicProgramming;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int m;

    m = s.minPathSum(new int[][]{ });
    assertThat(m).isEqualTo(0);

    m = s.minPathSum(new int[][]{
      {1, 3, 1},
    });
    assertThat(m).isEqualTo(5);

    m = s.minPathSum(new int[][]{
      {1, 3, 1},
      {2, 2, 2},
    });
    assertThat(m).isEqualTo(7);

    m = s.minPathSum(new int[][]{
      {1, 3, 1},
      {1, 5, 1},
      {4, 2, 1}
    });
    assertThat(m).isEqualTo(7);
  }

  /**
   * 2 ms	42.4 MB
   */
  @DynamicProgramming
  public int minPathSum(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;

    for (int i = 1; i < grid.length; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for (int i = 1; i < grid[0].length; i++) {
      grid[0][i] += grid[0][i - 1];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
      }
    }

    return grid[grid.length - 1][grid[0].length - 1];
  }
}