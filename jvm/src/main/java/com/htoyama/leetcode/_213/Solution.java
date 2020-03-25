package com.htoyama.leetcode._213;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.rob(new int[]{}));
    System.out.println(s.rob(new int[]{2}));
    System.out.println(s.rob(new int[]{2, 3}));
    System.out.println(s.rob(new int[]{2, 3, 2}));
    System.out.println(s.rob(new int[]{1, 2, 3, 1}));
  }

  /**
   * 0 ms	36.9 MB
   */
  public int rob(int[] nums) {
    switch (nums.length) {
      case 0:
        return 0;
      case 1:
        return nums[0];
    }

    int[] dp = new int[nums.length];

    // case of picking up first
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
    }
    int maxWhenPickingFirst = dp[dp.length - 1];

    // case of picking up last
    dp[0] = 0;
    dp[1] = nums[1];
    for (int i = 1; i < nums.length - 1; i++) {
      dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i + 1]);
    }

    return Math.max(maxWhenPickingFirst, dp[dp.length - 1]);
  }
}
