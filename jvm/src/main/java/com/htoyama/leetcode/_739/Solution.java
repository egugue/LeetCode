package com.htoyama.leetcode._739;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).containsExactly(
      1, 1, 4, 2, 1, 1, 0, 0
    );
  }

  /**
   * 13 ms	47.4 MB
   */
  public int[] dailyTemperatures(int[] T) {
    if (T.length == 0) return new int[T.length];

    int[] res = new int[T.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < T.length; i++) {
      int cur = T[i];
      while(!stack.isEmpty() && T[stack.peek()] < cur) {
        int j = stack.pop();
        res[j] = i - j;
      }
      stack.push(i);
    }

    return res;
  }
}