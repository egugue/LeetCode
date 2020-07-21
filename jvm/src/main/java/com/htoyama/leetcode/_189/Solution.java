package com.htoyama.leetcode._189;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
//    s.rotate(nums, 3);
//    assertThat(nums).containsExactly(5, 6, 7, 1, 2, 3, 4);

    nums = new int[]{-1, -100, 3, 99};
    s.rotate(nums, 2);
    assertThat(nums).containsExactly(3, 99, -1, -100);
  }

  /**
   * 1 ms	42.3 MB
   */
  public void rotate(int[] nums, int k) {
    if (nums.length == 0) return;
    if (nums.length == k) return;

    int i = 0;
    int swapCount = 0;
    do {
      int j = i;
      int value = nums[j];
      do {
        int next = (j + k) % nums.length;
        int nextValue = nums[next];
        nums[next] = value;
        j = next;
        value = nextValue;
        swapCount++;
      } while(j != i);

      if (swapCount >= nums.length) return;
      i++;
    } while(i != 0);
  }
}