package com.htoyama.leetcode._139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.wordBreak("leetcode", Arrays.asList("leet", "code"))).isTrue();
    assertThat(s.wordBreak("applepenapple", Arrays.asList("apple", "pen"))).isTrue();
    assertThat(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))).isFalse();
    assertThat(s.wordBreak("a", Arrays.asList("a"))).isTrue();
  }

  /**
   * 1 ms	37.7 MB
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s.isEmpty() || wordDict.isEmpty()) return false;

    HashSet<String> set = new HashSet<>(wordDict);
    HashSet<Integer> lengths = new HashSet<>(wordDict.size());
    for (String word : wordDict) lengths.add(word.length());

    boolean[] dp = new boolean[s.length()];
    for (int right = 0; right < s.length(); right++) {
      for (int length : lengths) {
        int left = right - length + 1;
        if (left < 0) continue;
        boolean isPrevBreakable = left - 1 < 0 || dp[left - 1];
        if (isPrevBreakable && set.contains(s.substring(left, right + 1))) {
          dp[right] = true;
          break;
        }
      }
    }

    return dp[s.length() - 1];
  }
}