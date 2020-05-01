package com.htoyama.leetcode._438;

import com.htoyama.leetcode.utils.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
@Level.Medium
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.findAnagrams("cbaebabacd", "abc")).contains(
      0, 6
    );
  }

  /**
   * 39 ms	40.7 MB
   *
   * TODO: too slow
   */
  public List<Integer> findAnagrams(String s, String p) {
    if (s.length() < p.length()) return Collections.emptyList();
    HashMap<Character, Integer> pMap = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
    }

    HashMap<Character, Integer> sMap = new HashMap<>();
    for (int i = 0; i < p.length() - 1; i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    List<Integer> anagrams = new ArrayList<>();
    for (int i = p.length() - 1; i < s.length(); i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
      int start = i - p.length() + 1;
      if (sMap.equals(pMap)) {
        anagrams.add(start);
      }

      int count = sMap.get(s.charAt(start)) - 1;
      if (count == 0) {
        sMap.remove(s.charAt(start));
      } else {
        sMap.put(s.charAt(start), count);
      }
    }

    return anagrams;
  }
}