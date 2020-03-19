package com.htoyama.leetcode._075;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.Sort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/sort-colors/
 */
@Level.Medium
@Array_
@Sort
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] ints;

    ints = new int[]{2, 0, 2, 1, 1, 0};
    s.sortColors(ints);
    System.out.println(Arrays.toString(ints));
    assertThat(ints).containsExactly(0, 0, 1, 1, 2, 2);

    ints = new int[]{2, 0};
    s.sortColors(ints);
    System.out.println(Arrays.toString(ints));
    assertThat(ints).containsExactly(0, 2);

    ints = new int[]{0, 0};
    s.sortColors(ints);
    System.out.println(Arrays.toString(ints));
    assertThat(ints).containsExactly(0, 0);

    ints = new int[]{2, 0, 1};
    s.sortColors(ints);
    System.out.println(Arrays.toString(ints));
    assertThat(ints).containsExactly(0, 1, 2);
  }

  /**
   * 0 ms	38.2 MB
   */
  public void sortColors_(int[] nums) {
    if (nums.length <= 1) return;

    int firstNonZeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        nums[i] = nums[firstNonZeroIndex];
        nums[firstNonZeroIndex++] = 0;
      }
    }

    int firstTwoIndex = firstNonZeroIndex;
    for (int i = firstNonZeroIndex; i < nums.length; i++) {
      if (nums[i] == 1) {
        nums[firstTwoIndex++] = 1;
      }
    }
    for (int i = firstTwoIndex; i < nums.length; i++) {
      nums[i] = 2;
    }
  }

  /**
   * 0 ms	38.3 MB
   *
   * TODO: Must try later with this one-shot algorithm
   */
  public void sortColors(int[] nums) {
    if (nums.length <= 1) return;

    int firstNonZeroIndex = 0;
    int lastNonTwoIndex = nums.length - 1;
    int i = 0;
    while (i <= lastNonTwoIndex) {
      switch (nums[i]) {
        case 0:
          nums[i++] = nums[firstNonZeroIndex];
          nums[firstNonZeroIndex++] = 0;
          break;
        case 2:
          nums[i] = nums[lastNonTwoIndex];
          nums[lastNonTwoIndex--] = 2;
          break;
        default:
          i++;
      }
    }
  }
}
