package com.htoyama.leetcode._120;

import com.htoyama.leetcode.utils.Level;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/triangle/
 */
@Level.Medium
class Solution {

  @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
  public static void main(String[] args) {
    Solution s = new Solution();

    int m;
    m = s.minimumTotal(asList());
    assertThat(m).isEqualTo(0);

    m = s.minimumTotal(asList(
      asList(2)
    ));
    assertThat(m).isEqualTo(2);

    m = s.minimumTotal(asList(
      asList(2),
      asList(3, 4),
      asList(6, 5, 7),
      asList(4, 1, 8, 3)
    ));
    assertThat(m).isEqualTo(11);
  }

  /**
   * 1 ms	39.7 MB
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.isEmpty()) return 0;

    for (int i = 1; i < triangle.size(); i++) {
      helper(i, triangle);
    }

    int min = Integer.MAX_VALUE;
    for (int integer : triangle.get(triangle.size() - 1)) {
      min = Math.min(min, integer);
    }
    return min;
  }

  private void helper(int curRow, List<List<Integer>> minPath) {
    List<Integer> prev = minPath.get(curRow - 1);
    List<Integer> cur = minPath.get(curRow);

    cur.set(0, cur.get(0) + prev.get(0));
    for (int i = 1; i < cur.size() - 1; i++) {
      cur.set(i, cur.get(i) + Math.min(prev.get(i - 1), prev.get(i)));
    }
    cur.set(cur.size() - 1, cur.get(cur.size() - 1) + prev.get(prev.size() - 1));
  }
}