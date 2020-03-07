package com.htoyama.leetcode._392;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/is-subsequence/
 *
 * TODO: Must solve follow up problem later.
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isSubsequence("abc", "ahbgdc")).isTrue();
    assertThat(s.isSubsequence("aec", "ahbgdc")).isFalse();
  }

  public boolean isSubsequence(String s, String t) {
    int sIndex = 0;
    int tIndex = 0;

    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      tIndex++;
    }

    return sIndex == s.length();
  }
}
