package com.htoyama.leetcode._179;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.largestNumber(new int[]{10, 2})).isEqualTo("210");
    assertThat(s.largestNumber(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
    assertThat(s.largestNumber(new int[]{3, 30, 34, 5, 9, 100})).isEqualTo("9534330100");
    assertThat(s.largestNumber(new int[]{121, 12})).isEqualTo("12121");
    assertThat(s.largestNumber(new int[]{0, 0})).isEqualTo("0");
  }

  /**
   * 9 ms	41.1 MB
   */
  public String largestNumber(int[] nums) {
    if (nums.length == 0) return "";

    String[] strings = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strings[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    if (strings[0].equals("0")) return "0";

    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      sb.append(string);
    }
    return sb.toString();
  }
}