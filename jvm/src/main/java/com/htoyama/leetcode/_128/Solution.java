package com.htoyama.leetcode._128;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
@Level.Hard
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})).isEqualTo(4);
    assertThat(s.longestConsecutive(new int[]{1, 2, 0, 1})).isEqualTo(3);
    assertThat(s.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6})).isEqualTo(7);
  }

  /**
   * 4 ms	39.4 MB
   */
  public int longestConsecutive(int[] nums) {
    if (nums.length <= 1) return nums.length;

    HashMap<Integer, Boolean> map = new HashMap<>(nums.length);
    for (int num : nums) {
      map.put(num, false);
    }

    int longest = 0;
    for (int num : nums) {
      if (map.get(num)) continue;
      map.put(num, true);

      int cur = 1;
      int i = num;
      while(map.containsKey(++i)) {
        map.put(i, true);
        cur++;
      }

      i = num;
      while(map.containsKey(--i)) {
        map.put(i, true);
        cur++;
      }

      longest = Math.max(longest, cur);
    }

    return longest;
  }
}