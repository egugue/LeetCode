package com.htoyama.leetcode._309;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.DynamicProgramming;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxProfit(new int[]{1, 2, 3, 0, 2})).isEqualTo(3);
  }

  /**
   * 1 ms	38 MB
   */
  @DynamicProgramming
  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    // hold = 0, sell = 1, noop = 2
    int[][] dp = new int[prices.length][3];
    dp[0][0] = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      // hold = keep holding or buy a stock
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);

      // sell = sell a held stock
      dp[i][1] = dp[i - 1][0] + prices[i];

      // noop = jump from selling or keep noop
      dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
    }

    int last = prices.length - 1;
    return Math.max(dp[last][1], dp[last][2]);
  }
}