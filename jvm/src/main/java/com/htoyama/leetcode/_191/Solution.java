package com.htoyama.leetcode._191;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.hammingWeight(11)).isEqualTo(3);
    assertThat(s.hammingWeight(-3)).isEqualTo(31);
    assertThat(s.hammingWeight(-2147483648)).isEqualTo(1);
  }

  /**
   * 1 ms	36.9 MB
   */
  public int hammingWeight(int n) {
    if (n == 0) return 0;

    if (n > 0) {
      int count = 0;
      while (n != 0) {
        if ((n & 1) == 1) count++;
        n >>= 1;
      }
      return count;
    }

    n = ~n;
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) count++;
      n >>= 1;
    }
    return 32 - count; // 1 is highest one bit
  }
}