package com.htoyama.leetcode._395;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.longestSubstring("aaabb", 3)).isEqualTo(3);
    assertThat(s.longestSubstring("ababbc", 2)).isEqualTo(5);
    assertThat(s.longestSubstring("abcbb", 2)).isEqualTo(2);
    assertThat(s.longestSubstring("ababacb", 3)).isEqualTo(0);
    assertThat(s.longestSubstring("bbaaacbd", 3)).isEqualTo(3);
  }

  /**
   * 180 ms	41.3 MB
   */
  public int longestSubstring(String s, int k) {
    return longestSubstring(s, 0, s.length() - 1, k);
  }

  private static int longestSubstring(String s, int left, int right, int k) {
    if (right - left + 1 < k) return 0;

    int[] counts = new int[26];
    for (int i = left; i <= right; i++) {
      counts[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < counts.length; i++) {
      int count = counts[i];
      if (0 >= count || k <= count) continue;

      for (int j = left; j <= right; j++) {
        if (s.charAt(j) == i + 'a') {
          int leftLongest = longestSubstring(s, left, j - 1, k);
          int rightLongest = longestSubstring(s, j + 1, right, k);
          return Math.max(leftLongest, rightLongest);
        }
      }
    }

    return right - left + 1;
  }
}