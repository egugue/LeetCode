package com.htoyama.leetcode._287;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
    assertThat(s.findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
    assertThat(s.findDuplicate(new int[]{4, 3, 1, 4, 2})).isEqualTo(4);
    assertThat(s.findDuplicate(new int[]{1, 1, 2})).isEqualTo(1);
  }

  /**
   * 2 ms	39.5 MB
   */
  public int findDuplicate(int[] nums) {
    if (nums.length <= 1) return 0;

    int low = 0;
    int high = nums.length;
    while (high - low > 1) {
      int mid = (low + high) / 2;
      int count = 0;
      for (int num : nums) {
        if (num <= mid) ++count;
      }

      if (count <= mid) {
        low = mid;
      } else {
        high = mid;
      }
    }

    return high;
  }

}
