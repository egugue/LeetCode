package com.htoyama.leetcode._055;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
    assertThat(s.canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
  }

  /**
   * 2 ms	43.4 MB
   */
  public boolean canJump(int[] nums) {
    if (nums.length == 0) return false;

    int availableMaxIndex = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int num = nums[i];
      if (num != 0) {
        availableMaxIndex = Math.max(availableMaxIndex, i + num);
        continue;
      }

      if (availableMaxIndex < i + 1) {
        // cannot jump next to 0
        return false;
      }
    }

    return true;
  }
}