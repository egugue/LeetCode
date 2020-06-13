package com.htoyama.leetcode._041;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.firstMissingPositive(new int[]{1, 2, 0})).isEqualTo(3);
    assertThat(s.firstMissingPositive(new int[]{3, 4, -1, 1})).isEqualTo(2);
    assertThat(s.firstMissingPositive(new int[]{7, 8, 9, 11, 12})).isEqualTo(1);
    assertThat(s.firstMissingPositive(new int[]{1})).isEqualTo(2);
    assertThat(s.firstMissingPositive(new int[]{1, 1})).isEqualTo(2);
    assertThat(s.firstMissingPositive(new int[]{0, 1, 2})).isEqualTo(3);
  }

  /**
   * 0 ms	37.2 MB
   *
   * This approach is inspired by {@link com.htoyama.leetcode._448}
   */
  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) return 1;

    // find the first positive number
    int firstPositive = -1;
    for (int num : nums) {
      if (num > 0) {
        firstPositive = num;
        break;
      }
    }
    if (firstPositive == -1) return 1;

    // change 0 and a negative number to the first positive number
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0) nums[i] = firstPositive;
    }

    // inverse the num at a positive number to mark the positive number appears
    for (int i = 0; i < nums.length; i++) {
      int num = Math.abs(nums[i])- 1;
      if (0 <= num && num < nums.length && nums[num] > 0) {
        nums[num] *= -1;
      }
    }

    // find 0 or a positive number, which means didn't appear in the original array.
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) return i + 1;
    }

    // if any numbers cannot be found, the array has numbers from 1 to array's length.
    // thus, the next number to array's length is the answer.
    return nums.length + 1;
  }
}