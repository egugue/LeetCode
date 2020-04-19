package com.htoyama.leetcode._494;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.DFS;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/target-sum/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findTargetSumWays(new int[]{1, 1, 1}, 1)).isEqualTo(3);
    assertThat(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
  }

  /**
   * 575 ms	37.3 MB
   *
   * TODO: Improve runtime
   */
  @DFS
  public int findTargetSumWays(int[] nums, int S) {
    if (nums.length == 0) return 0;
    return helper(0, true, 0, nums, S) + helper(0, false, 0, nums, S);
  }

  private int helper(int sum, boolean add, int i, int[] nums, int S) {
    sum = sum + (add ? nums[i] : -nums[i]);
    i++;

    if (i == nums.length) {
      return sum == S ? 1 : 0;
    }

    return helper(sum, true, i, nums, S) + helper(sum, false, i, nums, S);
  }
}