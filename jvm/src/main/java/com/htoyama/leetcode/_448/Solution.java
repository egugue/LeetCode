package com.htoyama.leetcode._448;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})).containsExactlyInAnyOrder(5, 6);
  }

  /**
   * 5 ms	48.4 MB
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int num : nums) {
      int index = Math.abs(num) - 1;
      if (nums[index] > 0) nums[index] = -nums[index];
    }

    ArrayList<Integer> disappeared = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) disappeared.add(i + 1);
    }

    return disappeared;
  }
}