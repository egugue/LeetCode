package com.htoyama.leetcode._121;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
@Level.Easy
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
    assertThat(s.maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
    assertThat(s.maxProfit(new int[]{7})).isEqualTo(0);
    assertThat(s.maxProfit(new int[]{1, 7})).isEqualTo(6);
  }

  /**
   * 1 ms	42.1 MB
   */
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;

    int minStockPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int price : prices) {
      if (minStockPrice > price) {
        minStockPrice = price;
      } else {
        maxProfit = Math.max(maxProfit, price - minStockPrice);
      }
    }

    return maxProfit;
  }
}
