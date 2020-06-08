package com.htoyama.leetcode._621;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)).isEqualTo(8);
  }

  /**
   * 22 ms	40.4 MB in case using int array
   * 30 ms	40.6 MB in case using HashMap
   */
  public int leastInterval(char[] tasks, int n) {
    if (tasks.length == 0) return 0;

    int[] map = new int[26];
    for (char task : tasks) map[task - 'A']++;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(map.length, (o1, o2) -> o2 - o1);
    for (int i : map) {
      if (i > 0) maxHeap.add(i);
    }

    int total = 0;
    while (!maxHeap.isEmpty()) {
      int consumedInterval = 0;
      ArrayList<Integer> availableTaskNums = new ArrayList<>();

      while (consumedInterval <= n) {
        if (!maxHeap.isEmpty()) {
          int taskNum = maxHeap.poll();
          if (--taskNum > 0) availableTaskNums.add(taskNum);
        }
        consumedInterval++;

        if (maxHeap.isEmpty() && availableTaskNums.isEmpty()) {
          // no available tasks
          return total + consumedInterval;
        }
      }

      maxHeap.addAll(availableTaskNums);
      total += consumedInterval;
    }

    throw new IllegalStateException();
  }
}