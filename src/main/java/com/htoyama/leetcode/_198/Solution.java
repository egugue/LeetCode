package com.htoyama.leetcode._198;

/**
 * https://leetcode.com/problems/house-robber/
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.rob(new int[]{}));
    System.out.println(s.rob(new int[]{1}));
    System.out.println(s.rob(new int[]{1, 2}));
    System.out.println(s.rob(new int[]{1, 2, 3}));
    System.out.println(s.rob(new int[]{1, 2, 3, 1}));
    System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
  }

  /**
   * 0 ms	37.3 MB
   */
  public int rob(int[] nums) {
    switch (nums.length) {
      case 0:
        return 0;
      case 1:
        return nums[0];
      case 2:
        return Math.max(nums[0], nums[1]);
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = nums[1];
    dp[2] = dp[0] + nums[2];

    int max = Math.max(dp[1], dp[2]);
    for (int i = 3; i < nums.length; i++) {
      dp[i] = nums[i] + Math.max(dp[i - 3], dp[i - 2]);
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
