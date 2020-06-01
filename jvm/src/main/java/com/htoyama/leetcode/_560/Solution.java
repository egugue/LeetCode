package com.htoyama.leetcode._560;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
//    assertThat(s.subarraySum(new int[]{1, 1, 1}, 2)).isEqualTo(2);
    assertThat(s.subarraySum(new int[]{3, 4, -4, 0, 3}, 3)).isEqualTo(4);
  }

  public int subarraySum(int[] nums, int k) {
//   return cumulativeSum(nums, k);
    return hashMap(nums, k);
  }

  /**
   * 549 ms	41 MB
   */
  private static int cumulativeSum(int [] nums, int k) {
    if (nums.length == 0) return 0;

    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
    }

    int count = 0;
    for (int start = -1; start < nums.length; start++) {
      for (int end = start + 1; end < nums.length; end++) {
        int sv = start == -1 ? 0 : nums[start];
        if (nums[end] - sv == k)
          count++;
      }
    }

    return count;
  }

  /**
   * 13 ms	40.7 MB
   */
  private static int hashMap(int[] nums, int k) {
    if (nums.length == 0) return 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int sum = 0;
    int count = 0;
    for (int num : nums) {
      sum += num;
      count += map.getOrDefault(sum - k, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
  }
}