package com.htoyama.leetcode._929;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(
      s.numUniqueEmails(new String[]{
        "test.email+alex@leetcode.com",
        "test.e.mail+bob.cathy@leetcode.com",
        "testemail+david@lee.tcode.com"}
      )
    );
  }

  /**
   * 5 ms	41.5 MB
   *
   * FYI: 22 ms	43 MB was the official solution.
   */
  public int numUniqueEmails(String[] emails) {
    HashSet<String> uniqueSet = new HashSet<>();

    for (String email : emails) {
      uniqueSet.add(format(email));
    }

    return uniqueSet.size();
  }

  /**
   * In the local name,
   * 1. (.) is ignored. (ab.@~ = ab@~ )
   * 2. every char after first (+) is ignored. (ab+cde@~ = ab@ ~)
   */
  private String format(String email) {
    char[] chars = email.toCharArray();

    StringBuilder local = new StringBuilder();
    int i = 0;
    boolean plusAppeared = false;
    while (i < chars.length) {
      char curr = chars[i++];
      if (curr == '@') break;
      if (plusAppeared || curr == '.') continue;

      if (curr == '+') {
        plusAppeared = true;
        continue;
      }
      local.append(curr);
    }

    return local
      .append("@")
      .append(email.substring(i))
      .toString();
  }
}
