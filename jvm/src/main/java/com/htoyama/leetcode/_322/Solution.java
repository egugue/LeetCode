package com.htoyama.leetcode._322;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.DynamicProgramming;
import com.htoyama.leetcode.utils.Level;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/coin-change/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
    assertThat(s.coinChange(new int[]{2}, 3)).isEqualTo(-1);
    assertThat(s.coinChange(new int[]{3}, 2)).isEqualTo(-1);
    assertThat(s.coinChange(new int[]{1, 3, 6}, 22)).isEqualTo(5);
  }

  /**
   * 11 ms	41.1 MB
   */
  @DynamicProgramming
  public int coinChange(int[] coins, int amount) {
    if (coins.length == 0) return -1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }
}