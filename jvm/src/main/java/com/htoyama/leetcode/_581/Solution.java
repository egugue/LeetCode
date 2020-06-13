package com.htoyama.leetcode._581;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})).isEqualTo(5);
    assertThat(s.findUnsortedSubarray(new int[]{1, 2, 3, 4})).isEqualTo(0);
  }

  /**
   * 6 ms	40.7 MB
   */
  public int findUnsortedSubarray(int[] nums) {
    if (nums.length <= 1) return 0;

    int[] sorted = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sorted);

    int left = -1;
    int right = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == sorted[i]) continue;

      if (left == -1) left = i;
      right = i;
    }

    if (left == -1) return 0;
    return right - left + 1;
  }
}