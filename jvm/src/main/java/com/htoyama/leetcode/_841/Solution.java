package com.htoyama.leetcode._841;

import com.htoyama.leetcode.utils.DFS;
import com.htoyama.leetcode.utils.Graph;

import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 */
@Graph
class Solution {

  @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(
      s.canVisitAllRooms_rec(asList(
        asList(1),
        asList(2),
        asList(3),
        asList())
      )
    );

    System.out.println(
      s.canVisitAllRooms_rec(asList(
        asList(1, 3),
        asList(3, 0, 1),
        asList(2),
        asList(0))
      )
    );
  }

  /**
   * 2 ms	41 MB
   */
  @DFS
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    if (rooms == null || rooms.isEmpty()) return false;

    boolean[] seen = new boolean[rooms.size()];
    seen[0] = true;
    Stack<Integer> stack = new Stack<>();
    stack.add(0);

    while (!stack.isEmpty()) {
      int room = stack.pop();
      for (int visitableRoom : rooms.get(room)) {
        if (seen[visitableRoom]) continue;
        seen[visitableRoom] = true;
        stack.add(visitableRoom);
      }
    }

    for (boolean canVisit : seen) {
      if (!canVisit) return false;
    }
    return true;
  }

  /**
   * 0 ms	41.1 MB
   */
  @DFS
  public boolean canVisitAllRooms_rec(List<List<Integer>> rooms) {
    if (rooms == null || rooms.isEmpty()) return false;

    boolean[] seen = new boolean[rooms.size()];
    dfs(0, rooms, seen);

    for (boolean canVisit : seen) {
      if (!canVisit) return false;
    }
    return true;
  }

  private void dfs(int room, List<List<Integer>> rooms, boolean[] seen) {
    seen[room] = true;

    for (int visitableRoom : rooms.get(room)) {
      if (seen[visitableRoom]) continue;
      dfs(visitableRoom, rooms, seen);
    }
  }
}