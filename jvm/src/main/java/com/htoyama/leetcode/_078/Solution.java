package com.htoyama.leetcode._078;

import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/subsets/
 */
@Level.Medium
class Solution {

  @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<Integer>> r;

    r = s.subsets(new int[]{});
    System.out.println(r);
    assertThat(r).containsExactlyInAnyOrder(asList());

    r = s.subsets(new int[]{1});
    System.out.println(r);
    assertThat(r).containsExactlyInAnyOrder(asList(), asList(1));

    r = s.subsets(new int[]{1, 2});
    System.out.println(r);
    assertThat(r).containsExactlyInAnyOrder(
      asList(),
      asList(1), asList(2),
      asList(1, 2)
    );

    r = s.subsets(new int[]{1, 2, 3});
    System.out.println(r);
    assertThat(r).containsExactlyInAnyOrder(
      asList(),
      asList(1), asList(2), asList(3),
      asList(1, 2), asList(1, 3), asList(2, 3),
      asList(1, 2, 3)
    );
  }

  /**
   * 0 ms	38.8 MB
   */
  @Backtracking
  public List<List<Integer>> subsets(int[] nums) {
    ArrayList<List<Integer>> subsets = new ArrayList<>();
    backtrack(0, nums, new ArrayList<>(nums.length), subsets);
    return subsets;
  }

  private void backtrack(int index, int[] nums, List<Integer> builder, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(builder));

    for (int i = index; i < nums.length; i++) {
      builder.add(nums[i]);
      backtrack(i + 1, nums, builder, subsets);
      builder.remove(builder.size() - 1);
    }
  }
}