package com.htoyama.leetcode._399;

import com.htoyama.leetcode.utils.DFS;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    double[] r = s.calcEquation(
      asList(asList("a", "b"), asList("b", "c")),
      new double[]{2.0, 3.0},
      asList(
       asList("a", "c")
       ,asList("b", "a")
       ,asList("a", "e")
       ,asList("a", "a")
       ,asList("x", "x")
      )
    );
    System.out.println(Arrays.toString(r));
  }

  /**
   * 0 ms	38.3 MB
   *
   * TODO: Must review later
   */
  @DFS
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      String from = equations.get(i).get(0);
      String to = equations.get(i).get(1);
      double value = values[i];

      get(graph, from).put(to, value);
      get(graph, to).put(from, 1 / value);
    }

    double[] results = new double[queries.size()];
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      seen.clear();
      String from = query.get(0);
      String to = query.get(1);
      results[i] = dfs(from, to, seen, graph);
    }

    return results;
  }

  private double dfs(
    String from,
    String to,
    Set<String> visited,
    Map<String, Map<String, Double>> graph
  ) {
    Map<String, Double> edges = graph.get(from);
    if (edges == null) {
      return -1.0; //  If the answer does not exist, return -1.0
    }
    if (edges.containsKey(to)) {
      return edges.get(to);
    }

    visited.add(from);
    for (Map.Entry<String, Double> edge : edges.entrySet()) {
      if (visited.contains(edge.getKey())) continue;
      double value = dfs(edge.getKey(), to, visited, graph);
      if (value != -1.0) {
        return value * edge.getValue();
      }
    }

    return -1.0;
  }

  private Map<String, Double> get(Map<String, Map<String, Double>> graph, String key) {
    Map<String, Double> edges = graph.get(key);
    if (edges == null) {
      edges = new HashMap<>();
      graph.put(key, edges);
    }
    return edges;
  }
}

