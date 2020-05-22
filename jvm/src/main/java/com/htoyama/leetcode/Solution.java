package com.htoyama.leetcode;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
    assertThat(s.jump(new int[]{2, 1, 1, 1, 4})).isEqualTo(3);
  }

  public int jump(int[] nums) {
    if (nums.length <= 1) return 0;

    int[] dp = new int[nums.length];
    Arrays.fill(dp, nums.length);
    dp[0] = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i + nums[i] >= nums.length - 1) return dp[i] + 1;

      for (int x = i; x <= i + nums[i] && x < nums.length; x++) {
        dp[x] = Math.min(dp[x], dp[i] + 1);
      }
    }

    return dp[nums.length - 1];
  }
}