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

    boolean isNegative = n < 0;
    if (isNegative) n = ~n;

    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) count++;
      n >>= 1;
    }

    return isNegative ? 32 - count : count;
  }
}