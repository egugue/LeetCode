package com.htoyama.leetcode._378;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
//    assertThat(s.kthSmallest(new int[][]{
//      new int[]{1, 5, 9},
//      new int[]{10, 11, 13},
//      new int[]{12, 13, 15}
//    }, 8)).isEqualTo(13);

//    assertThat(s.kthSmallest(new int[][]{
//      new int[]{1, 5, 30},
//      new int[]{2, 6, 31},
//      new int[]{12, 13, 41}
//    }, 8)).isEqualTo(31);

    assertThat(s.kthSmallest(new int[][]{
      new int[]{2000000000},
    }, 1)).isEqualTo(1);
  }

  /**
   * 1 ms	51.7 MB
   */
  public int kthSmallest(int[][] matrix, int k) {
    if (matrix.length == 0) return -1;

    int low = matrix[0][0];
    int high = matrix[matrix.length - 1][matrix.length - 1];
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int count = countLessThanOrEqual(matrix, mid);
      if (count < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private int countLessThanOrEqual(int[][] matrix, int val) {
    int count = 0;
    int i = matrix.length - 1;
    int j = 0;
    while (i >= 0 && j < matrix.length) {
      if (matrix[i][j] > val) {
        i--;
      } else {
        count += i + 1;
        j++;
      }
    }
    return count;
  }
}