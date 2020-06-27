package com.htoyama.leetcode._210;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findOrder(4, new int[][]{
      new int[]{1, 0},
      new int[]{2, 0},
      new int[]{3, 1},
      new int[]{3, 2}
    })).containsExactly(0, 1, 2, 3);

    assertThat(s.findOrder(4, new int[][]{
      new int[]{0, 1},
      new int[]{1, 0},
    })).isEmpty();

    assertThat(s.findOrder(3, new int[][]{
      new int[]{0, 1},
      new int[]{0, 2},
      new int[]{1, 2},
    })).containsExactly(2, 1, 0);
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    return bfs(numCourses, prerequisites);
  }

  /**
   * 26 ms	40.1 MB
   */
  private static int[] bfs(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) return new int[0];

    int[] indegree = new int[numCourses];
    for (int[] p : prerequisites) {
      indegree[p[0]]++;
    }

    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int[] order = new int[numCourses];
    int index = 0;
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        order[index++] = i;
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int visited = queue.poll();
      for (int[] p : prerequisites) {
        int node = p[0];
        int prerequisite = p[1];
        if (prerequisite == visited) {
          indegree[node]--;
          if (indegree[node] == 0) {
            order[index++] = node;
            queue.offer(node);
          }
        }
      }
    }

    return index == numCourses ? order : new int[0];
  }
}