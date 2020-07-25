package com.htoyama.leetcode._202;

import java.util.HashSet;

class Solution {
  /**
   * 3 ms	38.6 MB
   */
  public boolean isHappy(int n) {
    if (n == 1) return true;
    HashSet<Integer> set = new HashSet<Integer>();
    while (!set.contains(n)) {
      if (n == 1) return true;
      set.add(n);

      int next = 0;
      while (n != 0) {
        int digit = n % 10;
        next += digit * digit;
        n /= 10;
      }
      n = next;
    }
    return false;
  }
}

