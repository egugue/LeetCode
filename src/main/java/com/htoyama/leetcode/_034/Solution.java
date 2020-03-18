package com.htoyama.leetcode._034;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.BinarySearch;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).containsExactly(3, 4);
    assertThat(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).containsExactly(-1, -1);
    assertThat(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, -6)).containsExactly(-1, -1);

    assertThat(s.searchRange(new int[]{0, 2, 2, 2, 2, 5, 6, 7, 8}, 2)).containsExactly(1, 4);
    assertThat(s.searchRange(new int[]{}, 2)).containsExactly(-1, -1);
  }

  /**
   * 0 ms	42.5 MB
   */
  @BinarySearch
  public int[] searchRange(int[] nums, int target) {
    int from = binarySearch(nums, target, true);
    if (from == -1) return new int[]{-1, -1};
    int to = binarySearch(nums, target, false);
    return new int[]{from, to};
  }

  private int binarySearch(int[] nums, int target, boolean lowestIndex) {
    int left = -1;
    int right = nums.length;
    boolean found = false;
    while (right - left != 1) {
      int mid = left + (right - left) / 2;

      if (target == nums[mid]) {
        if (lowestIndex) right = mid;
        else left = mid;
        found = true;
      } else if (target < nums[mid]) {
        right = mid;
      } else {
        left = mid;
      }
    }

    if (!found) return -1;
    return lowestIndex ? right : left;
  }
}
