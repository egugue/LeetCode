package com.htoyama.leetcode._406;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] ints = s.reconstructQueue(new int[][]{
      new int[]{7, 0},
      new int[]{4, 4},
      new int[]{7, 1},
      new int[]{5, 0},
      new int[]{6, 1},
      new int[]{5, 2}
    });
    assertThat(ints).containsExactly(
      new int[]{5, 0}, new int[]{7, 0}, new int[]{5, 2}, new int[]{6, 1}, new int[]{4, 4}, new int[]{7, 1}
    );
  }

  /**
   * 6 ms	40.5 MB
   */
  public int[][] reconstructQueue(int[][] people) {
    if (people.length == 0) return people;
    Arrays.sort(people, (o1, o2) -> {
      int h = o2[0] - o1[0];
      if (h != 0) return h;
      return o1[1] - o2[1];
    });

    ArrayList<int[]> queue = new ArrayList<>(people.length);

    for (int[] person : people) {
      int frontNum = person[1];
      queue.add(frontNum, person);
    }

    return queue.toArray(new int[people.length][2]);
  }
}