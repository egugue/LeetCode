package com.htoyama.leetcode._684;

import com.htoyama.leetcode.utils.DFS;
import com.htoyama.leetcode.utils.Graph;

import java.util.ArrayList;
import java.util.Arrays;

@Graph
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(
      s.findRedundantConnection(new int[][]{
        {1, 2}, {1, 3}, {2, 3}
      })
    ));
    System.out.println(Arrays.toString(
      s.findRedundantConnection(new int[][]{
        {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
      })
    ));
    System.out.println(Arrays.toString(
      s.findRedundantConnection(new int[][]{
        {3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}
      })
    ));
  }

  /**
   * 10 ms	41.7 MB
   *
   * TODO: Must review later
   */
  @DFS
  public int[] findRedundantConnection(int[][] edges) {
    boolean[] seen = new boolean[edges.length + 1];

    ArrayList<Integer>[] graph = new ArrayList[edges.length + 1];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      Arrays.fill(seen, false);
      int from = edge[0];
      int to = edge[1];

      if (!graph[from].isEmpty() && !graph[to].isEmpty() && canGo(from, to, graph, seen)) {
        return edge;
      }
      graph[from].add(to);
      graph[to].add(from);
    }

    throw new IllegalArgumentException();
  }

  private boolean canGo(int from, int to, ArrayList<Integer>[] graph, boolean[] seen) {
    if (seen[from]) return false;
    seen[from] = true;

    if (from == to) return true;

    for(int relayPoint: graph[from]) {
      if (canGo(relayPoint, to, graph, seen)) {
        return true;
      }
    }
    return false;
  }
}
