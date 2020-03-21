package com.htoyama.leetcode._039;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<Integer>> lists;
    lists = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
    System.out.println(lists);

    lists = s.combinationSum(new int[]{2,3,5}, 8);
    System.out.println(lists);
  }

  /**
   * 4 ms	41.7 MB
   */
  @Backtracking
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<List<Integer>> combination = new ArrayList<>();
    backtracking(0, 0, new ArrayList<>(), combination, candidates, target);
    return combination;
  }

  private void backtracking(
    int curIndex,
    int curSum,
    List<Integer> builder,
    List<List<Integer>> combination,
    int[] candidates,
    int target
  ) {
    if (curSum > target) return;
    if (curSum == target) {
      combination.add(new ArrayList<>(builder));
      return; // All numbers (including target) will be positive integers.
    }

    for (int i = curIndex; i < candidates.length; i++) {
      builder.add(candidates[i]);
      backtracking(i, curSum + candidates[i], builder, combination, candidates, target);
      builder.remove(builder.size() - 1);
    }
  }
}