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
    matrix = new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16},
    };
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
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int from1 = i;
        int from2 = j;
        int prev = matrix[from1][from2];

        while (!visited[from1][from2]) {
          int to1 = from2;
          int to2 = Math.abs(from1 - matrix.length + 1);
          int tmp = matrix[to1][to2];
          matrix[to1][to2] = prev;
          prev = tmp;
          visited[from1][from2] = true;
          from1 = to1;
          from2 = to2;
        }

      }
    }
  }
}