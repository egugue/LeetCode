package com.htoyama.leetcode._384;

import java.util.Arrays;
import java.util.Random;

/**
 * 78 ms	47.8 MB
 */
class Solution {

  private final int[] original;
  private final int[] nums;
  private final Random random = new Random();

  public Solution(int[] nums) {
    original = Arrays.copyOf(nums, nums.length);
    this.nums = nums;
  }

  /**
   * Resets the array to its original configuration and return it.
   */
  public int[] reset() {
    System.arraycopy(original, 0, nums, 0, nums.length);
    return nums;
  }

  /**
   * Returns a random shuffling of the array.
   */
  public int[] shuffle() {
    for (int i = nums.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      int tmp = nums[index];
      nums[index] = nums[i];
      nums[i] = tmp;
    }
    return nums;
  }
}