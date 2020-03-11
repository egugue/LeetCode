package com.htoyama.leetcode._461;

import com.htoyama.leetcode.utils.BitManipulation;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.hammingDistance(1, 4));
    System.out.println(s.hammingDistance(1, 8));
    System.out.println(s.hammingDistance(3, 1));
  }

  /**
   * 0 ms	36.5 MB
   */
  @BitManipulation
  public int hammingDistance(int x, int y) {
    int differentBits = x ^ y;
    int count = 0;

    while (differentBits != 0) { // x and y are positive integers.
      count += differentBits & 1;
      differentBits >>= 1;
    }

    return count;
  }
}
