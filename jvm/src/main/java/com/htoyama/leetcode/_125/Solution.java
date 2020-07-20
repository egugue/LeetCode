package com.htoyama.leetcode._125;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
    assertThat(s.isPalindrome("race a car")).isFalse();
  }

  /**
   * 3 ms	39.5 MB
   */
  public boolean isPalindrome(String s) {
    if (s.isEmpty()) return true;

    int left = 0;
    int right = s.length() - 1;
    while(left <= right) {
      char leftChar = s.charAt(left);
      if (!Character.isLetterOrDigit(leftChar)) {
        left++;
        continue;
      }
      char rightChar = s.charAt(right);
      if (!Character.isLetterOrDigit(rightChar) ) {
        right--;
        continue;
      }

      if (Character.isLetter(leftChar) && Character.isLetter(rightChar)) {
        leftChar = Character.toUpperCase(leftChar);
        rightChar = Character.toUpperCase(rightChar);
      }

      if (leftChar != rightChar)  return false;
      left++;
      right--;
    }

    return true;
  }
}