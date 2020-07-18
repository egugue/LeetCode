package com.htoyama.leetcode._127;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat((s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")))).isEqualTo(5);
    assertThat((s.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")))).isEqualTo(0);
  }

  /**
   * 867 ms	41.5 MB, but too slow
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<Integer> visited = new HashSet<>();
    ArrayDeque<String> queue = new ArrayDeque<>();
    queue.add(beginWord);

    int path = 0;
    while (!queue.isEmpty()) {
      path++;
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String intermediate = queue.poll();

        for (int j = 0; j < wordList.size(); j++) {
          if (visited.contains(j)) continue;

          String word = wordList.get(j);
          if (isOnlyOneLetterDifferent(intermediate, word)) {
            if (word.equals(endWord)) {
              return path + 1;
            }
            queue.add(word);
            visited.add(j);
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