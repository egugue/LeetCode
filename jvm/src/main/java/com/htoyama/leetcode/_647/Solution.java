package com.htoyama.leetcode._647;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.countSubstrings("abc")).isEqualTo(3);
    assertThat(s.countSubstrings("aaa")).isEqualTo(6);
  }

  /**
   * 8 ms	39 MB
   */
  public int countSubstrings(String s) {
    if (s.isEmpty()) return 0;

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += countSubstrings(s, i, i);
      count += countSubstrings(s, i, i + 1);
    }

    return count;
  }

  private static int countSubstrings(String s, int left, int right) {
    int count = 0;
    while(0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
    return count;
  }
}