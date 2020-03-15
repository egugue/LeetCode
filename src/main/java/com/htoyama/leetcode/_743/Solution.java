package com.htoyama.leetcode._743;

import com.htoyama.leetcode.utils.Dijkstra;
import com.htoyama.leetcode.utils.Graph;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/
 */
@Graph
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int time;
    time = s.networkDelayTime(
      new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}},
      4,
      2
    );
    System.out.println(time);

    time = s.networkDelayTime(
      new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}},
      4,
      1
    );
    System.out.println(time);

    time = s.networkDelayTime(
      new int[][]{{1, 2, 1}},
      2,
      2
    );
    System.out.println(time);
  }

  /**
   * 13 ms	43.5 MB
   * TODO: Must try to solve later
   */
  @Dijkstra
  public int networkDelayTime(int[][] times, int N, int K) {
    if (times.length == 0) return -1;
    if (K <= 0 || K > N) return -1;

    Map<Integer, Integer>[] graph = new HashMap[N + 1];
    for (int i = 1; i < graph.length; i++) {
      graph[i] = new HashMap<>();
    }

    for (int[] time : times) {
      int source = time[0];
      int dest = time[1];
      int weight = time[2];
      graph[source].put(dest, weight);
    }

    boolean[] visited = new boolean[graph.length];
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    minHeap.add(new int[]{K, 0});

    int maxDistance = -1;
    int restNodes = N;
    while (!minHeap.isEmpty()) {
      int[] nodeAndDistance = minHeap.poll();

      int curNode = nodeAndDistance[0];
      if (visited[curNode]) continue;
      visited[curNode] = true;

      int curDistance = nodeAndDistance[1];
      maxDistance = curDistance;
      if (--restNodes == 0) break;

      Set<Map.Entry<Integer, Integer>> edges = graph[curNode].entrySet();
      for (Map.Entry<Integer, Integer> edge : edges) {
        int nextNode = edge.getKey();
        if (visited[nextNode]) continue;
        minHeap.add(new int[]{nextNode, curDistance + edge.getValue()});
      }
    }

    return restNodes == 0 ? maxDistance : -1;
  }
}
