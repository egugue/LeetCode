package com.htoyama.leetcode._560;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.subarraySum(new int[]{1, 1, 1}, 2)).isEqualTo(2);
  }

  /**
   * 549 ms	41 MB
   */
  public int subarraySum(int[] nums, int k) {
    if (nums.length == 0) return 0;

    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }

    int count = 0;
    for (int start = -1; start < nums.length; start++) {
      for (int end = start + 1; end < nums.length; end++) {
        int sv = start == -1 ? 0 : nums[start];
        if (nums[end] - sv == k)
          count++;
      }
    }

    return count;
  }
}