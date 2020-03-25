package com.htoyama.leetcode._684;

import com.htoyama.leetcode.utils.DFS;
import com.htoyama.leetcode.utils.Graph;
import com.htoyama.leetcode.utils.UnionFind;

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
   * 1 ms	39.4 MB
   *
   * https://www.youtube.com/watch?v=wU6udHRIkcc
   * TODO: Must try to solve with the approach later
   */
  @UnionFind
  public int[] findRedundantConnection(int[][] edges) {
    // a positive integer means a parent
    // a negative integer means the number of elements
    int[] disjointSet = new int[edges.length];
    Arrays.fill(disjointSet, -1);

    for (int[] edge : edges) {
      if (!union(edge[0] - 1, edge[1] - 1, disjointSet)) {
        return edge;
      }
    }

    throw new IllegalArgumentException();
  }

  // return false if x and y are connected.
  private boolean union(int x, int y, int[] disjointSet) {
    int parentX = findParent(x, disjointSet);
    int parentY = findParent(y, disjointSet);
    if (parentX == parentY) return false;

    int countX = -disjointSet[parentX];
    int countY = -disjointSet[parentY];
    int sum = countX + countY;
    if (countX < countY) {
      // parentY should be the parent of x
      disjointSet[parentX] = parentY;
      disjointSet[parentY] = -sum;
    } else {
      // parentX should be the parent of y
      disjointSet[parentY] = parentX;
      disjointSet[parentX] = -sum;
    }

    return true;
  }

  private int findParent(int x, int[] disjointSet) {
    int parent = x;
    int rankOrParent = disjointSet[x];
    while (rankOrParent >= 0) {
      // x has a parent
      parent = rankOrParent;
      rankOrParent = disjointSet[rankOrParent];
    }
    // found the most top parent
    return parent;
  }

  /**
   * 10 ms	41.7 MB
   * <p>
   * TODO: Must review later
   */
  @DFS
  public int[] findRedundantConnection_(int[][] edges) {
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

    for (int relayPoint : graph[from]) {
      if (canGo(relayPoint, to, graph, seen)) {
        return true;
      }
    }
    return false;
  }
}
