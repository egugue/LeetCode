package com.htoyama.leetcode._152;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxProduct(new int[]{2, 3, -2, 4})).isEqualTo(6);
    assertThat(s.maxProduct(new int[]{2, 3, 2, 4})).isEqualTo(48);
    assertThat(s.maxProduct(new int[]{2, -3, -2, 4})).isEqualTo(48);
    assertThat(s.maxProduct(new int[]{-2, 0, -1})).isEqualTo(0);
  }

  /**
   * 1 ms	39.4 MB
   */
  public int maxProduct(int[] nums) {
    if (nums.length == 0) return 0;

    int max = nums[0];
    int min = max;
    int result = max;

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num < 0) {
        int tmp = max;
        max = min;
        min = tmp;
      }

      max = Math.max(num, max * num);
      min = Math.min(num, min * num);
      result = Math.max(max, result);
    }

    return result;
  }
}