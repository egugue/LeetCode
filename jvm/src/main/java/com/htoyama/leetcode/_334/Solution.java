package com.htoyama.leetcode._334;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.increasingTriplet(new int[]{1, 2, 3, 4, 5})).isTrue();
    assertThat(s.increasingTriplet(new int[]{5, 4, 3, 2, 1})).isFalse();
    assertThat(s.increasingTriplet(new int[]{3, 2, 5, 6})).isTrue();
  }

  /**
   * 1 ms	40.9 MB
   */
  public boolean increasingTriplet(int[] nums) {
    if (nums.length < 3) return false;

    int max = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= min) min = num;
      else if (num <= max) max = num;
      else return true;
    }

    return false;
  }
}