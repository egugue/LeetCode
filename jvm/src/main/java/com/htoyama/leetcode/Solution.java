package com.htoyama.leetcode;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
    assertThat(s.jump(new int[]{2, 1, 1, 1, 4})).isEqualTo(3);
  }

  /**
   * 2 ms	41.5 MB
   *
   * https://www.youtube.com/watch?v=vBdo7wtwlXs&t=181s
   */
  public int jump(int[] nums) {
    if (nums.length <= 1) return 0;

    int curLadder = 0;
    int jumps = 0;
    int longestLadder = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (curLadder < i) {
        // need to switch longer ladder
        curLadder = longestLadder;
        jumps++;
      }

      longestLadder = Math.max(longestLadder, i + nums[i]);
    }

    return jumps;
  }
}