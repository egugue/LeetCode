package com.htoyama.leetcode._022;

import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.String_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
@Level.Medium
@String_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.generateParenthesis(0)).containsExactlyInAnyOrder(
    );
    assertThat(s.generateParenthesis(1)).containsExactlyInAnyOrder(
      "()"
    );
    assertThat(s.generateParenthesis(3)).containsExactlyInAnyOrder(
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    );
  }

  /**
   * 0 ms	39.9 MB
   */
  @Backtracking
  public List<String> generateParenthesis(int n) {
    if (n == 0) return Collections.emptyList();

    ArrayList<String> parenthesis = new ArrayList<>();
    helper(0, 0, new StringBuilder(n * 2), n, parenthesis);
    return parenthesis;
  }

  private void helper(int open, int close, StringBuilder sb, int n, List<String> parenthesis) {
    if (sb.length() == n * 2) {
      parenthesis.add(sb.toString());
      return;
    }

    if (open < n) {
      helper(open + 1, close, sb.append('('), n, parenthesis);
      sb.setLength(sb.length() - 1);
    }
    if (close < open) {
      helper(open, close + 1, sb.append(')'), n, parenthesis);
      sb.setLength(sb.length() - 1);
    }
  }
}