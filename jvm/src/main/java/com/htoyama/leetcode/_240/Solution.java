package com.htoyama.leetcode._240;

class Solution {
  /**
   * 4 ms	45 MB
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int row = 0;
    int column = matrix[0].length - 1;
    while (column >= 0 && row < matrix.length) {
      if (target > matrix[row][column]) {
        row++;
      } else if (target < matrix[row][column]) {
        column--;
      } else {
        return true;
      }
    }

    return false;
  }
}