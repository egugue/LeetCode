package com.htoyama.leetcode._119;

import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
@Level.Easy
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.getRow(0)).containsExactly(1);
    assertThat(s.getRow(1)).containsExactly(1, 1);
    assertThat(s.getRow(2)).containsExactly(1, 2, 1);
    assertThat(s.getRow(3)).containsExactly(1, 3, 3, 1);
  }

  /**
   * 0 ms	37.1 MB
   */
  public List<Integer> getRow(int rowIndex) {
    ArrayList<Integer> rows = new ArrayList<>(rowIndex + 1);
    for (int i = 0; i <= rowIndex; i++) {
      rows.add(1);
    }

    for (int i = 0; i <= rowIndex; i++) {
      helper(i, rows);
    }

    return rows;
  }

  private void helper(int row, List<Integer> res) {
    int prev = 0;
    for (int i = 0; i < row; i++) {
      int cur = res.get(i);
      res.set(i, cur + prev);
      prev = cur;
    }
  }
}