package com.htoyama.leetcode._054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> integers;
    integers = s.spiralOrder(new int[][]{
      new int[]{1, 2, 3},
      new int[]{4, 5, 6},
      new int[]{7, 8, 9},
    });
    assertThat(integers).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);

    integers = s.spiralOrder(new int[][]{
      new int[]{1, 2, 3, 4},
      new int[]{5, 6, 7, 8},
      new int[]{9, 10, 11, 12},
    });
    assertThat(integers).containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return Collections.emptyList();
    ArrayList<Integer> order = new ArrayList<>(matrix.length * matrix[0].length);
//    recursive(
//      matrix, 1, order,
//      0, matrix.length - 1, 0, matrix[0].length - 1
//    );
    iterative(matrix, order);
    return order;
  }

  /**
   * 0 ms	38.9 MB
   */
  private static void iterative(
    int[][] matrix, ArrayList<Integer> order
  ) {
    int type = 1;
    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (bottom - top + 1 != 0 && right - left + 1 != 0) {
      switch (type) {
        // left to right
        case 1:
          for (int j = left; j <= right; j++) order.add(matrix[top][j]);
          type = 2;
          top += 1;
          break;
        // top to bottom
        case 2:
          for (int i = top; i <= bottom; i++) order.add(matrix[i][right]);
          type = 3;
          right -= 1;
          break;

        // right to left
        case 3:
          for (int j = right; j >= left; j--) order.add(matrix[bottom][j]);
          type = 4;
          bottom -= 1;
          break;

        // bottom to top
        case 4:
          for (int i = bottom; i >= top; i--) order.add(matrix[i][left]);
          type = 1;
          left += 1;
      }
    }
  }

  /**
   * 0 ms	37.8 MB
   */
  private static void recursive(
    int[][] matrix, int type, ArrayList<Integer> order,
    int top, int bottom, int left, int right
  ) {
    if (bottom - top + 1 == 0 || right - left + 1 == 0) return;

    switch (type) {
      // left to right
      case 1:
        for (int j = left; j <= right; j++) order.add(matrix[top][j]);
        recursive(
          matrix, 2, order,
          top + 1, bottom, left, right
        );
        return;

      // top to bottom
      case 2:
        for (int i = top; i <= bottom; i++) order.add(matrix[i][right]);
        recursive(
          matrix, 3, order,
          top, bottom, left, right - 1
        );
        return;

      // right to left
      case 3:
        for (int j = right; j >= left; j--) order.add(matrix[bottom][j]);
        recursive(
          matrix, 4, order,
          top, bottom - 1, left, right
        );
        return;

      // bottom to top
      case 4:
        for (int i = bottom; i >= top; i--) order.add(matrix[i][left]);
        recursive(
          matrix, 1, order,
          top, bottom, left + 1, right
        );
    }
  }
}