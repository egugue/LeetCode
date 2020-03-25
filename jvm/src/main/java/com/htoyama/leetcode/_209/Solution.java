package com.htoyama.leetcode._209;

import com.htoyama.leetcode.utils.SlidingWindow;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
  }

  /**
   * 1 ms	42.8 MB
   */
  @SlidingWindow
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int i = 0;
    int j = 0;
    int minLength = Integer.MAX_VALUE;
    int currSum = 0;

    while (j < nums.length) {
      int num = nums[j];
      int sum = currSum + num;
      if (sum < s) {
        currSum = sum;
        j++;
        continue;
      }

      minLength = Math.min(minLength, j - i + 1);
      currSum -= nums[i++];
    }

    if (minLength == Integer.MAX_VALUE) {
      return 0; // If there isn't one, return 0 instead.
    } else {
      return minLength;
    }
  }
}
