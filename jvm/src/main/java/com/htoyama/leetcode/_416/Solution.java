package com.htoyama.leetcode._416;

import com.htoyama.leetcode.utils.DynamicProgramming;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
@Level.Medium
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.canPartition(new int[]{1, 5, 11, 5})).isEqualTo(true);
    assertThat(s.canPartition(new int[]{1, 2, 3, 5})).isEqualTo(false);
  }

  @DynamicProgramming
  public boolean canPartition(int[] nums) {
    assert nums.length != 0;
    int sum = 0;
    for (int num : nums) sum += num;
    if (sum % 2 == 1) return false;

    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : nums) {
      for (int j = target; j >= 0; j--) {
        if (j - num >= 0) {
          dp[j] = dp[j] || dp[j - num];
        }
      }
    }

    return dp[target];
  }
}