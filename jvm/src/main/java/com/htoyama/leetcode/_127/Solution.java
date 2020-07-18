package com.htoyama.leetcode._127;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat((s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")))).isEqualTo(5);
    assertThat((s.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")))).isEqualTo(0);
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> visited = new HashSet<>();
    ArrayDeque<String> queue = new ArrayDeque<>();
    queue.add(beginWord);

    int path = 0;
    while (!queue.isEmpty()) {
      path++;
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String intermediate = queue.poll();
        visited.add(intermediate);

        for (String word : wordList) {
          if (visited.contains(word)) continue;

          if (isOnlyOneLetterDifferent(intermediate, word)) {
            if (word.equals(endWord)) {
              return path + 1;
            }
            queue.add(word);
          }
        }
      }

    }

    return 0;
  }

  private static boolean isOnlyOneLetterDifferent(String a, String b) {
    boolean isOnlyOneLetterDifferent = false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        if (isOnlyOneLetterDifferent) return false;
        isOnlyOneLetterDifferent = true;
      }
    }
    return isOnlyOneLetterDifferent;
  }
}