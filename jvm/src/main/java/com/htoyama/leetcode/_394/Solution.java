package com.htoyama.leetcode._394;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.String_;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/decode-string/
 */
@Level.Medium
@String_
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    assertThat(s.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
    assertThat(s.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");

    StringBuilder e1 = new StringBuilder();
    for (int i = 0; i < 100; i++) e1.append("leetcode");
    assertThat(s.decodeString("100[leetcode]")).isEqualTo(e1.toString());
  }

  /**
   * 0 ms	37.4 MB
   */
  public String decodeString(String s) {
    if (s == null || s.isEmpty()) return s;

    StringBuilder sb = new StringBuilder(s);
    Stack<Integer> stack = new Stack<>();

    int i = 0;
    while (i < sb.length()) {
      char c = sb.charAt(i);
      if ('0' <= c && c <= '9') {
        stack.push(i);
        while(sb.charAt(++i) != '['){}
        i++;
        continue;
      }

      if (c == ']') {
        int numStartI = stack.pop();
        int numI = numStartI;
        int repeat = 0;
        while(sb.charAt(numI) != '[') {
          repeat = repeat * 10 + sb.charAt(numI++) - '0';
        }

        String sub = sb.substring(numI + 1, i); // numI = '['
        StringBuilder repeated = new StringBuilder(sub.length() * repeat);
        for (int j = 0; j < repeat; j++) repeated.append(sub);

        sb.replace(numStartI, i + 1, repeated.toString());
        i = numStartI + repeated.length();
        continue;
      }

      i++;
    }

    return sb.toString();
  }
}