package com.htoyama.leetcode._215;

import com.htoyama.leetcode.utils.Array_;
import com.htoyama.leetcode.utils.Level;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 215. Kth Largest Element in an Array
 */
@Level.Medium
@Array_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
    assertThat(s.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
    assertThat(s.findKthLargest(new int[]{3, 3, 3, 3, 1, 2}, 4)).isEqualTo(3);
  }

  /**
   * 2 ms	41.3 MB
   */
  public int findKthLargest_(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  /**
   * 4 ms	40.9 MB
   */
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.poll();
  }
}
