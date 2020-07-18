package com.htoyama.leetcode._076;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
  }

  /**
   * 25 ms	48.1 MB
   */
  public String minWindow(String s, String t) {
    if (s.isEmpty() || t.isEmpty()) return "";

    HashMap<Character, Integer> charCounter = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char key = t.charAt(i);
      charCounter.put(key, charCounter.getOrDefault(key, 0) + 1);
    }

    int counter = charCounter.size();
    int left = 0;
    int right = 0;
    String minWindow = null;
    while (right < s.length()) {
      char ch = s.charAt(right);
      if (charCounter.containsKey(ch)) {
        int prev = charCounter.put(ch, charCounter.get(ch) - 1);
        if (prev == 1) counter--;
      }

      while (counter == 0 && left <= right) {
        if (minWindow == null || minWindow.length() > right - left + 1) {
          minWindow = s.substring(left, right + 1);
        }

        ch = s.charAt(left);
        if (charCounter.containsKey(ch)) {
          int prev = charCounter.put(ch, charCounter.get(ch) + 1);
          if (prev == 0) counter++;
        }
        left++;
      }

      right++;
    }

    return minWindow == null ? "" : minWindow;
  }
}