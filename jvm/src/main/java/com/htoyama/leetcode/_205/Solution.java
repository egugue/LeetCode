package com.htoyama.leetcode._205;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.String_;

import java.util.HashMap;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@Level.Easy
@String_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isIsomorphic("egg", "add")).isTrue();
    assertThat(s.isIsomorphic("foo", "bar")).isFalse();
    assertThat(s.isIsomorphic("paper", "title")).isTrue();
  }

  /**
   * 9 ms	41.6 MB
   */
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> sMap = new HashMap<>();
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      Integer prevS = sMap.putIfAbsent(sChar, i);
      Integer prevT = tMap.putIfAbsent(tChar, i);
      if (!Objects.equals(prevS, prevT)) return false;
    }
    return true;
  }
}