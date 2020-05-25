package com.htoyama.leetcode._337;

import com.htoyama.leetcode.utils.data.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    assertThat(s.rob(TreeNode.of(3, 2, 3, null, 3, null, 1))).isEqualTo(7);
    assertThat(s.rob(TreeNode.of(3, 4, 5, 1, 3, null, 1))).isEqualTo(9);
  }

  /**
   * 1700 ms	39.7 MB
   */
  public int rob(TreeNode root) {
    if (root == null) return 0;
    return Math.max(helper(root, true), helper(root, false));
  }

  private int helper(TreeNode root, boolean shouldSkip) {
    if (root == null) return 0;

    int skipLeft = helper(root.left, false);
    int skipRight = helper(root.right, false);
    if (shouldSkip) {
      return skipLeft + skipRight;
    }

    int robLeft = helper(root.left, true);
    int robRight = helper(root.right, true);
    return Math.max(skipLeft + skipRight, root.val + robLeft + robRight);
  }
}