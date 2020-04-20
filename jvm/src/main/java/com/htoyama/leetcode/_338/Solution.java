package com.htoyama.leetcode._338;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.BitManipulation;
import com.htoyama.leetcode.utils.DynamicProgramming;
import com.htoyama.leetcode.utils.Level;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/counting-bits/
 */
@Level.Medium
@Array_
@BitManipulation
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.countBits(0)).containsExactly(0);
    assertThat(s.countBits(1)).containsExactly(0, 1);
    assertThat(s.countBits(2)).containsExactly(0, 1, 1);
    assertThat(s.countBits(5)).containsExactly(0, 1, 1, 2, 1, 2);
    assertThat(s.countBits(8)).containsExactly(0, 1, 1, 2, 1, 2, 2, 3, 1);
  }

  /**
   * 1 ms	43 MB
   */
  @DynamicProgramming
  public int[] countBits(int num) {
    if (num == 0) return new int[]{0};

    int[] res = new int[num + 1];
    res[0] = 0;
    res[1] = 1;

    for (int i = 2; i <= num; i *= 2) {
      res[i] = 1;
      int limit = i * 2 <= num ? i * 2 : num + 1;
      for (int j = i + 1; j < limit; j++) {
        res[j] = 1 + res[j - i];
      }
    }

    return res;
  }
}