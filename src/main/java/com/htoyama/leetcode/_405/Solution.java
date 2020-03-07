package com.htoyama.leetcode._405;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();

    assertThat(s.toHex(0)).isEqualTo("0");
    assertThat(s.toHex(18)).isEqualTo("12");
    assertThat(s.toHex(-18)).isEqualTo("ffffffee");
    assertThat(s.toHex(-1)).isEqualTo("ffffffff");
  }

  private static char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  /**
   * TODO: Must review later
   */
  public String toHex(int num) {
    if (num == 0) return "0";

    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      sb.append(table[num & 15]);
      num = (num >>> 4);
    }

    return sb.reverse().toString();
  }
}
