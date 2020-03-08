package com.htoyama.leetcode._412;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> fz = s.fizzBuzz(15);
    for (String str : fz) {
      System.out.println(str);
    }
  }

  /**
   * 2 ms	45.9 MB
   */
  public List<String> fizzBuzz(int n) {
    List<String> container = new ArrayList<>(n);

    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) {
        container.add("FizzBuzz");
      } else if (i % 3 == 0) {
        container.add("Fizz");
      } else if (i % 5 == 0) {
        container.add("Buzz");
      } else {
        container.add(Integer.toString(i));
      }
    }

    return container;
  }
}
