package com.htoyama.leetcode._621;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)).isEqualTo(8);
  }

  public int leastInterval(char[] tasks, int n) {
    if (tasks.length == 0) return 0;

    Map<Character, Integer> map = new HashMap<>();
    for (char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(map.size(), (o1, o2) -> o2 - o1);
    maxHeap.addAll(map.values());

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