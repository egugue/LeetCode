package com.htoyama.leetcode._990;

import com.htoyama.leetcode.utils.UnionFind;

import java.util.Arrays;

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
  public boolean equationsPossible(String[] equations) {
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
}
