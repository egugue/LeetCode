package com.htoyama.leetcode._242;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isAnagram3("abcdefghi", "abcdefghi"));
    System.out.println(s.isAnagram3("anagram", "nagaram"));
    System.out.println(s.isAnagram3("rat", "car"));
    System.out.println(s.isAnagram3("aa", "bb"));
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    char[] sChars = s.toCharArray();
    Arrays.sort(sChars);

    char[] tChars = t.toCharArray();
    Arrays.sort(tChars);

    return Arrays.equals(sChars, tChars);
  }

  /**
   * Each string has only unicode characters
   */
  public boolean isAnagram3(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] table = new int[26];

    for (int i = 0; i < s.length(); i++) {
      int sOffset = s.codePointAt(i) - 'a';
      table[sOffset]++;

      int tOffset = t.codePointAt(i) - 'a';
      table[tOffset]--;
    }

    for (int value : table) {
      if (value != 0) return false;
    }

    return true;
  }
}
