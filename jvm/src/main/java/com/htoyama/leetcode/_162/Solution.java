package com.htoyama.leetcode._162;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findPeakElement(new int[]{1, 2})).isEqualTo(1);
    assertThat(s.findPeakElement(new int[]{1, 2, 3, 1})).isEqualTo(2);
    assertThat(s.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})).isEqualTo(1);
  }

  /**
   * 0 ms	39.2 MB
   */
  public int findPeakElement(int[] nums) {
    if (nums.length <= 1) return nums.length - 1;

    if (nums[0] > nums[1]) return 0;
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
        return i;
      }
    }
    if (nums[nums.length - 2] < nums[nums.length - 1]) {
      return nums.length - 1;
    }

    return -1;
  }
}