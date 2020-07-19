package com.htoyama.leetcode._454;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int count;
    count = s.fourSumCount(
      new int[]{1, 2},
      new int[]{-2, -1},
      new int[]{-1, 2},
      new int[]{0, 2}
//      new int[]{1},
//      new int[]{-2},
//      new int[]{-1},
//      new int[]{0}
    );
    assertThat(count).isEqualTo(2);
  }

  /**
   * 60 ms	58.7 MB
   */
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int length = A.length;
    if (length == 0) return 0;

    HashMap<Integer, Integer> sums = new HashMap<>();
    for (int a : A) {
      for (int j = 0; j < length; j++) {
        int sum = a + B[j];
        sums.put(sum, sums.getOrDefault(sum, 0) + 1);
      }
    }

    int count = 0;
    for (int i = 0; i < length; i++) {
      int c = C[i];
      for (int j = 0; j < length; j++) {
        int sum = c + D[j];
        count += sums.getOrDefault(-sum, 0);
      }
    }
    return count;
  }
}