package com.htoyama.leetcode._090;

import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
@Level.Medium
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<Integer>> lists = s.subsetsWithDup(new int[]{1, 2, 2});
    System.out.println(lists);
  }

  /**
   * 1 ms	39.6 MB
   */
  @Backtracking
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> subsets = new ArrayList<>();
    backtrack(0, nums, new ArrayList<>(nums.length), subsets);
    return subsets;
  }

  private void backtrack(int index, int[] nums, List<Integer> builder, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(builder));

    for (int i = index; i < nums.length; i++) {
      if (i != index && nums[i] == nums[i - 1]) continue;
      builder.add(nums[i]);
      backtrack(i + 1, nums, builder, subsets);
      builder.remove(builder.size() - 1);
    }
  }
}