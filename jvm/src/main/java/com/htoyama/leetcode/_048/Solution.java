package com.htoyama.leetcode._048;

import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] matrix;
    matrix = new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
//    matrix = new int[][]{
//      {1, 2, 3, 4},
//      {5, 6, 7, 8},
//      {9, 10, 11, 12},
//      {13, 14, 15, 16},
//    };

    s.rotate(matrix);

    for (int[] ints : matrix) {
      System.out.println(Arrays.toString(ints));
    }
  }

  /**
   * 0 ms	39.8 MB
   */
  public void rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length != matrix.length) return;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = tmp;
      }
    }
  }
}