package com.htoyama.leetcode._200;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int lands;
    lands = s.numIslands(new char[][]{
      new char[]{'1', '1', '1', '1', '0'},
      new char[]{'1', '1', '0', '1', '0'},
      new char[]{'1', '1', '0', '0', '0'},
      new char[]{'0', '0', '0', '0', '0'},
    });
    assertThat(lands).isEqualTo(1);

    lands = s.numIslands(new char[][]{
      new char[]{'1', '1', '0', '0', '0'},
      new char[]{'1', '1', '0', '0', '0'},
      new char[]{'0', '0', '1', '0', '0'},
      new char[]{'0', '0', '0', '1', '1'},
    });
    assertThat(lands).isEqualTo(3);

    lands = s.numIslands(new char[][]{
      new char[]{'1', '1', '1'},
      new char[]{'0', '1', '0'},
      new char[]{'1', '1', '1'},
    });
    assertThat(lands).isEqualTo(1);
  }

  /**
   * 2 ms	41.9 MB
   */
  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    int lands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (visited[i][j]) continue;

        if (grid[i][j] == '1') {
          traverseLand(grid, visited, i, j);
          lands++;
        }
      }
    }

    return lands;
  }

  private void traverseLand(char[][] grid, boolean[][] visited, int i, int j) {
    if (i < 0 || grid.length <= i) return;
    if (j < 0 || grid[0].length <= j) return;
    if (visited[i][j]) return;
    visited[i][j] = true;
    if (grid[i][j] == '0') return;

    traverseLand(grid, visited, i - 1, j);
    traverseLand(grid, visited, i + 1, j);
    traverseLand(grid, visited, i, j - 1);
    traverseLand(grid, visited, i, j + 1);
  }
}