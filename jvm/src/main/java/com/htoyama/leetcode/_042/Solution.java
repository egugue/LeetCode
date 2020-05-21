package com.htoyama.leetcode._042;


import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
    assertThat(s.trap(new int[]{4, 0, 2})).isEqualTo(2);
    assertThat(s.trap(new int[]{
//      // 1  2  3  4  5  6
      4, 2, 0, 0, 1, 1
//      // 1  2  3  4  5  6  7  8  9 10 11
//       0, 1, 0, 2, 1, 0, 4, 2, 0, 0, 1, 1
    })).isEqualTo(2);
  }

  /**
   * 3 ms	39.3 MB
   */
  public int trap(int[] heights) {
    if (heights.length <= 1) return 0;

    Stack<Integer> stack = new Stack<>();
    int water = 0;
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
        int bottom = heights[stack.pop()];
        if (stack.isEmpty()) break;
        int width = i - stack.peek() - 1;
        int height = Math.min(heights[stack.peek()], heights[i]) - bottom;
        water += width * height;
      }

      if (!stack.isEmpty() &&  heights[stack.peek()] == heights[i]) {
        // replace prev index with current index
        stack.pop();
      }
      stack.push(i);
    }
    return water;
  }
}

