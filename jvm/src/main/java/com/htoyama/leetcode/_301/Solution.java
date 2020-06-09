package com.htoyama.leetcode._301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.removeInvalidParentheses("())()")).containsExactlyInAnyOrder(
      "()()"
    );
    assertThat(s.removeInvalidParentheses("()())()")).containsExactlyInAnyOrder(
      "()()()", "(())()"
    );
    assertThat(s.removeInvalidParentheses("(a)())()")).containsExactlyInAnyOrder(
      "(a)()()", "(a())()"
    );
    assertThat(s.removeInvalidParentheses(")(")).containsExactlyInAnyOrder(
      ""
    );
    assertThat(s.removeInvalidParentheses("((i)")).containsExactlyInAnyOrder(
      "(i)"
    );
  }

  /**
   * 37 ms	39.8 MB
   */
  public List<String> removeInvalidParentheses(String s) {
    int open = 0;
    int invalidClose = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        open++;
      } else if (s.charAt(i) == ')'){
        if (open == 0) invalidClose++;
        else open--;
      }
    }
    int invalidOpen = open;

    HashSet<String> result = new HashSet<>();
    int expectedSize = s.length() - invalidOpen - invalidClose;
    backtrack(s, expectedSize, 0, new StringBuilder(expectedSize), 0, 0, result);
    return new ArrayList<>(result);
  }

  private void backtrack(
    String s,
    int expectedLength,
    int i,
    StringBuilder sb,
    int open,
    int close,
    Set<String> result
  ) {
    if (open < close) return; // minus means close is more than open
    if (sb.length() == expectedLength) {
      if (open == close) result.add(sb.toString());
      return;
    }
    if (i == s.length()) return;

    char ch = s.charAt(i);
    if (ch != '(' && ch != ')') {
      sb.append(s.charAt(i));
      backtrack(s, expectedLength, i + 1, sb, open, close, result);
      sb.setLength(sb.length() - 1);
      return;
    }

    sb.append(ch);
    if (ch == '(') {
      backtrack(s, expectedLength, i + 1, sb, open + 1, close, result);
    } else {
      backtrack(s, expectedLength, i + 1, sb, open, close + 1, result);
    }
    sb.setLength(sb.length() - 1);

    backtrack(s, expectedLength, i + 1, sb, open, close, result);
  }
}