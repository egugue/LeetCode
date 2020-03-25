package com.htoyama.leetcode._332;

import com.htoyama.leetcode.utils.DFS;
import com.htoyama.leetcode.utils.Graph;
import com.htoyama.leetcode.utils.Level;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
@Level.Medium
@Graph
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> r;
    r = s.findItinerary(asList(
      asList("MUC", "LHR"), asList("JFK", "MUC"), asList("SFO", "SJC"), asList("LHR", "SFO")
    ));
    System.out.println(r.toString());

    r = s.findItinerary(asList(
      asList("JFK", "SFO"), asList("JFK", "ATL"), asList("SFO", "ATL"), asList("ATL", "JFK"), asList("ATL", "SFO")
    ));
    System.out.println(r.toString());

    r = s.findItinerary(asList(
      asList("JFK", "KUL"), asList("JFK", "NRT"), asList("NRT", "JFK")
    ));
    System.out.println(r.toString());
  }

  /**
   * 5 ms	42.2 MB
   *
   * TODO: Must solve it later
   */
  @DFS
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
      String source = ticket.get(0);
      PriorityQueue<String> minDests = graph.get(source);
      if (minDests == null) {
        minDests = new PriorityQueue<>();
        graph.put(source, minDests);
      }
      minDests.add(ticket.get(1));
    }

    if (!graph.containsKey("JFK")) return Collections.emptyList();

    Stack<String> stack = new Stack<>();
    dfs("JFK", graph, stack);
    Collections.reverse(stack);
    return stack;
  }

  private void dfs(String source, Map<String, PriorityQueue<String>> graph, Stack<String> stack) {
    PriorityQueue<String> minDests;
    while ((minDests = graph.get(source)) != null && !minDests.isEmpty()) {
      dfs(minDests.poll(), graph, stack);
    }

    stack.push(source);
  }
}
