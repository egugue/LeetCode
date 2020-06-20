package com.htoyama.leetcode._084;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 4})).isEqualTo(10);
  }

  /**
   * 873 ms	41.3 MB
   *
   * this solution is inspired by {@link com.htoyama.leetcode._300}
   */
  public int largestRectangleArea(int[] heights) {
    if (heights.length <= 1) {
      return heights.length == 0 ? 0 : heights[0];
    }

    int[] dp = new int[heights.length];
    for (int right = 0; right < heights.length; right++) {
      int min = Integer.MAX_VALUE;
      for (int left = right; left >= 0; left--) {
        min = Math.min(min, heights[left]);
        dp[left] = Math.max(dp[left], min * (right - left + 1));
      }
    }

    int largest = 0;
    for (int value : dp) {
      largest = Math.max(largest, value);
    }

    return largest;
  }
}