package com.htoyama.leetcode._077;

import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/combinations/
 */
@Level.Medium
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.combine(4, 2)).containsExactlyInAnyOrder(
      asList(2, 4),
      asList(3, 4),
      asList(2, 3),
      asList(1, 2),
      asList(1, 3),
      asList(1, 4)
    );
  }

  /**
   * 19 ms	40.4 MB
   */
  @Backtracking
  public List<List<Integer>> combine(int n, int k) {
    if (n == 0 || k == 0) return Collections.emptyList();

    ArrayList<List<Integer>> combinations = new ArrayList<>();
    helper(1, n, k, new ArrayList<>(k), combinations);
    return combinations;
  }

  private void helper(int curI, int n, int k, List<Integer> builder, List<List<Integer>> combinations) {
    if (builder.size() == k) {
      combinations.add(new ArrayList<>(builder));
      return;
    }

    for (int i = curI; i <= n; i++) {
      builder.add(i);
      helper(i + 1, n, k, builder, combinations);
      builder.remove(builder.size() - 1);
    }
  }
}