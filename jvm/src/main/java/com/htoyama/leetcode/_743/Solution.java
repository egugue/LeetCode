package com.htoyama.leetcode._743;

import com.htoyama.leetcode.utils.Dijkstra;
import com.htoyama.leetcode.utils.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
   * 9 ms	46.2 MB
   *
   * TODO: Must try to solve later
   */
  @Dijkstra
  public int networkDelayTime(int[][] times, int N, int K) {
    if (times.length == 0) return -1;
    if (K <= 0 || K > N) return -1;

    List<int[]>[] graph = new ArrayList[N + 1];
    for (int i = 1; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] time : times) {
      int source = time[0];
      int dest = time[1];
      int weight = time[2];
      graph[source].add(new int[]{dest, weight});
    }

    boolean[] visited = new boolean[graph.length];
    PriorityQueue<int[]> minDistanceHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    minDistanceHeap.add(new int[]{K, 0});

    int maxDistance = -1;
    int restNodes = N;
    while (!minDistanceHeap.isEmpty()) {
      int[] nodeAndDistance = minDistanceHeap.poll();

      int curNode = nodeAndDistance[0];
      if (visited[curNode]) continue;
      visited[curNode] = true;

      int curDistance = nodeAndDistance[1];
      maxDistance = curDistance;
      if (--restNodes == 0) break;

      List<int[]> edges = graph[curNode];
      for (int[] edge : edges) {
        int nextNode = edge[0];
        if (visited[nextNode]) continue;
        minDistanceHeap.add(new int[]{nextNode, curDistance + edge[1]});
      }
    }

    return restNodes == 0 ? maxDistance : -1;
  }
}
