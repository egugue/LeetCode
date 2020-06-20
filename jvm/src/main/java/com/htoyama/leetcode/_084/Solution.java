package com.htoyama.leetcode._084;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 4})).isEqualTo(10);
  }

  public int largestRectangleArea(int[] heights) {
    if (heights.length <= 1) {
      return heights.length == 0 ? 0 : heights[0];
    }
    return dp_On(heights);
//    return dp_On2(heights);
  }

  /**
   * 1 ms	40.7 MB
   * see https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)}
   */
  private static int dp_On(int[] heights) {
    int[] firstLeftLessHeightIndex = new int[heights.length];
    int[] firstRightLessHeightIndex = new int[heights.length];
    firstLeftLessHeightIndex[0] = -1;
    firstRightLessHeightIndex[heights.length - 1] = heights.length;

    for (int i = 1; i < heights.length; i++) {
      int firstLessIndex = i - 1;
      while (firstLessIndex >= 0 && heights[firstLessIndex] >= heights[i]) {
        firstLessIndex = firstLeftLessHeightIndex[firstLessIndex];
      }
      firstLeftLessHeightIndex[i] = firstLessIndex;
    }

    for (int i = heights.length - 2; i >= 0; i--) {
      int firstLessIndex = i + 1;
      while(firstLessIndex < heights.length && heights[firstLessIndex] >= heights[i]) {
        firstLessIndex = firstRightLessHeightIndex[firstLessIndex];
      }
      firstRightLessHeightIndex[i] = firstLessIndex;
    }

    int largest = 0;
    for (int i = 0; i < heights.length; i++) {
      largest = Math.max(
        largest,
        heights[i] * (firstRightLessHeightIndex[i] - firstLeftLessHeightIndex[i] - 1)
      );
    }

    return largest;
  }

  /**
   * 873 ms	41.3 MB
   * this solution is inspired by {@link com.htoyama.leetcode._300}
   */
  private static int dp_On2(int[] heights) {
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