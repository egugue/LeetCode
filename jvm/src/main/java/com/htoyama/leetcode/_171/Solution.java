package com.htoyama.leetcode._171;


class Solution {
  /**
   * 1 ms	38 MB
   */
  public int titleToNumber(String s) {
    if (s.isEmpty()) return 0;
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      int value = s.charAt(i) - 'A' + 1;
      sum = sum * 26 + value;
    }
    return sum;
  }
}
