package com.htoyama.leetcode._189;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
//    s.rotate(nums, 3);
//    assertThat(nums).containsExactly(5, 6, 7, 1, 2, 3, 4);

    nums = new int[]{-1, -100, 3, 99};
    s.rotate(nums, 1);
    assertThat(nums).containsExactly(3, 99, -1, -100);
  }

  /**
   * 1 ms	42.3 MB
   */
  public void rotate(int[] nums, int k) {
    if (nums.length == 0 || nums.length == k) return;

    int i = 0;
    int swapCount = 0;
    while (swapCount < nums.length) {
      int start = i;
      int value = nums[i];
      do {
        int next = (i + k) % nums.length;
        int nextValue = nums[next];
        nums[next] = value;
        swapCount++;

        i = next;
        value = nextValue;
      } while(i != start);

      i = start + 1;
    }
  }
}