package com.htoyama.leetcode._347;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.topKFrequent(new int[]{1}, 1));
    System.out.println(s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    System.out.println(s.topKFrequent(new int[]{9, 1, 3, 2, 9, 1, 9, 2, 9, 9, 1}, 3));
  }

  /**
   * 26 ms	47.6 MB	java
   *
   * TODO: Improve code to run faster
   */
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
      map.entrySet().size(),
      (o1, o2) -> o2.getValue() - o1.getValue()
    );
    maxHeap.addAll(entries);

    ArrayList<Integer> list = new ArrayList<>(k);
    for (int i = 0; i < k; i++) {
      list.add(maxHeap.poll().getKey());
    }

    return list;
  }
}
