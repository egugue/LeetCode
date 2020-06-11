package com.htoyama.leetcode._033;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)).isEqualTo(4);
    assertThat(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6)).isEqualTo(2);
    assertThat(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5)).isEqualTo(1);
    assertThat(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4)).isEqualTo(0);
    assertThat(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)).isEqualTo(-1);
    assertThat(s.search(new int[]{1}, 1)).isEqualTo(0);
    assertThat(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8)).isEqualTo(4);
  }

  /**
   * 2 ms	39.5 MB
   */
  public int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    if (nums.length == 1) return nums[0] == target ? 0 : -1;

    int left = -1;
    int right = nums.length;
    while (right - left > 1) {
      int mid = (right + left) / 2;
      if (nums[mid] == target) return mid;

      int num = (nums[mid] < nums[0]) == (target < nums[0])
        ? nums[mid]
        : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

      if (num < target) {
        left = mid;
      } else if (num > target) {
        right = mid;
      } else {
        return mid;
      }
    }

    return -1;
  }
}