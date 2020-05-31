package com.htoyama.leetcode._239;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
      .containsExactly(3, 3, 5, 5, 6, 7);
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    return queue(nums, k);
//    return heap(nums, k);
  }

  /**
   * 11 ms	53.3 MB
   */
  public static int[] queue(int[] nums, int k) {
    if (nums.length == 0) return new int[0];

    // Max capacity equals k because first while statement in the for loop makes the queue remove index out of sliding window.
    ArrayDeque<Integer> queue = new ArrayDeque<>(k);
    int[] windows = new int[nums.length - k + 1];

    for (int right = 0; right < nums.length; right++) {
      int left = right - k + 1;
      while (!queue.isEmpty() && queue.peek() < left) queue.remove();
      while (!queue.isEmpty() && nums[queue.getLast()] < nums[right]) queue.removeLast();

      if (left >= 0) {
        windows[left] = queue.isEmpty() ? nums[right] : nums[queue.peek()];
      }
      queue.add(right);
    }

    return windows;
  }

  private static final Comparator<int[]> maxComparator = (o1, o2) -> o2[1] - o1[1];

  /**
   * 14 ms	51.4 MB
   */
  public static int[] heap(int[] nums, int k) {
    if (nums.length == 0) return new int[0];
    int[] windows = new int[nums.length - k + 1];
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(maxComparator);
    for (int i = 0; i < k - 1; i++) maxHeap.add(new int[]{i, nums[i]});

    for (int right = k - 1; right < nums.length; right++) {
      maxHeap.add(new int[]{right, nums[right]});

      int left = right - k + 1;
      while (!maxHeap.isEmpty() && maxHeap.peek()[0] < left) {
        maxHeap.remove();
      }
      int[] max = maxHeap.peek();
      windows[left] = max[1];
    }

    return windows;
  }
}