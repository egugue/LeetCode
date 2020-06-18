package com.htoyama.leetcode._300;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
    assertThat(s.lengthOfLIS(new int[]{3, 4, -1, 0, 6, 2, 3})).isEqualTo(4);
  }

  /**
   * 10 ms	37.8 MB
   */
  public int lengthOfLIS(int[] nums) {
    if (nums.length <= 1) return nums.length;

    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) dp[i] = 1;

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      for (int j = 0; j < i; j++) {
        if (nums[j] < num) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int lis = 0;
    for (int value : dp) {
      lis = Math.max(lis, value);
    }

    return lis;
  }
}