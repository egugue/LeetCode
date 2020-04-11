package com.htoyama.leetcode._169;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/majority-element/
 */
@Level.Easy
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.majorityElement(new int[]{1})).isEqualTo(1);
    assertThat(s.majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
    assertThat(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
  }

  /**
   * 1 ms	43 MB
   */
  public int majorityElement(int[] nums) {
    if (nums.length == 1) return nums[0];
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}