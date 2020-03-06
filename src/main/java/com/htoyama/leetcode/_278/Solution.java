package com.htoyama.leetcode._278;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/first-bad-version/solution/
 */
public class Solution extends VersionControl {

  public static void main(String[] args) {
    Solution s = new Solution();
    s.badVersion = 4;
    assertThat(s.firstBadVersion(9)).isEqualTo(4);
    assertThat(s.firstBadVersion(4)).isEqualTo(4);
    assertThat(s.firstBadVersion(100)).isEqualTo(4);

    s.badVersion = 1;
    assertThat(s.firstBadVersion(9)).isEqualTo(1);

    s.badVersion = 10;
    assertThat(s.firstBadVersion(10)).isEqualTo(10);
  }

  public int firstBadVersion(int n) {
    int left = 0;
    int right = n;

    while (right - left > 1) {
      int mid = left + (right - left) / 2;

      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return right;
  }
}

class VersionControl {

  int badVersion;

  boolean isBadVersion(int version) {
    return version >= badVersion;
  }
}
