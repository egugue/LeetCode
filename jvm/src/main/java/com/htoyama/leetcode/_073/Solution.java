package com.htoyama.leetcode._073;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] matrix = {
      new int[]{0, 1, 2, 1},
      new int[]{3, 4, 5, 2},
      new int[]{0, 3, 1, 5}
    };
    s.setZeroes(matrix);
    for (int[] ints : matrix) {
      System.out.println(Arrays.toString(ints));
    }

    matrix = new int[][] {
      new int[]{1, 1, 1},
      new int[]{1, 0, 1},
      new int[]{1, 1, 1}
    };
    s.setZeroes(matrix);
    for (int[] ints : matrix) {
      System.out.println(Arrays.toString(ints));
    }
  }

  /**
   * 1 ms	41 MB
   */
  public void setZeroes(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;

    boolean hasZeroInFirstRow = false;
    boolean hasZeroInFirstColumn = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) hasZeroInFirstRow = true;
          if (j == 0) hasZeroInFirstColumn = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (hasZeroInFirstColumn) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
    if (hasZeroInFirstRow) {
      Arrays.fill(matrix[0], 0);
    }
  }
}