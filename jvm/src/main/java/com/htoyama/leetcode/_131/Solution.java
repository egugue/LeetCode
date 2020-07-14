package com.htoyama.leetcode._131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.partition("aab")).containsExactlyInAnyOrder(
      Arrays.asList("aa", "b"),
      Arrays.asList("a", "a", "b")
    );
    assertThat(s.partition("bb")).containsExactlyInAnyOrder(
      Arrays.asList("b", "b"),
      Arrays.asList("bb")
    );
    assertThat(s.partition("a")).containsExactlyInAnyOrder(
      Arrays.asList("a")
    );
  }

  /**
   * 5 ms	40.1 MB
   */
  public List<List<String>> partition(String s) {
    if (s.isEmpty()) return new ArrayList<>();

    ArrayList<List<String>> result = new ArrayList<>();
    if (s.length() != 1 && isPalindrome(s)) {
      result.add(new ArrayList<>());
      result.get(0).add(s);
    }

    backtrack(s, result, new ArrayList<>());
    return result;
  }

  private static void backtrack(String cur, ArrayList<List<String>> result, ArrayList<String> palindromes) {
    if (cur.length() == 1) {
      palindromes.add(cur);
      result.add(new ArrayList<>(palindromes));
      palindromes.remove(palindromes.size() - 1);
      return;
    }

    for (int partition = 1; partition < cur.length(); partition++) {
      String sub1 = cur.substring(0, partition);
      if (!isPalindrome(sub1)) continue;

      palindromes.add(sub1);

      String sub2 = cur.substring(partition);
      if (sub2.length() != 1 && isPalindrome(sub2)){
        ArrayList<String> p = new ArrayList<>(palindromes);
        p.add(sub2);
        result.add(p);
      }

      backtrack(sub2, result, palindromes);

      palindromes.remove(palindromes.size() - 1);
    }
  }

  private static boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left <= right) {
      if (str.charAt(left++) != str.charAt(right--)) return false;
    }
    return true;
  }
}