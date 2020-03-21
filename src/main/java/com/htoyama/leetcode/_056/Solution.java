package com.htoyama.leetcode._056;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] r;

    r = s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    for (int[] ints : r) {
      System.out.println(Arrays.toString(ints));
    }

    r = s.merge(new int[][]{{1, 4}, {1, 5}});
    for (int[] ints : r) {
      System.out.println(Arrays.toString(ints));
    }

    r = s.merge(new int[][]{{1, 4}});
    for (int[] ints : r) {
      System.out.println(Arrays.toString(ints));
    }

    r = s.merge(new int[][]{{1, 4}, {2, 3}});
    for (int[] ints : r) {
      System.out.println(Arrays.toString(ints));
    }
  }

  private static Comparator<int[]> startAscOrder = (o1, o2) -> o1[0] - o2[0];

  /**
   * 5 ms	42.2 MB
   */
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) return new int[0][0];
    Arrays.sort(intervals, startAscOrder);

    ArrayList<int[]> merged = new ArrayList<>();
    merged.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] curr = intervals[i];
      int[] last = merged.get(merged.size() - 1);
      if (curr[0] <= last[1]) {
        if (last[1] <= curr[1]) {
          last[1] = curr[1];
        }
      } else {
        merged.add(curr);
      }
    }

    int[][] result = new int[merged.size()][2];
    for (int i = 0; i < merged.size(); i++) {
      result[i] = merged.get(i);
    }
    return result;
  }
}
