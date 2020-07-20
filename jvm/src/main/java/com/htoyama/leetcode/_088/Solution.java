package com.htoyama.leetcode._088;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    s.merge(nums1, 3, new int[]{2, 5, 6}, 3);
    assertThat(nums1).containsExactly(1, 2, 2, 3, 5, 6);
  }

  /**
   * 0 ms	40.1 MB
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int right = nums1.length - 1;
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[right--] = nums1[i--];
      } else {
        nums1[right--] = nums2[j--];
      }
    }

    while (j >= 0) {
      nums1[right--] = nums2[j--];
    }
  }
}