package com.htoyama.leetcode._990;

import com.htoyama.leetcode.utils.DFS;
import com.htoyama.leetcode.utils.Graph;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
@Level.Medium
@Graph
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.equationsPossible(new String[]{"a==b", "b!=a"}));
    System.out.println(s.equationsPossible(new String[]{"b==a", "a==b"}));
    System.out.println(s.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
    System.out.println(s.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
    System.out.println(s.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
  }

  /**
   * 0 ms	38.3 MB
   */
  @UnionFind
  public boolean equationsPossible_US(String[] equations) {
    int[] disjointSet = new int[26];
    Arrays.fill(disjointSet, -1);

    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        union(equation.charAt(0) - 'a', equation.charAt(3) - 'a', disjointSet);
      }
    }

    for (String equation : equations) {
      if (equation.charAt(1) == '!') {
        int x = equation.charAt(0) - 'a';
        int y = equation.charAt(3) - 'a';
        if (findParent(x, disjointSet) == findParent(y, disjointSet)) {
          return false;
        }
      }
    }

    return true;
  }

  private void union(int x, int y, int[] set) {
    int parentX = findParent(x, set);
    int parentY = findParent(y, set);
    if (parentX == parentY) return;

    int numOfElementsX = -set[parentX];
    int numOfElementsY = -set[parentY];
    int sum = numOfElementsX + numOfElementsY;
    if (numOfElementsX < numOfElementsY) {
      set[parentX] = parentY;
      set[parentY] = -sum;
    } else {
      set[parentY] = parentX;
      set[parentX] = -sum;
    }
  }

  private int findParent(int i, int[] set) {
    int parent = i;
    int parentOrElementCount = set[parent];
    while (parentOrElementCount >= 0) {
      parent = parentOrElementCount;
      parentOrElementCount = set[parent];
    }
    return parent;
  }

  /**
   * 1 ms	38.7 MB
   * <p>
   * TODO: Must try to solve using DFS later
   */
  @DFS
  public boolean equationsPossible(String[] equations) {
    List<Integer>[] graph = new ArrayList[26];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        int x = equation.charAt(0) - 'a';
        int y = equation.charAt(3) - 'a';
        graph[x].add(y);
        graph[y].add(x);
      }
    }

    int[] colors = new int[26];
    int curColor = 1;
    for (int i = 0; i < colors.length; i++) {
      colorNode(i, curColor++, colors, graph);
    }

    for (String equation : equations) {
      if (equation.charAt(1) == '!') {
        int x = equation.charAt(0) - 'a';
        int y = equation.charAt(3) - 'a';
        if (colors[x] == colors[y]) {
          return false;
        }
      }
    }

    return true;
  }

  private void colorNode(int node, int currColor, int[] colors, List<Integer>[] graph) {
    if (colors[node] != 0) return;
    colors[node] = currColor;

    List<Integer> neighbors = graph[node];
    for (int neighbor : neighbors) {
      if (colors[neighbor] != 0) continue;
      colorNode(neighbor, currColor, colors, graph);
    }
  }
}
