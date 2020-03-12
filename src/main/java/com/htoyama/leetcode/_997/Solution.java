package com.htoyama.leetcode._997;

import com.htoyama.leetcode.utils.Graph;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
@Graph
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findJudge(2, new int[][]{{1, 2}}));
    System.out.println(s.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
    System.out.println(s.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    System.out.println(s.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
  }

  /**
   * 2 ms	48.8 MB
   */
  public int findJudge(int N, int[][] trust) {
    boolean[] hasTrusted = new boolean[N + 1];
    int[] trustedCount = new int[N + 1];

    for (int[] ints : trust) {
      hasTrusted[ints[0]] = true;
      trustedCount[ints[1]]++;
    }

    // label starts from 1 so that 0 should be skipped
    for (int i = 1; i <= N; i++) {
      if (!hasTrusted[i] && trustedCount[i] == N - 1) {
        return i;
      }
    }

    return -1;
  }
}

