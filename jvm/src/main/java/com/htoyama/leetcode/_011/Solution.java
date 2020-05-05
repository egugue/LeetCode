package com.htoyama.leetcode._011;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
@Level.Medium
@Array_
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7})).isEqualTo(49);
  }

  /**
   * 2 ms	39.7 MB
   */
  public int maxArea(int[] height) {
    if(height.length <= 1) return 0;

    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left != right) {
      int area = (right - left) *  Math.min(height[left], height[right]);
      max = Math.max(max, area);

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
