package com.htoyama.leetcode._118;

import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
@Level.Easy
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.generate(0)).containsExactly(
    );
    assertThat(s.generate(1)).containsExactly(
      asList(1)
    );
    assertThat(s.generate(5)).containsExactly(
      asList(1),
      asList(1, 1),
      asList(1, 2, 1),
      asList(1, 3, 3, 1),
      asList(1, 4, 6, 4, 1)
    );
  }

  /**
   * 0 ms	37.2 MB
   */
  public List<List<Integer>> generate(int numRows) {
    ArrayList<List<Integer>> res = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      helper(i, res);
    }
    return res;
  }

  private void helper(int i, List<List<Integer>> res) {
    if (i == 0) {
      res.add(Collections.singletonList(1));
      return;
    }

    List<Integer> ints = new ArrayList<>(i + 1);
    int prev = 0;
    for (int above : res.get(i - 1)) {
      ints.add(prev + above);
      prev = above;
    }
    ints.add(prev);
    res.add(ints);
  }
}