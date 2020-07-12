package com.htoyama.leetcode._072;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.minDistance("horse", "ros")).isEqualTo(3);
    assertThat(s.minDistance("intention", "execution")).isEqualTo(5);
  }

  /**
   * 13 ms	39.8 MB
   */
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
    for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

    for (int i = 0; i < word1.length(); i++) {
      for (int j = 0; j < word2.length(); j++) {
        if (word1.charAt(i) == word2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          int replace = dp[i][j];
          int insert = dp[i + 1][j];
          int delete = dp[i][j + 1];
          int min = Math.min(replace, Math.min(delete, insert));
          dp[i + 1][j + 1] = min + 1;
        }
      }
    }

    return dp[word1.length()][word2.length()];
  }
}