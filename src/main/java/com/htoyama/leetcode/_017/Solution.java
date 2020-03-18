package com.htoyama.leetcode._017;

import com.htoyama.leetcode.utils.Backtracking;
import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.String_;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
@Level.Medium
@String_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.letterCombinations("")).isEmpty();

    assertThat(s.letterCombinations("2")).containsExactly("a", "b", "c");

    assertThat(s.letterCombinations("23")).containsExactly(
      "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
    );
  }

  private static final String[][] table = {
    {},
    {},
    {"a", "b", "c"},
    {"d", "e", "f"},
    {"g", "h", "i"},
    {"j", "k", "l"},
    {"m", "n", "o"},
    {"p", "q", "r", "s"},
    {"t", "u", "v"},
    {"w", "x", "y", "z"},
  };

  /**
   * 0 ms	38.3 MB
   *
   * TODO: Must solve later
   */
  public List<String> letterCombinations_(String digits) {
    if (digits.length() == 0) return Collections.emptyList();

    char[] chars = digits.toCharArray();
    LinkedList<String> combinations = new LinkedList<>();
    combinations.add("");

    for (char ch : chars) {
      String[] nextStrings = table[ch - '0'];
      int size = combinations.size();

      for (int i = 0; i < size; i++) {
        String original = combinations.poll();
        for (String nextString : nextStrings) {
          combinations.add(original + nextString);
        }
      }

    }

    return combinations;
  }

  /**
   * 0 ms	38.3 MB
   */
  @Backtracking
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return Collections.emptyList();

    List<String> combination = new ArrayList<>();
    backtrack(0, digits.toCharArray(), new StringBuilder(digits.length()), combination);
    return combination;
  }

  private void backtrack(int i, char[] chars, StringBuilder sb, List<String> combination) {
    if (sb.length() == chars.length) {
      combination.add(sb.toString());
      return;
    }

    String[] candidates = table[chars[i] - '0'];
    for (String candidate : candidates) {
      sb.append(candidate);
      backtrack(i + 1, chars, sb, combination);
      sb.setLength(sb.length() - 1);
    }
  }
}
