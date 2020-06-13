package com.htoyama.leetcode._581;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})).isEqualTo(5);
    assertThat(s.findUnsortedSubarray(new int[]{1, 2, 3, 4})).isEqualTo(0);
    assertThat(s.findUnsortedSubarray(new int[]{1, 3, 2, 4, 5})).isEqualTo(2);
    assertThat(s.findUnsortedSubarray(new int[]{1, 3, 2, 3, 3})).isEqualTo(2);
  }

  public int findUnsortedSubarray(int[] nums) {
    return withoutExtraSpace(nums);
//    return useSort(nums);
  }

  /**
   * 6 ms	40.7 MB
   */
  private static int useSort(int[] nums) {
    if (nums.length <= 1) return 0;

    int[] sorted = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sorted);

    int left = -1;
    int right = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == sorted[i]) continue;

      if (left == -1) left = i;
      right = i;
    }

    if (left == -1) return 0;
    return right - left + 1;
  }

  /**
   * 1 ms	40.5 MB
   *
   * Official approach 5
   */
  private static int withoutExtraSpace(int[] nums) {
    if (nums.length <= 1) return 0;

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean sorted = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) sorted = false;
      if (!sorted) min = Math.min(min, nums[i]);
    }

    sorted = true;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] > nums[i + 1]) sorted = false;
      if (!sorted) max = Math.max(max, nums[i]);
    }

    int left = 0;
    while (left < nums.length && min >= nums[left]) left++;

    int right = nums.length - 1;
    while (right >= 0 && max <= nums[right]) right--;

    return right - left < 0 ? 0 : right - left + 1;
  }
}