package com.htoyama.leetcode._415;

/**
 * https://leetcode.com/problems/add-strings/
 */
class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.addStrings(
      "9999",
      "123"));
    System.out.println(s.addStrings(
      "0",
      "123"));
  }

  /**
   * 4 ms	39.9 MB
   */
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;

    while (i >= 0 || j >= 0) {
      int sum = carry
        + (i >= 0 ? num1.charAt(i--) - '0' : 0)
        + (j >= 0 ? num2.charAt(j--) - '0' : 0);
      sb.append(sum % 10);
      carry = sum / 10;
    }

    if (carry != 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }
}
