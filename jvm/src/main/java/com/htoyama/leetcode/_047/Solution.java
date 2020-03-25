package com.htoyama.leetcode._047;

import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
@Level.Medium
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.permute(new int[]{1}));
    System.out.println(s.permute(new int[]{1, 2}));
    System.out.println(s.permute(new int[]{1, 2, 3}));
    System.out.println(s.permute(new int[]{1, 2, 3, 4}));
  }

  /**
   * 3 ms	41 MB
   *
   * TODO: Must try later
   */
  @Backtracking
  public List<List<Integer>> permute(int[] nums) {
    ArrayList<List<Integer>> permutation = new ArrayList<>();
    backtrack(permutation, new LinkedHashSet<>(), nums);
    return permutation;
  }

  private void backtrack(List<List<Integer>> permutation, LinkedHashSet<Integer> building, int[] nums) {
    if (building.size() == nums.length) {
      permutation.add(new ArrayList<>(building));
      return;
    }

    for (int num : nums) {
      if (!building.add(num)) continue;
      backtrack(permutation, building, nums);
      building.remove(num);
    }
  }
}
