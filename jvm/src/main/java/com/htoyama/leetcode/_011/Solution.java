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
    //assertThat(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
    assertThat(s.maxArea(new int[]{5, 8, 6, 2, 5, 4, 8, 1, 5})).isEqualTo(40);
  }

  /**
   * 1 ms	39.6 MB
   */
  public int maxArea(int[] height) {
    if (height.length <= 1) return 0;

    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    while (left != right) {
      int minHeight = Math.min(height[left], height[right]);
      int area = (right - left) * minHeight;
      maxArea = Math.max(maxArea, area);

      while(height[left] <= minHeight && left != right) left++;
      while(height[right] <= minHeight && left != right) right--;

      // the code below takes more time than above if height[left] == height[right]
      // because in such case, left also needs to increment but left will increment in the next loop
//      if (height[left] < height[right]) {
//        int h = height[left];
//        while(++left != right && h > height[left]);
//      } else {
//        int h = height[right];
//        while(--right != left && h > height[right]);
//      }
    }

    return maxArea;
  }
}
