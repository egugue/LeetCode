package com.htoyama.leetcode._140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")))
      .containsExactlyInAnyOrder(
        "cats and dog",
        "cat sand dog"
      );

    assertThat(s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")))
      .containsExactlyInAnyOrder(
        "pine apple pen apple",
        "pineapple pen apple",
        "pine applepen apple"
      );

    assertThat(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")))
      .containsExactlyInAnyOrder();
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    return using_bt(s, wordDict);
  }

  /**
   * Time Limit Exceeded
   */
  private static List<String> using_bt(String s, List<String> wordDict) {
    HashSet<String> wordSet = new HashSet<>(wordDict);
    HashSet<Integer> lengths = new HashSet<>();
    for (String word : wordDict) lengths.add(word.length());

    ArrayList<String> result = new ArrayList<>();
    helper(s, wordSet, lengths, new StringBuilder(), 0, result);
    return result;
  }

  private static void helper(
    String s,
    HashSet<String> wordSet,
    HashSet<Integer> lengths,
    StringBuilder sb,
    int left,
    List<String> result
  ) {
    if (left > s.length()) return;
    if (left == s.length()) {
      result.add(sb.toString());
      return;
    }

    for (int length : lengths) {
      int right = left + length - 1;
      if (right >= s.length()) continue;

      String substring = s.substring(left, right + 1);
      if (!wordSet.contains(substring)) continue;

      String added = sb.length() == 0 ? substring : ' ' + substring;
      sb.append(added);
      helper(s, wordSet, lengths, sb, right + 1, result);
      sb.setLength(sb.length() - added.length());
    }
  }
}